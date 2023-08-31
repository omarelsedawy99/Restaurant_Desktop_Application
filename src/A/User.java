package A;

import java.io.Serializable;

public abstract class User extends Person implements Serializable {

    private String Username;
    private String Password;

    public User() {
    }

    public User(String Username, String Password, String Frist_name, String Last_name, String Gender, String Id) {
        super(Frist_name, Last_name, Gender, Id);
        this.Username = Username;
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
