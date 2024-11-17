import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PowerUser extends User implements IAdd {
    public PowerUser(String userName, String emailAddress, String password, String userID, String userType) {
        super(userName, emailAddress, password, userID, userType);
    }
    @Override
    public void addUserDetail(User user) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("User.csv",true)))
        {
            bufferedWriter.write( user.getUserID() +
                    "," + user.getUserName()+","+user.getEmailAddress()
                    +","+user.getPassword() + "," + "N/A");
            bufferedWriter.newLine();
        }catch (IOException e)
        {
            System.out.println("Error happened: " + e.getMessage());
        }
    }

}
