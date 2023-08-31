package A;

import java.io.Serializable;
import java.util.ArrayList;

public class Meal implements Manage<Meal>, Serializable {

    private String Id;
    private String MealName;
    private double MealPrice;
    private DatabaseFile Database = new DatabaseFile();
    private static ArrayList<Meal> Meals = new ArrayList();
    private static final String MEAL_FILE_PATH = "Meals.bin";

    public Meal() {

    }

    public Meal(String Id, String MealName, double MealPrice) {
        this.Id = Id;
        this.MealName = MealName;
        this.MealPrice = MealPrice;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMealName() {
        return MealName;
    }

    public void setMealName(String MealName) {
        this.MealName = MealName;
    }

    public double getMealPrice() {
        return MealPrice;
    }

    public void setMealPrice(double MealPrice) {
        this.MealPrice = MealPrice;
    }

    @Override
    public boolean putInFile() {
        return Database.input(MEAL_FILE_PATH, Meals);
    }

    @Override
    public void getFromFile() {
        Meals = (ArrayList<Meal>) Database.output(MEAL_FILE_PATH);
        if (Meals == null) {
            Meals = new ArrayList();
        }
    }

    @Override
    public void add() {
        getFromFile();
        Meals.add(this);
        putInFile();
    }

    @Override
    public int search(String id) {
        getFromFile();
        for (int i = 0; i < Meals.size(); i++) {
            if (Meals.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Meal getMeal(String Id) {
        int index = search(Id);
        if (index != -1) {
            return Meals.get(index);
        }
        return null;
    }

    @Override
    public boolean delete(String Id) {
        int index = search(Id);
        if (index != -1) {
            Meals.remove(index);
            return putInFile();
        }
        return false;
    }

    @Override
    public void update(String Old_Meal_Id, Meal New_Data) {
        Meals.get(search(Old_Meal_Id)).delete(Old_Meal_Id);
        New_Data.add();
    }

    @Override
    public ArrayList<Meal> list() {
        getFromFile();
        return Meals;
    }
}
