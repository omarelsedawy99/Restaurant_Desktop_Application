package A;

import java.io.Serializable;

public abstract class Person implements Serializable {

    private String Frist_name;
    private String Last_name;
    private String Gender;
    private String Id;
    DatabaseFile Database = new DatabaseFile();

    public Person() {
    }

    public Person(String Frist_name, String Last_name, String Gender, String Id) {
        this.Frist_name = Frist_name;
        this.Last_name = Last_name;
        this.Gender = Gender;
        this.Id = Id;
    }

    public String getFrist_name() {
        return Frist_name;
    }

    public void setFrist_name(String Frist_name) {
        this.Frist_name = Frist_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String Last_name) {
        this.Last_name = Last_name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

}
