package com.beans;
import java.util.Date;

public class Order {
	private Integer orderNumber;
	private Integer goodsCode;
	private String goodsName;
	private Double salesPrice;
	private String quantity;
	private Date orderDate;
	private Double sum;
	
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Integer getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(Integer goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	 public Date getOrderDate() {
	    return orderDate;
	}

	 public void setOrderDate(Date orderDate) {
	    this.orderDate = orderDate;
	 }
	public Double getSum() {
		return sum;
	}
	
	public void setSum(Double sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", goodsCode=" + goodsCode + ", goodsName=" + goodsName
				+ ", salesPrice=" + salesPrice + ", quantity=" + quantity + ", orderDate=" + orderDate + ", sum=" + sum
				+ "]";
	}
}
