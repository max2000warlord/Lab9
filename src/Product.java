import java.text.*;
import java.util.*;
import javafx.beans.property.*;
public class Product {
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();
    private final String name;
    private IntegerProperty stock = new SimpleIntegerProperty();
    private final double price;
    private IntegerProperty sold = new SimpleIntegerProperty();
    private IntegerProperty left = new SimpleIntegerProperty();
    private DoubleProperty cash = new SimpleDoubleProperty();

    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock.set(stock);
        this.price = price;
        sold.set(0);
        cash.bind(sold.multiply(price));
        left.bind(sold.subtract(stock).multiply(-1));
    }
    
    public final String getName() { return name; }
    public final int getStock() { return stock.get(); }
    public ReadOnlyIntegerProperty stockProperty() { return stock; }
    public final double getPrice() { return price;}
    public final int getSold() { return sold.get(); }
    public ReadOnlyIntegerProperty soldProperty() { return sold; }
    public final double getCash() { return cash.get(); }
    public ReadOnlyDoubleProperty incomeProperty() { return cash; }
    public final int getLeft() { return left.get(); }
    public ReadOnlyIntegerProperty leftProperty() { return left; }
    
    public void sell(int n) {
        stock.set(getStock() - n);
        double money = n * price;
        sold.set(getSold() + n);
        for (ProductObserver observer : observers)
            observer.handleSell(money);
    }
   
    public void restock(int n) {
        stock.set(getStock() + n);
    }

    public boolean has(int n) {
        return n <= getStock();
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }

    @Override
    public String toString() {
        return stock + " " + name + " at $" + price;
    }
}