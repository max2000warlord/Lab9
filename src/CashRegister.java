import java.text.*;
import javafx.beans.property.*;
public class CashRegister implements ProductObserver {
    private DoubleProperty cash = new SimpleDoubleProperty();

    public CashRegister() {
        cash.set(0);
    }
    
    public ReadOnlyDoubleProperty cashProperty() { return cash; }

    public void add(double money) {
        cash.set(money);
    }
    
    public double getCash(){
    return cash.get();
    }

    @Override
    public void handleSell(double amount) {
        DecimalFormat df =  new DecimalFormat("###,##0.00");
        add(Double.parseDouble(df.format(amount)));
    }

}