import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class InventoryManager {
    public static void main(String[] args) {
        /*
         * To read the .json file
         * */
        JSONParser parser = new JSONParser();
        double totalPrice;
        try{
            Object obj = parser.parse(new FileReader("/home/bridgeit/packge/com/bridgelabz/assignments/Information.json"));
            JSONObject object = (JSONObject) obj;


            JSONArray data = (JSONArray) object.get("data");
            String[] str = {"rice","pulses","wheats"};
            /*
             * To read the .json file content i.e Object and each Object [name,values]
             * */
            for(int i=0;i<data.size();i++){
                JSONObject itemObj = (JSONObject) data.get(i);
                JSONArray item = (JSONArray) itemObj.get(str[i]);
                System.out.println(str[i]+" Data:");
                totalPrice = 0;
                /*
                 * To display the array elements[name,value]
                 * */
                for (int y = 0; y < item.size(); y++) {
                    JSONObject itemData = (JSONObject) item.get(y);
                    System.out.println("name: "+itemData.get("name"));

                    Object quantObject = itemData.get("weight");
                    int quantity = Integer.parseInt((String)quantObject);
                    System.out.println("Weight: "+quantity+" Kg");

                    Object priceObject = itemData.get("price");
                    double price = Double.parseDouble((String) priceObject);
                    System.out.println("price: "+price+" Rs/Kg");

                    double itemPrice = (quantity*price);
                    totalPrice = totalPrice+itemPrice;
                    System.out.println("price for "+itemData.get("name")+" is: "+itemPrice+" Rs");
                    System.out.println();
                }
                System.out.println("Total Price for "+str[i]+" is: "+totalPrice+" Rs.");
                System.out.println("*********************");
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
