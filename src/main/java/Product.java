/**
 * Created by Artem_Pryzhkov on 9/26/2016.
 */
public enum Product {
    TEA(25),COFFEE(35),JUICE(45);

    private int price;

    Product(int price){
        this.price=price;
    }

    public int getPrice() {
        return price;
    }

    public static Product getProductByName(String name){
        for (Product product : Product.values()) {
            if(product.name().equals(name)){
                return product;
            }
        }
        return null;
    }
}
