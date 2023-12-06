package org.makerminds.restauantApp.model.order;

public class OrderAmount {

	private double totalOderAmount;
	private double totalOrderAmountVAT;
	private double totalOrderAmountWithVAT;
	
	public OrderAmount(double totalOderAmount, double totalOrderAmountVAT, double totalOrderAmountWithVAT) {
		this.totalOderAmount = totalOderAmount;
		this.totalOrderAmountVAT = totalOrderAmountVAT;
		this.totalOrderAmountWithVAT = totalOrderAmountWithVAT;
	}

	public double getTotalOderAmount() {
		return totalOderAmount;
	}

	public void setTotalOderAmount(double totalOderAmount) {
		this.totalOderAmount = totalOderAmount;
	}

	public double getTotalOrderAmountVAT() {
		return totalOrderAmountVAT;
	}

	public void setTotalOrderAmountVAT(double totalOrderAmountVAT) {
		this.totalOrderAmountVAT = totalOrderAmountVAT;
	}

	public double getTotalOrderAmountWithVAT() {
		return totalOrderAmountWithVAT;
	}

	public void setTotalOrderAmountWithVAT(double totalOrderAmountWithVAT) {
		this.totalOrderAmountWithVAT = totalOrderAmountWithVAT;
	}
	
	
	
	
}
