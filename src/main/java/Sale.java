import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Artem_Pryzhkov on 9/26/2016.
 */
public class Sale {
    private LocalDate date;
    private LocalTime time;
    private List<SaleItemLine> saleLineItems;

    public Sale() {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.saleLineItems=new ArrayList<>();
    }

    public int countTotalPrice(){
        int totalPrice=0;
        for(int i=0;i<saleLineItems.size();i++){
            totalPrice+=saleLineItems.get(i).priceProduct();
        }
        return totalPrice;
    }

    public void addProduct(String productName,int amount){
        saleLineItems.add(new SaleItemLine(productName,amount));
    }
}
