package com.brijframework.production.cust.rest;

import java.util.ArrayList;
import java.util.List;

public class CustDashboardResponse {
	
	private double totalGrossPurchase=0.0;
	private double totalGrossSale=0.0;
	private double totalGrossProfit;
	private double percentageGrossProfit;

	private double totalNetPurchase=0.0;
	private double totalNetSale=0.0;
	private double totalNetProfit;
	private double percentageNetProfit;

	private List<CustDashboardStock> stocks;

	public double getTotalGrossPurchase() {
		return totalGrossPurchase;
	}

	public void setTotalGrossPurchase(double totalGrossPurchase) {
		this.totalGrossPurchase = totalGrossPurchase;
	}

	public double getTotalGrossSale() {
		return totalGrossSale;
	}

	public void setTotalGrossSale(double totalGrossSale) {
		this.totalGrossSale = totalGrossSale;
	}

	public double getTotalGrossProfit() {
		return totalGrossProfit;
	}

	public void setTotalGrossProfit(double totalGrossProfit) {
		this.totalGrossProfit = totalGrossProfit;
	}

	public double getPercentageGrossProfit() {
		return percentageGrossProfit;
	}

	public void setPercentageGrossProfit(double percentageGrossProfit) {
		this.percentageGrossProfit = percentageGrossProfit;
	}

	public double getTotalNetPurchase() {
		return totalNetPurchase;
	}

	public void setTotalNetPurchase(double totalNetPurchase) {
		this.totalNetPurchase = totalNetPurchase;
	}

	public double getTotalNetSale() {
		return totalNetSale;
	}

	public void setTotalNetSale(double totalNetSale) {
		this.totalNetSale = totalNetSale;
	}

	public double getTotalNetProfit() {
		return totalNetProfit;
	}

	public void setTotalNetProfit(double totalNetProfit) {
		this.totalNetProfit = totalNetProfit;
	}

	public double getPercentageNetProfit() {
		return percentageNetProfit;
	}

	public void setPercentageNetProfit(double percentageNetProfit) {
		this.percentageNetProfit = percentageNetProfit;
	}

	public List<CustDashboardStock> getStocks() {
		if(stocks==null) {
			setStocks(new ArrayList<CustDashboardStock>());
		}
		return stocks;
	}

	public void setStocks(List<CustDashboardStock> stocks) {
		this.stocks = stocks;
	}
	
}
