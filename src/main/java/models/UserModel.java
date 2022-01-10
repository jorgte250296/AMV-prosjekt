package models;

/* Klasser med gettere og settere for UserModel - velger å behold ubrukte metoder inntil videre. */
public class UserModel {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private boolean isAdmin;

    public UserModel(String firstName, String lastName, String phoneNumber, String password, Boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UserModel() {
    }

    public UserModel(int user_id) {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdmin() { return isAdmin;}

    public void setAdmin(Boolean admin) { isAdmin = admin;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
