package A;

import java.io.Serializable;

public class bill implements Serializable {

    private Meal Meal_Of_Order = new Meal();
    private int Number_of_Meal;

    public Meal getMeal_Of_Order() {
        return Meal_Of_Order;
    }

    public void setMeal_Of_Order(Meal Meal_Of_Order) {
        this.Meal_Of_Order = Meal_Of_Order;
    }

    public int getNumber_of_Meal() {
        return Number_of_Meal;
    }

    public void setNumber_of_Meal(int Number_of_Meal) {
        this.Number_of_Meal = Number_of_Meal;
    }

}
