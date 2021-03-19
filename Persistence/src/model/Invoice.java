package model;

import java.time.LocalDateTime;

public class Invoice {
	private int invoiceNo;
	private LocalDateTime paymentDate;
	private int amount;
	
	public Invoice(int invoiceNo, LocalDateTime paymentDate, int amount) {
		this.setInvoiceNo(invoiceNo);
		this.setPaymentDate(paymentDate);
		this.setAmount(amount);
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}