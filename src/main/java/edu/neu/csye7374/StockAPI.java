package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

abstract class StockAPI {
    protected String id;
    protected double price;
    protected String description;
    protected List<Double> bids;

    public StockAPI(String id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.bids = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("Stock[ID=%s, Price=%.2f, Description=%s]", id, price, description);
    }
}