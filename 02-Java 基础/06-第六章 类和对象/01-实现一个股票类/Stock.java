public class Stock {
    // 股票编码
    private String symbol;
    // 股票名称
    private String name;
    // 前一日市值
    private double previousClosingPrice;
    // 当前市值
    private double currentPrice ;

    public Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.previousClosingPrice = previousClosingPrice;
        this.currentPrice = currentPrice;
    }

    public String getChangePercent(){
        double price = (currentPrice-previousClosingPrice)/previousClosingPrice;
        return price*100+"%";
    }

}