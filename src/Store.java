public class Store {
    private CashRegister cashRegister;
    private Product product;

    public Store() {
        cashRegister = new CashRegister();
        product = new Product("Sticky tape", 200, 2.99);
        product.addProductObserver(cashRegister);
    }
    
    public Product getProduct(){return product;}
    public CashRegister getCashRegister(){return cashRegister;}
}

