package edu.neu.csye7374;

class GrowthStock extends StockAPI implements Tradable {
    private double growthRate;

    public GrowthStock(String id, double price, String description) {
        super(id, price, description);
        this.growthRate = 0;
    }

    @Override
    public void setBid(String bid) {
        double bidPrice = Double.parseDouble(bid);
        bids.add(bidPrice);
        price = bidPrice;
        calculateGrowthRate();
    }

    private void calculateGrowthRate() {
        if (bids.size() > 1) {
            double previousPrice = bids.get(bids.size() - 2);
            growthRate = ((price - previousPrice) / previousPrice) * 100;
        }
    }

    @Override
    public int getMetric() {
        return (int) growthRate;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", GrowthRate=%.2f%%", growthRate);
    }
}
