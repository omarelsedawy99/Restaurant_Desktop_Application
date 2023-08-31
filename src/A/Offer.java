package A;

import java.io.Serializable;
import java.util.ArrayList;

public class Offer extends Meal implements Serializable {

    private String Id_Offer;
    private Meal x = new Meal();
    private int num_of_meal;
    private int discount_precentage;
    private final static String OFFER_FILE_PATH = "Offers.bin";
    private DatabaseFile Database = new DatabaseFile();
    private static ArrayList<Offer> Offers = new ArrayList();

    public Offer() {
    }

    public Offer(String Id_Offer, int num_of_meal, int discount_precentage) {
        this.Id_Offer = Id_Offer;
        this.num_of_meal = num_of_meal;
        this.discount_precentage = discount_precentage;
    }

    public String getId_Offer() {
        return Id_Offer;
    }

    public void setId_Offer(String Id_Offer) {
        this.Id_Offer = Id_Offer;
    }

    public int getNum_of_meal() {
        return num_of_meal;
    }

    public void setNum_of_meal(int num_of_meal) {
        this.num_of_meal = num_of_meal;
    }

    public int getDiscount_precentage() {
        return discount_precentage;
    }

    public void setDiscount_precentage(int discount_precentage) {
        this.discount_precentage = discount_precentage;
    }

    public Meal getX() {
        return x;
    }

    public void setX(Meal x) {
        this.x = x;
    }

    @Override
    public boolean putInFile() {
        return Database.input(OFFER_FILE_PATH, Offers);
    }

    @Override
    public void getFromFile() {
        Offers = (ArrayList<Offer>) Database.output(OFFER_FILE_PATH);
        if (Offers == null) {
            Offers = new ArrayList();
        }
    }

    public void addOffer() {
        getFromFile();
        Offers.add(this);
        putInFile();
    }

    public int searchOffer(String id) {
        getFromFile();
        for (int i = 0; i < Offers.size(); i++) {
            if (Offers.get(i).getId_Offer().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public boolean deleteOffer(String OfferId) {
        int index = searchOffer(OfferId);
        if (index != -1) {
            Offers.remove(index);
            return putInFile();
        }
        return false;
    }

    public void updateOffer(String Old_Offer_Id, Offer New_Data) {
        Offers.get(searchOffer(Old_Offer_Id)).deleteOffer(Old_Offer_Id);
        New_Data.addOffer();
    }

    public ArrayList<Offer> listOffer() {
        getFromFile();
        return Offers;
    }

    public double calculateDiscount(Meal x, int num_of_meal) {
        getFromFile();
        for (int i = 0; i < Offers.size(); i++) {
            if (Offers.get(i).getId().equals(x.getId()) && Offers.get(i).getMealName().equals(x.getMealName())
                    && Offers.get(i).getNum_of_meal() < num_of_meal) {
                return Offers.get(i).getDiscount_precentage() / 100 * Offers.get(i).getX().getMealPrice() * num_of_meal;
            }
        }
        return x.getMealPrice() * num_of_meal;
    }

    public Offer getOffer(String id) {
        int index = searchOffer(id);
        if (index != -1) {
            return Offers.get(index);
        }
        return null;
    }
}
