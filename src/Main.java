import oktmo.OktmoData;
import oktmo.OktmoReader;

public class Main{
    public static void main(String[] args) {
        System.out.println("Heello");

        OktmoData data = new OktmoData();
        OktmoReader reader = new OktmoReader();

        reader.readPlaces("task/tom5_oktmo_2.csv", data);



    }
}