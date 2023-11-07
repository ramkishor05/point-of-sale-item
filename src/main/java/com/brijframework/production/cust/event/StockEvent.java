package com.brijframework.production.cust.event;

public class StockEvent {
	
	private Long orderItemId; 
	private Long productId;
	
	public StockEvent() {
	}

	public StockEvent(Long orderItemId, Long productId) {
		this.orderItemId=orderItemId;
		this.productId=productId;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	

}
