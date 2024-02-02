package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.entities.EOCustProductStock;
import com.brijframework.production.cust.repository.CustProductStockRepository;
import com.brijframework.production.cust.rest.CustDashboardResponse;
import com.brijframework.production.cust.rest.CustDashboardStock;
import com.brijframework.production.cust.service.CustDashboardService;

@Service
public class CustDashboardServiceImpl implements CustDashboardService {

	@Autowired
	private CustProductStockRepository custProductStockRepository;

	@Override
	public CustDashboardResponse getDashboard(long custAppId) {
		CustDashboardResponse custDashboardResponse=new CustDashboardResponse();
		double totalGrossPurchase=0.0;
		double totalGrossSale=0.0;
		double totalNetPurchase=0.0;
		double totalNetSale=0.0;
		List<EOCustProductStock> custProductStocks = custProductStockRepository.findAllByCustBusinessAppId(custAppId);
		/*for(EOCustProductStock custProductStock : custProductStocks){
			EOCustProductPurchaseItem custProductPurchaseItem = custProductStock.getCustProductPurchaseItem();
			EOCustProductSaleItem custProductSaleItem = custProductStock.getCustProductSaleItem();
			if(custProductPurchaseItem !=null && custProductSaleItem!=null) {
				totalNetPurchase+=custProductPurchaseItem.getPurchasePrice().getPrice();
				totalNetSale+=custProductSaleItem.getSalePrice().getPrice();
			}
			totalGrossPurchase+=custProductPurchaseItem!=null && custProductPurchaseItem.getPurchasePrice() !=null? custProductPurchaseItem.getPurchasePrice().getPrice():0;
			totalGrossSale+=custProductSaleItem!=null && custProductSaleItem.getSalePrice()!=null? custProductSaleItem.getSalePrice().getPrice():0;
		};*/
		custDashboardResponse.setTotalNetPurchase(totalNetPurchase);
		custDashboardResponse.setTotalNetSale(totalNetSale);
		custDashboardResponse.setTotalNetProfit(totalNetSale-totalNetPurchase);
		custDashboardResponse.setTotalGrossPurchase(totalGrossPurchase);
		custDashboardResponse.setTotalGrossSale(totalGrossSale);
		custDashboardResponse.setTotalGrossProfit(totalGrossSale-totalGrossPurchase);
		
		custProductStocks.stream().collect(Collectors.groupingBy(EOCustProductStock::getCustProduct)).forEach((custProduct, custProductStockList)->{
			double totalGrossProductPurchase=0.0;
			double totalGrossProductSale=0.0;
			double totalGrossProductProfit=0.0;
			double percentageGrossProductProfit=0.0;
			double totalStockPrice=0.0;
			double totalStockQnt=0.0;
			double totalNetProductPurchase=0.0;
			double totalNetProductSale=0.0;
			double totalNetProductProfit=0.0;
			double percentageNetProductProfit=0.0;
			/*
			for(EOCustProductStock custProductStock : custProductStockList){
				EOCustProductPurchaseItem custProductPurchaseItem = custProductStock.getCustProductPurchaseItem();
				EOCustProductSaleItem custProductSaleItem = custProductStock.getCustProductSaleItem();
				if(custProductPurchaseItem !=null && custProductSaleItem!=null) {
					totalNetProductPurchase+=custProductPurchaseItem.getPurchasePrice().getPrice();
					totalNetProductSale+=custProductSaleItem.getSalePrice().getPrice();
				}
				
				totalGrossProductPurchase+=custProductPurchaseItem!=null && custProductPurchaseItem.getPurchasePrice() !=null? custProductPurchaseItem.getPurchasePrice().getPrice():0;
				totalGrossProductSale+=custProductSaleItem!=null && custProductSaleItem.getSalePrice()!=null? custProductSaleItem.getSalePrice().getPrice():0;
				if(custProductSaleItem==null && custProductPurchaseItem!=null) {
					totalStockPrice=custProductPurchaseItem.getPurchasePrice().getPrice()*custProductPurchaseItem.getPurchaseQnt();
					totalStockQnt=totalStockQnt+1;
				}
			}
			*/
			totalNetProductProfit=totalNetProductSale-totalNetProductPurchase;
			
			percentageNetProductProfit= totalNetProductSale>0 ?(totalNetProductProfit/totalNetProductSale) * 100 : 0.00;
			
			totalGrossProductProfit=totalGrossProductSale-totalGrossProductPurchase;
			
			percentageGrossProductProfit= totalGrossProductSale>0 ?(totalGrossProductProfit/totalGrossProductSale) * 100 : 0.00;
			
			CustDashboardStock custDashboardStock=new CustDashboardStock(); 
			custDashboardStock.setName(custProduct.finalName());
			
			custDashboardStock.setTotalNetPurchase(totalNetProductPurchase);
			custDashboardStock.setTotalNetSale(totalNetProductSale);
			custDashboardStock.setTotalNetProfit(totalNetProductProfit);
			custDashboardStock.setPercentageNetProfit(percentageNetProductProfit);
			
			custDashboardStock.setTotalGrossPurchase(totalGrossProductPurchase);
			custDashboardStock.setTotalGrossSale(totalGrossProductSale);
			custDashboardStock.setTotalGrossProfit(totalGrossProductProfit);
			custDashboardStock.setPercentageGrossProfit(percentageGrossProductProfit);
			
			custDashboardStock.setTotalStockPrice(totalStockPrice);
			custDashboardStock.setTotalStockQnt(totalStockQnt);
			
			custDashboardResponse.getStocks().add(custDashboardStock);
		});
		return custDashboardResponse;
	}
	
}
