package edu.neu.csye7374;

/**
 * 
 * @author Yesha
 * 
 */

public class Driver {
	public static void main(String[] args) {
		System.out.println("============Main Execution Start===================\n\n");

		 GrowthStock growthStock = new GrowthStock("TSLA", 250.00, "Tesla Growth Stock");
	        ValueStock valueStock = new ValueStock("AAPL", 175.00, "Apple Value Stock");

	        // Simulating bids
	        String[] growthBids = {"260.00", "270.00", "280.00", "290.00", "300.00", "310.00"};
	        String[] valueBids = {"178.00", "176.00", "174.00", "180.00", "182.00", "179.00"};

	        System.out.println("Growth Stock Changes:");
	        for (String bid : growthBids) {
	            growthStock.setBid(bid);
	            System.out.println(growthStock + ", Metric=" + growthStock.getMetric());
	        }

	        System.out.println("\nValue Stock Changes:");
	        for (String bid : valueBids) {
	            valueStock.setBid(bid);
	            System.out.println(valueStock + ", Metric=" + valueStock.getMetric());
	        }

		 
		System.out.println("\n\n============Main Execution End===================");
	}

}
