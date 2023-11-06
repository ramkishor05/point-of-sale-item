package com.brijframework.production.cust.rest;

public class CustDashboardStock {

	private String name;
	
	private double totalGrossPurchase=0.0;
	private double totalGrossSale=0.0;
	private double totalGrossProfit;
	private double percentageGrossProfit;

	private double totalStockPrice=0.0;
	private double totalStockQnt=0.0;
	
	private double totalNetPurchase=0.0;
	private double totalNetSale=0.0;
	private double totalNetProfit;
	private double percentageNetProfit;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public double getTotalStockPrice() {
		return totalStockPrice;
	}

	public void setTotalStockPrice(double totalStockPrice) {
		this.totalStockPrice = totalStockPrice;
	}

	public double getTotalStockQnt() {
		return totalStockQnt;
	}

	public void setTotalStockQnt(double totalStockQnt) {
		this.totalStockQnt = totalStockQnt;
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

	
}
