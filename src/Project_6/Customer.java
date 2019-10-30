package Project_6;

import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private ArrayList<IceCream> iceCream;

    public Customer(String aLastName, String aFirstName, String aPhone, String anEmail) {
        lastName = aLastName;
        firstName = aFirstName;
        phone = aPhone;
        email = anEmail;
    }

    public void orderIceCream(IceCream anIceCream) {
        iceCream.add(anIceCream);
    }

    public ArrayList<IceCream> getIceCream() {
        return iceCream;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String aFirstName) {
        firstName = aFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String aLastName) {
        lastName = aLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String aPhone) {
        phone = aPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String anEmail) {
        email = anEmail;
    }

    public String toString() {
        String output = "";
        output += firstName + " " + lastName + "\n";
        output += phone + "\n";
        output += email + "\n";
        output += "Ice Cream Order:\n";
        for (IceCream elem : iceCream) {
            output += "\t" + elem.getSize() + "\n";
            output += "\t" + elem.getFlavor() + "\n";
            output += "\t" + elem.getSauce() + "\n";
            output += "\t" + elem.getTopping() + "\n";
            output += "\t" + elem.getToppingSun() + "\n";
            output += "\n";
        }
        return output;
    }
}
