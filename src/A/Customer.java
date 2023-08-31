package A;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends Person implements Manage<Customer>, Serializable {

    private static ArrayList<Customer> Customers = new ArrayList();
    private static final String CUSTOMERS_FILE_PATH = "Customer.bin";
    private ArrayList<Order> orders = new ArrayList();

    public Customer() {
    }

    public Customer(String Frist_name, String Last_name, String Gender, String Id) {
        super(Frist_name, Last_name, Gender, Id);
    }

    @Override
    public boolean putInFile() {
        return Database.input(CUSTOMERS_FILE_PATH, Customers);
    }

    @Override
    public void getFromFile() {
        Customers = (ArrayList<Customer>) Database.output(CUSTOMERS_FILE_PATH);
        if (Customers == null) {
            Customers = new ArrayList();
        }
    }

    @Override
    public void add() {
        getFromFile();
        Customers.add(this);
        putInFile();
    }

    @Override
    public int search(String id) {
        getFromFile();
        for (int i = 0; i < Customers.size(); i++) {
            if (Customers.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Customer getCustomer(String Id) {
        int index = search(Id);
        if (index != -1) {
            return Customers.get(index);
        }
        return null;
    }

    @Override
    public boolean delete(String CustomerId) {
        int index = search(CustomerId);
        if (index != -1) {
            Customers.remove(index);
            return putInFile();
        }
        return false;
    }

    @Override
    public void update(String Old_Customer_Id, Customer New_Data) {
        Customers.get(search(Old_Customer_Id)).delete(Old_Customer_Id);
        New_Data.add();
    }

    @Override
    public ArrayList<Customer> list() {
        getFromFile();
        return Customers;
    }
}
