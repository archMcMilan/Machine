import java.util.*;

/**
 * Created by Artem_Pryzhkov on 9/26/2016.
 */
public class Cash {
    private NavigableMap<Integer,Integer> allCoins;

    public Cash(NavigableMap <Integer, Integer> allCoins) {
        this.allCoins = allCoins;
    }

    public Map<Integer, Integer> getAllCoins() {
        return allCoins;
    }

    public void add(int value){
        allCoins.put(value,allCoins.get(value)+1);
    }

    public boolean isChangeAvailable(int value,NavigableMap<Integer,Integer> outputCoins){
        for(Integer coinValue:allCoins.descendingKeySet()){
            int coinsAmount=value/coinValue;
            int availableCoinsAmount=allCoins.get(coinValue);
            value = balanceValue(value, outputCoins, coinValue, coinsAmount, availableCoinsAmount);
        }
        if(value==0)
            return true;
        else
            return false;
    }

    private int balanceValue(int value, NavigableMap<Integer, Integer> outputCoins, Integer coinValue, int coinsAmount,
                             int availableCoinsAmount) {
        if(availableCoinsAmount>=coinsAmount){
            value-=coinsAmount*coinValue;
            outputCoins.put(coinValue,coinsAmount);
        }else{
            value-=availableCoinsAmount*coinValue;
            outputCoins.put(coinValue,availableCoinsAmount);
        }
        return value;
    }

    public NavigableMap<Integer,Integer> getChange(int value){
        NavigableMap<Integer,Integer> outputCoins=new TreeMap<>();
        if(isChangeAvailable(value,outputCoins)){
            for(Integer coinValue:allCoins.descendingKeySet()){
                allCoins.put(coinValue,allCoins.get(coinValue)-outputCoins.get(coinValue));
            }
            return outputCoins;
        }
        return null;
    }

}
