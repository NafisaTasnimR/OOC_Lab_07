public class User {
    String userName;
    String emailAddress;
    String password;
    String userID;
    String userType;

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserType() {
        return userType;
    }

    public User(String userName,
                String emailAddress, String password,
                String userID, String userType) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.userID = userID;
        this.userType = userType;
    }

    public void viewUserInfo() {
        System.out.println("User Name: " + userName +
                " " + "Email: " + emailAddress);
    }


}
