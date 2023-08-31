package A;

import java.util.ArrayList;

public interface Manage<Type> {

    public void add();

    public int search(String id);

    public boolean delete(String Id);

    public void update(String Old_Id, Type New_Data);

    public ArrayList<Type> list();

    public boolean putInFile();

    public void getFromFile();
}
