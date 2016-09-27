import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

/**
 * Created by Artem_Pryzhkov on 9/26/2016.
 */
public class Pos {

    private int inputValue;
    private Cash cash;
    private Sale sale;

    public Pos() {
        this.cash = Initializer.init();
        this.sale = new Sale();
    }

    public void reset() {
        cash.getChange(inputValue);
    }


    private NavigableMap<Integer,Integer> change() {
        int changeValue = inputValue - getFullPrice();
        if (changeValue >= 0) {
            return cash.getChange(changeValue);
        }
        return null;
    }

    private void addCoin(int coinValue)  {
        cash.add(coinValue);
        inputValue += coinValue;
    }

    public void addProduct(String productName, int amount) {
        sale.addProduct(productName, amount);
    }

    public int getFullPrice() {
        return sale.countTotalPrice();
    }

    public NavigableMap<Integer,Integer> paymentProcess(int coinValue){
        if (isValidCoinValue(coinValue)) {
            addCoin(coinValue);
            return change();
        } else {
            throw new IllegalArgumentException("unavailable coin");
        }

    }

    private boolean isValidCoinValue(int coinValue) {
        return cash.getAllCoins().containsKey(coinValue);
    }
}