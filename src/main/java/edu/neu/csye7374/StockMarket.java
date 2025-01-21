package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private List<StockAPI> stocks = new ArrayList<>();

    private StockMarket() {
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }

        return instance;
    }

    public void addStock(StockAPI stock) {
        stocks.add(stock);
    }

    public boolean removeStock(StockAPI stock) {
        return stocks.remove(stock);
    }

    public void displayAllStocks() {
        stocks.forEach(stock -> System.out.println(stock.toString()));
    }

    public void tradeStock(StockAPI stock, String bid) {
        stock.setBid(bid);
        System.out.println(stock);
    }

    public void initializeBiding(StockAPI stock, String[] bids) {
        for (String bid : bids) {
            tradeStock(stock, bid);
        }
    }

    public static void demo() {
        StockMarket stockMarket = StockMarket.getInstance();

        System.out.println("======= IBM Stock Bid Start ======= ");
        StockAPI stock = new StockAPI("IBM", 131.15, "IBM Common Stock");
        stockMarket.addStock(stock);
        stockMarket.initializeBiding(stock, new String[]{"90", "100", "90", "80", "150", "155"});
        System.out.println("\n");

        System.out.println("======= Tesla Stock Bid Start ======= ");
        StockAPI teslaStock = new TeslaStock(100);
        stockMarket.addStock(teslaStock);
        stockMarket.initializeBiding(teslaStock, new String[]{"120", "100", "60", "80", "130", "135"});
        System.out.println("\n");

        System.out.println("======= Google Stock Bid Start ======= ");
        StockAPI googleStock = new GoogleStock(250);
        stockMarket.addStock(googleStock);
        stockMarket.initializeBiding(googleStock, new String[]{"260", "280", "230", "275", "275", "290"});
        System.out.println("\n");

        System.out.println("======= All Stock Information ======= ");
        StockMarket.getInstance().displayAllStocks();
        System.out.println("\n");
    }
}
