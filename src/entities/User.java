package entities;



public class User {
    private String ID;
    private String firstName;
    private String secondName;
    private String dateOfBirth;
    private String email;
    private String userName;
    private String password;
    private String role;

    
    public User() {
        this.ID = "23-54897-3";
        this.firstName = "Shohag";
    }

    
    public User(String ID, String firstName) {
        this.ID = ID;
        this.firstName = firstName;
    }

    
    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

   
    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

   
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

   
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    public void showDetails() {
        System.out.println("First Name: " + this.firstName + "\nID: " + this.ID);
    }

   
    @Override
    public String toString() {
        return this.ID + "~" + this.firstName + "~" + this.secondName + "~" + this.dateOfBirth + "~" +
               this.email + "~" + this.userName + "~" + this.password + "~" + this.role;
    }

    
    public User formUser(String s) {
        String[] arr = s.split("~"); // Use "\\" to escape the "~" in regex

        this.ID = arr[0];
        this.firstName = arr[1];
        this.secondName = arr[2];
        this.dateOfBirth = arr[3];
        this.email = arr[4];
        this.userName = arr[5];
        this.password = arr[6];
        this.role = arr[7];

        return this;
    }
}
