import java.text.*;
import javafx.beans.property.*;
public class CashRegister implements ProductObserver {
    private DoubleProperty cash = new SimpleDoubleProperty();
    private DoubleProperty income = new SimpleDoubleProperty();

    public CashRegister() {
        cash.set(0);
    }
    
    public ReadOnlyDoubleProperty cashProperty() { return income; }

    public void add(double money) {
        cash.set(money);
    }
    
    public double getCash(){
    return cash.get();
    }

    @Override
    public void handleSell(double amount) {
        add(amount);
    }
}