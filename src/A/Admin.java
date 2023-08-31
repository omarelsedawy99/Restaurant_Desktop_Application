package A;

import java.io.Serializable;
import java.util.ArrayList;

public class Admin implements Serializable {

    private String Username;
    private String Password;
    private String Id;
    private String Frist_name;
    private String Last_name;
    private String Gender;
    private static final String DEFAULT_USERNAME = "Admin";
    private static final String DEFAULT_PASSWORD = "Admin";
    private DatabaseFile Database = new DatabaseFile();
    private static final String ADMIN_FILE_PATH = "Admin.bin";

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

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
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

    public void addEmployee(Employee x) {
        x.add();
    }

    public void deleteEmployee(String Employee_id) {
        new Employee().delete(Employee_id);
    }

    public Employee searchEmployee(String Employee_id) {
        return new Employee().getEmployee(Employee_id);
    }

    public void updateEmployee(String old_employee_id, Employee new_employee) {
        new_employee.update(old_employee_id, new_employee);
    }

    public ArrayList<Employee> listEmployee() {
        return new Employee().list();
    }

    public void addMeal(Meal x) {
        x.add();
    }

    public void deleteMeal(String Meal_id) {
        new Meal().delete(Meal_id);
    }

    public Meal searchMeal(String Meal_id) {
        return new Meal().getMeal(Meal_id);
    }

    public void updateMeal(String old_meal_id, Meal new_meal) {
        new_meal.update(old_meal_id, new_meal);
    }

    public ArrayList<Meal> listMeal() {
        return new Meal().list();
    }

    public void addGift(Gift x) {
        x.add();
    }

    public void deleteGift(String Gift_id) {
        new Gift().delete(Gift_id);
    }

    public Gift searchGift(String Gift_id) {
        return new Gift().getGift(Gift_id);
    }

    public void updateGift(String old_gift_id, Gift new_gift) {
        new Gift().update(old_gift_id, new_gift);
    }

    public ArrayList<Gift> listGift() {
        return new Gift().list();
    }

    public void addRewardProgram(RewardProgram x) {
        x.add();
    }

    public void deleteRewardProgram(String RewardProgram_id) {
        new RewardProgram().delete(RewardProgram_id);
    }

    public RewardProgram searchRewardProgram(String RewardProgram_id) {
        return new RewardProgram().getRewardProgram(RewardProgram_id);
    }

    public void updateRewardProgram(String old_Rewardprogram_id, RewardProgram new_Rewardprogram) {
        new RewardProgram().update(old_Rewardprogram_id, new_Rewardprogram);
    }

    public ArrayList<RewardProgram> listRewardProgram() {
        return new RewardProgram().list();
    }

    public void addOffer(Offer x) {
        x.addOffer();
    }

    public void deleteOffer(String Offer_id) {
        new Offer().deleteOffer(Offer_id);
    }

    public Offer searchOffer(String Offer_id) {
        return new Offer().getOffer(Offer_id);
    }

    public void updateOffer(String old_Offer_id, Offer new_Offer) {
        new_Offer.updateOffer(old_Offer_id, new_Offer);
    }

    public ArrayList<Offer> listOffer() {
        return new Offer().listOffer();
    }

    public void addReport(Report x) {
        x.add();
    }

    public boolean login(String UserName, String Password) {
        Admin x = (Admin) Database.output(ADMIN_FILE_PATH);
        if (x != null) {
            if (x.Username.equals(UserName) && x.Password.equals(Password)) {
                return true;
            }
            if (DEFAULT_USERNAME.equals(UserName) && DEFAULT_PASSWORD.equals(Password)) {
                return true;
            }
        } else {
            if (DEFAULT_USERNAME.equals(UserName) && DEFAULT_PASSWORD.equals(Password)) {
                return true;
            }
        }
        return false;
    }

    public boolean changeData() {
        return Database.input(ADMIN_FILE_PATH, this);
    }
}
