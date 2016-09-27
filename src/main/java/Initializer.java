import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by Artem_Pryzhkov on 9/27/2016.
 */
public class Initializer {

    public static Cash init(){
        NavigableMap<Integer,Integer> availableCoins=new TreeMap<>();
        availableCoins.put(1,0);
        availableCoins.put(5,0);
        availableCoins.put(10,50);
        availableCoins.put(25,50);
        availableCoins.put(50,50);
        return new Cash(availableCoins);
    }
}
