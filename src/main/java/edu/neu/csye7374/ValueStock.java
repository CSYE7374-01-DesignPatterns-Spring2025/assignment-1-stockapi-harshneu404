package edu.neu.csye7374;

class ValueStock extends StockAPI implements Tradable {
    private int stabilityIndex;

    public ValueStock(String id, double price, String description) {
        super(id, price, description);
        this.stabilityIndex = 0;
    }

    @Override
    public void setBid(String bid) {
        double bidPrice = Double.parseDouble(bid);
        bids.add(bidPrice);
        price = bidPrice;
        calculateStabilityIndex();
    }

    private void calculateStabilityIndex() {
        if (bids.size() > 2) {
            double average = bids.stream().mapToDouble(Double::doubleValue).average().orElse(0);
            stabilityIndex = (int) (price - average);
        }
    }

    @Override
    public int getMetric() {
        return stabilityIndex;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", StabilityIndex=%d", stabilityIndex);
    }
}