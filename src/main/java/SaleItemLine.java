/**
 * Created by Artem_Pryzhkov on 9/26/2016.
 */
public class SaleItemLine {
    private int quantity;
    private Product product;

    public SaleItemLine(String productKey,int quantity) {
        this.quantity = quantity;
        product=Product.getProductByName(productKey);
    }

    public int priceProduct(){
        return product.getPrice()*quantity;
    }
}
