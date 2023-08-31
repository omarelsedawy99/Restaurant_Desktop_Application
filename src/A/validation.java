package A;

public class validation extends Exception {

    public validation() {
        super();
    }

    public validation(String s) {
        super(s);
    }

    public boolean CheckName(String s) {
        char x;
        int check = 0;
        for (int i = 0; i < s.length(); i++) {
            x = s.charAt(i);
            if ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')) {
                check++;
            } else {
                return false;
            }
        }
        if (check <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPhone(String s) {
        char x;
        int check = 0;
        for (int i = 0; i < s.length(); i++) {
            x = s.charAt(i);
            if (x >= '0' && x <= '9') {
                check++;
            } else {
                return false;
            }
        }
        if (check == 11) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAge(String s) {
        char x;
        int check = 0;
        for (int i = 0; i < s.length(); i++) {
            x = s.charAt(i);
            if (x >= '0' && x <= '9') {
                check++;
            } else {
                return false;
            }
        }
        int c = Integer.parseInt(s);
        if (c >= 18 && c <= 50 && check == 2) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkUsername(String s) {
        if (s.length() >= 8) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkPassword(String s) {
        if (s.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkId(String s) {
        char x;
        int check = 0;
        for (int i = 0; i < s.length(); i++) {
            x = s.charAt(i);
            if (x >= '0' && x <= '9') {
                check++;
            } else {
                return false;
            }
        }
        if (check <= 8) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkSalary(String s) {
        char x;
        int check1 = 0, check2 = 0;
        for (int i = 0; i < s.length(); i++) {
            x = s.charAt(i);
            if (x >= '0' && x <= '9') {
                check1++;

            } else if (x == '.') {
                check2++;
            } else {
                return false;
            }
        }
        if (check1 != 0 && check1 <= 8 && check2 <= 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPrice(String s) {

        char x;
        int check = 0, check2 = 0;
        for (int i = 0; i < s.length(); i++) {
            x = s.charAt(i);
            if (x >= '0' && x <= '9') {
                check++;
            } else if (x == '.') {
                check2++;
            } else {
                return false;
            }
        }
        int c = Integer.parseInt(s);
        if (c >= 0 && c <= 1000 && check2 <= 1) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkNumberOfMeals(String s) {
        return checkInteger(s, 1000);
    }

    public boolean checkDiscont(String s) {
        return checkInteger(s, 100);
    }

    public boolean checkInteger(String s, int z) {

        char x;
        int check = 0;
        for (int i = 0; i < s.length(); i++) {
            x = s.charAt(i);
            if (x >= '0' && x <= '9') {
                check++;
            } else {
                return false;
            }

        }
        int c = Integer.parseInt(s);
        if (c >= 0 && c <= z) {
            return true;
        } else {
            return false;
        }

    }

}
