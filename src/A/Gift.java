package A;

import java.io.Serializable;
import java.util.ArrayList;

public class Gift implements Manage<Gift>, Serializable {

    private String Id;
    private String Name;
    private DatabaseFile Database = new DatabaseFile();
    private static ArrayList<Gift> Gifts = new ArrayList();
    private static final String GIFT_FILE_PATH = "Gifts.bin";

    public Gift() {
    }

    public Gift(String Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public boolean putInFile() {
        return Database.input(GIFT_FILE_PATH, Gifts);
    }

    @Override
    public void getFromFile() {
        Gifts = (ArrayList<Gift>) Database.output(GIFT_FILE_PATH);
        if (Gifts == null) {
            Gifts = new ArrayList();
        }
    }

    @Override
    public void add() {
        getFromFile();
        Gifts.add(this);
        putInFile();
    }

    @Override
    public int search(String id) {
        getFromFile();
        for (int i = 0; i < Gifts.size(); i++) {
            if (Gifts.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Gift getGift(String Id) {
        int index = search(Id);
        if (index != -1) {
            return Gifts.get(index);
        }
        return null;
    }

    @Override
    public boolean delete(String GiftId) {
        int index = search(GiftId);
        if (index != -1) {
            Gifts.remove(index);
            return putInFile();
        }
        return false;
    }

    @Override
    public void update(String Old_Gift_Id, Gift New_Data) {
        Gifts.set(search(Old_Gift_Id), New_Data);
        putInFile();
    }

    @Override
    public ArrayList<Gift> list() {
        getFromFile();
        return Gifts;
    }
}
