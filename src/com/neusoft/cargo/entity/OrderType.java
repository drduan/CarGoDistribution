package com.neusoft.cargo.entity;

public enum OrderType {

	/*
	 * mstatus 订单状态
	 * 
	 * 0. 确认中 1. 等待审核 2. 等待支付 3. 订单建立 4. 运输中 5. 订单完成 //交易成功 6. 订单取消 //交易未成功 7.
	 * 取消 加一个上传 当前位置
	 * 
	 */

	WAITINGACCESS("WAITINGACCESS"),
	PENDING("pending"), 
	COMPLETED("completed"),
	RECEIVED("received"),
	CANCEL("cancel"),
	NOT_PAID("not_paid"),
	PAID("paid"),
	DISPATCHED("dispatched");

	private String orderType;

	private OrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public static OrderType getOrderEnum(String OrderValue) {
		for (OrderType orderType : OrderType.values()) {
			if (orderType.orderType.equals(OrderValue))
				return orderType;
		}
		return null;
	}
}
