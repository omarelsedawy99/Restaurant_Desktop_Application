package A;

import java.io.Serializable;
import java.util.ArrayList;

public class Report implements Serializable {

    private String customer_id = "";
    private String employee_id = "";
    private String content;
    private DatabaseFile Database = new DatabaseFile();
    private static ArrayList<Report> Reports = new ArrayList();
    private static final String REPORT_FILE_PATH = "Reports.bin";

    public Report() {
    }

    public Report(String customer_id, String employee_id, String content) {
        this.customer_id = customer_id;
        this.employee_id = employee_id;
        this.content = content;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean putInFile() {
        return Database.input(REPORT_FILE_PATH, Reports);
    }

    public void getFromFile() {
        Reports = (ArrayList<Report>) Database.output(REPORT_FILE_PATH);
        if (Reports == null) {
            Reports = new ArrayList();
        }
    }

    public void add() {
        getFromFile();
        Reports.add(this);
        putInFile();
    }
}
