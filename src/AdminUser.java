public class AdminUser extends User implements Iview,Iwrite,Imodify{
    public AdminUser(String userName, String emailAddress, String password, String userID, String userType) {
        super(userName, emailAddress, password, userID, userType);
    }
}
