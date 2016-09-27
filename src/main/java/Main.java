import java.util.HashMap;
import java.util.Map;

/**
 * Created by Artem_Pryzhkov on 9/27/2016.
 */
public class Main {
    public static void main(String[] args) {

        Client client=new Client();
        client.productReader();
        client.cashToPay();

        while(true){
            if(client.coinReader()){
                break;
            }
        }
    }


}
