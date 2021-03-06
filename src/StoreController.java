import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.DecimalFormat;

public class StoreController {
    private Store store = new Store();
    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;
    @FXML private Text nameTxt;
    
    public final Store getStore(){ return store; }
    private final int getAmount() { return Integer.parseInt(amountTf.getText()); }
    private final void setAmount(int amount) { amountTf.setText(""+amount); }
    private final int getStock(int stock){return Integer.parseInt(stockTxt.getText());}
    
    @FXML private void initialize() {
    }

    @FXML private void handleSell(ActionEvent event) {
        Product product = getStore().getProduct();
        int amount = getAmount();
        if (product.has(amount))
            product.sell(amount);
        setAmount(0);
    }
}