package model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class SaleOrder {
	
	private int id;
	private Date date;
	private BigDecimal amount;
	private String deliveryStatus;
	private Date deliveryDate;
	private int customerId;
	private int invoiceNumber;
	private OrderLine orderLine;
	
	public SaleOrder(int id, Date date, BigDecimal amount, String deliveryStatus, Date deliveryDate, int customerId, int invoiceNumber, OrderLine orderLine) {
		this.date = date;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.id = id;
		this.customerId = customerId;
		this.invoiceNumber = invoiceNumber;
		this.orderLine = orderLine;
	}
	
	public void addProduct(int p, int amount) {
		this.orderLine.addProduct(p, amount);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}
}
