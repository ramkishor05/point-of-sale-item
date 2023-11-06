package com.brijframework.production.cust.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.contants.StockStatus;
import com.brijframework.production.cust.entities.EOCustProductStock;
import com.brijframework.production.cust.entities.EOCustProductStockPrice;
import com.brijframework.production.cust.entities.purchases.EOCustProductPurchaseItem;
import com.brijframework.production.cust.entities.purchases.EOCustProductPurchaseItemPrice;
import com.brijframework.production.cust.entities.sales.EOCustProductSaleItem;
import com.brijframework.production.cust.entities.sales.EOCustProductSaleItemPrice;
import com.brijframework.production.cust.repository.CustProductStockRepository;
import com.brijframework.production.cust.rest.CustProductStockResponse;
import com.brijframework.production.cust.service.CustProductStockService;
import com.brijframework.production.util.CommanUtil;

@Service
public class CustProductStockServiceImpl implements CustProductStockService {

	private static final String STK = "STK";

	@Autowired
	private CustProductStockRepository custProductStockRepository;
	
	@Override
	public void saveCustProductStocksBackground(EOCustProductPurchaseItem eoCustProductSaleItem) {
		new Thread(()->{
			saveCustProductStocks(eoCustProductSaleItem);
		}).start();
	}

	@Override
	public void saveCustProductStocks(EOCustProductPurchaseItem eoCustProductRetailPurchase) {
		List<EOCustProductStock> custProductPurchaseItemStockList = custProductStockRepository
				.findAllByCustProductPurchaseItemId(eoCustProductRetailPurchase.getId());
		if (custProductPurchaseItemStockList.isEmpty()) {
			checkAndUpdateCustProductStockList(eoCustProductRetailPurchase,
					eoCustProductRetailPurchase.getPurchaseQnt().longValue());
		} else {
			if (custProductPurchaseItemStockList.size() != eoCustProductRetailPurchase.getPurchaseQnt().intValue()) {
				if (custProductPurchaseItemStockList.size() > eoCustProductRetailPurchase.getPurchaseQnt().intValue()) {
					int deleteQnt = custProductPurchaseItemStockList.size()
							- eoCustProductRetailPurchase.getPurchaseQnt().intValue();
					List<EOCustProductStock> nonSaleCustProductStockList = custProductPurchaseItemStockList.stream()
							.filter(custProductPurchaseItemStock -> custProductPurchaseItemStock
									.getCustProductSaleItem() == null)
							.collect(Collectors.toList());
					if (nonSaleCustProductStockList.size() >= deleteQnt) {
						List<EOCustProductStock> deleteStocks = nonSaleCustProductStockList.stream()
								.sorted((s1, s2) -> s2.getCreatedAt().compareTo(s1.getCreatedAt())).limit(deleteQnt)
								.collect(Collectors.toList());
						custProductStockRepository.deleteAll(deleteStocks);
					}
				} else {
					Long newQnt = eoCustProductRetailPurchase.getPurchaseQnt().longValue()
							- custProductPurchaseItemStockList.size();
					checkAndUpdateCustProductStockList(eoCustProductRetailPurchase, newQnt);
				}
			}
		}
	}

	private void checkAndUpdateCustProductStockList(EOCustProductPurchaseItem eoCustProductPurchaseItem, Long addQnt) {
		List<EOCustProductStock> custProductStockList = custProductStockRepository
				.findAllByCustProductIdOfPurchase(eoCustProductPurchaseItem.getCustProduct().getId());
		if (custProductStockList.isEmpty()) {
			List<EOCustProductStock> addStocks = buildStocks(eoCustProductPurchaseItem, addQnt);
			custProductStockRepository.saveAll(addStocks);
		} else {
			Long count = 0l;
			List<EOCustProductStock> addStocks = new ArrayList<EOCustProductStock>();
			for (EOCustProductStock custProductStock : custProductStockList) {
				custProductStock.setCustProductPurchaseItem(eoCustProductPurchaseItem);
				custProductStock.setPurchasePrice(buildStockPrice(eoCustProductPurchaseItem.getPurchasePrice()));
				custProductStock.setStockStatus(
						custProductStock.getCustProductSaleItem() != null ? StockStatus.OutStock : StockStatus.InStock);
				count++;
				addStocks.add(custProductStock);
				if (addQnt == count) {
					break;
				}
			}
			if (addStocks.size() < addQnt.intValue()) {
				long newQnt = addQnt - addStocks.size();
				addStocks.addAll(buildStocks(eoCustProductPurchaseItem, newQnt));
			}
			custProductStockRepository.saveAll(addStocks);
		}
	}

	private List<EOCustProductStock> buildStocks(EOCustProductPurchaseItem eoCustProductRetailPurchase, Long newQnt) {
		List<EOCustProductStock> buildStocks = new ArrayList<EOCustProductStock>();
		for (int i = 0; i < newQnt; i++) {
			buildStocks.add(buildStock(eoCustProductRetailPurchase));
		}
		return buildStocks;
	}

	private EOCustProductStock buildStock(EOCustProductPurchaseItem eoCustProductRetailPurchase) {
		EOCustProductStock eoCustProductStock = new EOCustProductStock();
		eoCustProductStock.setCustProductPurchaseItem(eoCustProductRetailPurchase);
		eoCustProductStock.setCustBusinessApp(eoCustProductRetailPurchase.getCustProduct().getCustBusinessApp());
		eoCustProductStock.setCustProduct(eoCustProductRetailPurchase.getCustProduct());
		eoCustProductStock.setDescription(eoCustProductRetailPurchase.getDescription());
		eoCustProductStock.setIdenNo(CommanUtil.getIdenNo(STK));
		eoCustProductStock.setLogoUrl(eoCustProductRetailPurchase.getCustProduct().getLogoUrl());
		eoCustProductStock.setName(eoCustProductRetailPurchase.getName());
		eoCustProductStock.setStockStatus(StockStatus.InStock);
		eoCustProductStock.setPurchasePrice(buildStockPrice(eoCustProductRetailPurchase.getPurchasePrice()));
		return eoCustProductStock;
	}

	private EOCustProductStockPrice buildStockPrice(EOCustProductPurchaseItemPrice custProductPurchaseItemPrice) {
		EOCustProductStockPrice eoCustProductStockPrice = new EOCustProductStockPrice();
		eoCustProductStockPrice.setPrice(custProductPurchaseItemPrice.getPrice());
		eoCustProductStockPrice.setCurrency(custProductPurchaseItemPrice.getCurrency());
		return eoCustProductStockPrice;
	}
	
	@Override
	public void saveCustProductStocksBackground(EOCustProductSaleItem eoCustProductSaleItem) {
		new Thread(()->{
			saveCustProductStocks(eoCustProductSaleItem);
		}).start();
	}

	@Override
	public void saveCustProductStocks(EOCustProductSaleItem eoCustProductRetailSale) {
		List<EOCustProductStock> custProductSaleItemStockList = custProductStockRepository
				.findAllByCustProductSaleItemId(eoCustProductRetailSale.getId());
		if (custProductSaleItemStockList.isEmpty()) {
			List<EOCustProductStock> custProductStockList = custProductStockRepository
					.findAllByCustProductIdOfSale(eoCustProductRetailSale.getCustProduct().getId());
			if (custProductStockList.isEmpty()) {
				List<EOCustProductStock> addStocks = buildStocks(eoCustProductRetailSale,
						eoCustProductRetailSale.getSaleQnt().longValue());
				custProductStockRepository.saveAll(addStocks);
			} else {
				int count = 0;
				List<EOCustProductStock> addStocks = new ArrayList<EOCustProductStock>();
				for (EOCustProductStock custProductStock : custProductStockList) {
					custProductStock.setCustProductSaleItem(eoCustProductRetailSale);
					custProductStock.setSalePrice(buildStockPrice(eoCustProductRetailSale.getSalePrice()));
					custProductStock
							.setStockStatus(custProductStock.getCustProductPurchaseItem() != null ? StockStatus.OutStock
									: StockStatus.PendingStock);
					count++;
					addStocks.add(custProductStock);
					if (eoCustProductRetailSale.getSaleQnt().intValue() == count) {
						break;
					}
				}
				if (addStocks.size() < eoCustProductRetailSale.getSaleQnt().intValue()) {
					long newQnt = eoCustProductRetailSale.getSaleQnt().intValue() - addStocks.size();
					addStocks.addAll(buildStocks(eoCustProductRetailSale, newQnt));
				}
				custProductStockRepository.saveAll(addStocks);
			}
		} else {
			System.out.println(
					"custProductSaleItemStockList.size()!=eoCustProductRetailPurchase.getPurchaseQnt().intValue()========"
							+ (custProductSaleItemStockList.size() != eoCustProductRetailSale.getSaleQnt().intValue()));

			if (custProductSaleItemStockList.size() != eoCustProductRetailSale.getSaleQnt().intValue()) {
				System.out.println(
						"custProductPurchaseItemStockList.size()> eoCustProductRetailPurchase.getPurchaseQnt().intValue()="
								+ (custProductSaleItemStockList.size() > eoCustProductRetailSale.getSaleQnt()
										.intValue()));
				if (custProductSaleItemStockList.size() > eoCustProductRetailSale.getSaleQnt().intValue()) {
					int deleteQnt = custProductSaleItemStockList.size()
							- eoCustProductRetailSale.getSaleQnt().intValue();
					System.out.println("deleteQnt=" + deleteQnt);
					List<EOCustProductStock> nonSaleCustProductStockList = custProductSaleItemStockList.stream()
							.filter(custProductPurchaseItemStock -> custProductPurchaseItemStock
									.getCustProductSaleItem() != null)
							.collect(Collectors.toList());
					System.out.println("nonSaleCustProductStockList.size()>=deleteQnt="
							+ (nonSaleCustProductStockList.size() >= deleteQnt));
					if (nonSaleCustProductStockList.size() >= deleteQnt) {
						List<EOCustProductStock> deleteStocks = nonSaleCustProductStockList.stream()
								.sorted((s1, s2) -> s2.getCreatedAt().compareTo(s1.getCreatedAt())).limit(deleteQnt)
								.collect(Collectors.toList());
						deleteStocks.forEach(nonSaleCustProductStoc -> {
							nonSaleCustProductStoc.setCustProductSaleItem(null);
							nonSaleCustProductStoc.setSalePrice(null);
							nonSaleCustProductStoc.setStockStatus(
									nonSaleCustProductStoc.getCustProductPurchaseItem() != null ? StockStatus.InStock
											: StockStatus.PendingStock);
						});
						custProductStockRepository.saveAll(deleteStocks);
					}
				} else {
					long newQnt = eoCustProductRetailSale.getSaleQnt() - custProductSaleItemStockList.size();
					System.out.println("newQnt=" + (newQnt));
					List<EOCustProductStock> addStocks = buildStocks(eoCustProductRetailSale, newQnt);
					custProductStockRepository.saveAll(addStocks);
				}
			}
		}

	}

	private List<EOCustProductStock> buildStocks(EOCustProductSaleItem eoCustProductRetailSale, long newQnt) {
		List<EOCustProductStock> buildStocks = new ArrayList<EOCustProductStock>();
		for (int i = 0; i < newQnt; i++) {
			buildStocks.add(buildStock(eoCustProductRetailSale));
		}
		return buildStocks;
	}

	private EOCustProductStock buildStock(EOCustProductSaleItem eoCustProductRetailSale) {
		EOCustProductStock eoCustProductStock = new EOCustProductStock();
		eoCustProductStock.setCustProductSaleItem(eoCustProductRetailSale);
		eoCustProductStock.setCustBusinessApp(eoCustProductRetailSale.getCustProduct().getCustBusinessApp());
		eoCustProductStock.setCustProduct(eoCustProductRetailSale.getCustProduct());
		eoCustProductStock.setDescription(eoCustProductRetailSale.getDescription());
		eoCustProductStock.setIdenNo(CommanUtil.getIdenNo(STK));
		eoCustProductStock.setLogoUrl(eoCustProductRetailSale.getCustProduct().getLogoUrl());
		eoCustProductStock.setName(eoCustProductRetailSale.getName());
		eoCustProductStock.setStockStatus(StockStatus.PendingStock);
		eoCustProductStock.setPurchasePrice(buildStockPrice(eoCustProductRetailSale.getPurchasePrice()));
		eoCustProductStock.setSalePrice(buildStockPrice(eoCustProductRetailSale.getSalePrice()));
		return eoCustProductStock;
	}

	private EOCustProductStockPrice buildStockPrice(EOCustProductSaleItemPrice custProductSaleItemPrice) {
		if (custProductSaleItemPrice == null) {
			return null;
		}
		EOCustProductStockPrice eoCustProductStockPrice = new EOCustProductStockPrice();
		eoCustProductStockPrice.setPrice(custProductSaleItemPrice.getPrice());
		eoCustProductStockPrice.setCurrency(custProductSaleItemPrice.getCurrency());
		return eoCustProductStockPrice;
	}

	@Override
	public List<CustProductStockResponse> getProductStockList(long custAppId, Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProductStock(long custAppId, long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
