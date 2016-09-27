import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;

/**
 * Created by Artem_Pryzhkov on 9/26/2016.
 */
public class Client {
    Pos pos;

    public Client() {
        this.pos = new Pos();
    }

    public void productReader(){
        System.out.println("Input product name");
        Scanner sc=new Scanner(System.in);
        String productName=sc.next();

        System.out.println("input amount");
        int amount=sc.nextInt();
        pos.addProduct(productName,amount);
    }

    public boolean coinReader(){
        System.out.println("input coin value");
        Scanner sc=new Scanner(System.in);
        int coinValue=sc.nextInt();
        NavigableMap<Integer,Integer> changeCoinsMap=null;
        try{
            changeCoinsMap=pos.paymentProcess(coinValue);
        }catch (IllegalArgumentException e){
            System.out.println("input unavailable coin");
        }

        if(changeCoinsMap!=null){
            System.out.println("Your change");
            printAllCoins(changeCoinsMap);
            return true;
        }
        return false;
    }

    public void cashToPay(){
        System.out.println("full price="+pos.getFullPrice());
    }

    private void printAllCoins(NavigableMap<Integer, Integer> changeCoinsMap) {
        for(Integer coinFromMapValue:changeCoinsMap.descendingKeySet()){
            System.out.println(coinFromMapValue+" coins amount:"+changeCoinsMap.get(coinFromMapValue));
        }
    }




}
