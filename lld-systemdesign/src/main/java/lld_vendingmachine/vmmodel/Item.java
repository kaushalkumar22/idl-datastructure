package lld_vendingmachine.vmmodel;

public enum Item {

    COKE(100, 25), CHOCOLATE(101, 20), CAKE(102, 10);
    private int code;
    private int price;

    Item(int code, int price) {
        this.code = code;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }
}
