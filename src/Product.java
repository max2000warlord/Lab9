import java.text.*;
import java.util.*;
import javafx.beans.property.*;
public class Product {
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();
    private final StringProperty name = new SimpleStringProperty();
    private IntegerProperty stock = new SimpleIntegerProperty();
    private final DoubleProperty price = new SimpleDoubleProperty();
    private IntegerProperty sold = new SimpleIntegerProperty();
    private IntegerProperty left = new SimpleIntegerProperty();
    private DoubleProperty cash = new SimpleDoubleProperty();

    public Product(String name, int stock, double price) {
        this.name.set(name);
        this.stock.set(stock);
        this.price.set(price);
        left.bind(sold.subtract(stock).multiply(-1));
    }

    public final String getName() { return name.get(); }
    public ReadOnlyStringProperty nameProperty() { return name; }
    public final int getStock() { return stock.get(); }
    public ReadOnlyIntegerProperty stockProperty() { return stock; }
    public final double getPrice() { return price.get();}
    public ReadOnlyDoubleProperty priceProperty() { return price; }
    public final int getSold() { return sold.get(); }
    public ReadOnlyIntegerProperty soldProperty() { return sold; }
    public double getCash() { return cash.get(); }
    
    public final int getLeft() { return left.get(); }
    public ReadOnlyIntegerProperty leftProperty() { return left; }
    
    public void sell(int n) {
        stock.set(getStock() - n);
        cash.add(price.multiply(n));
        sold.set(getSold() + n);
        for (ProductObserver observer : observers)
            observer.handleSell(getCash());
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