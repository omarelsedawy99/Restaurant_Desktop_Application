package A;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Manage<Order>, Serializable {

    private String Customer_id = "0";
    private String Id;
    private ArrayList<bill> Meals_Of_Order = new ArrayList();
    private DatabaseFile Database = new DatabaseFile();
    private static ArrayList<Order> Orders = new ArrayList();
    private ArrayList<Meal> Meals = new ArrayList();
    private static final String ORDERS_FILE_PATH = "Orders.bin";

    public String getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String Customer_id) {
        this.Customer_id = Customer_id;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public ArrayList<bill> getMeals_Of_Order() {
        return Meals_Of_Order;
    }

    public void setMeals_Of_Order(ArrayList<bill> Meals_Of_Order) {
        this.Meals_Of_Order = Meals_Of_Order;
    }

    @Override
    public boolean putInFile() {
        return Database.input(ORDERS_FILE_PATH, Orders);
    }

    @Override
    public void getFromFile() {
        Orders = (ArrayList<Order>) Database.output(ORDERS_FILE_PATH);
        if (Orders == null) {
            Orders = new ArrayList();
        }
    }

    @Override
    public void add() {
        getFromFile();
        Orders.add(this);
        putInFile();
    }

    @Override
    public int search(String id) {
        getFromFile();
        for (int i = 0; i < Orders.size(); i++) {
            if (Orders.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean delete(String Id) {
        int index = search(Id);
        if (index != -1) {
            Orders.remove(index);
            return putInFile();
        }
        return false;
    }

    @Override
    public void update(String Old_Order_Id, Order New_Data) {
        Orders.set(search(Old_Order_Id), New_Data);
        putInFile();
    }

    @Override
    public ArrayList<Order> list() {
        getFromFile();
        return Orders;
    }

    public ArrayList<Order> searchCustomerOrders(String id) {
        getFromFile();
        ArrayList<Order> CustomerOrders = new ArrayList();
        for (int i = 0; i < Orders.size(); i++) {
            if (Orders.get(i).getCustomer_id().equals(id)) {
                CustomerOrders.add(Orders.get(i));
            }
        }
        if (!CustomerOrders.isEmpty()) {
            return CustomerOrders;
        } else {
            return null;
        }
    }

    public void addMealArrayList(ArrayList<Meal> list) {
        this.Meals = list;
    }

    public ArrayList<Meal> getMealArrayList() {
        return this.Meals;
    }
}
