public class User {
    String userName;
    String emailAddress;
    String password;
    String userID;
    String userType;

    public User(String userName,
                String emailAddress, String password,
                String userID, String userType) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.userID = userID;
        this.userType = userType;
    }


}
