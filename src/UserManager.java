import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserManager implements IRead{
    private static UserManager instance;
    private UserManager() {}
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public User assignUser(String userName, String emailAddress, String password,
                           String userID,String userType)
    {
        User user = null;
        if(Objects.equals(userType, "Regular"))
        {
            user = new RegularUser(userName,emailAddress,password,userID,userType);
        } else if (Objects.equals(userType,"Power")) {
            user = new PowerUser(userName,emailAddress,password,userID,userType);
        } else if (Objects.equals(userType,"Admin")) {
            user = new AdminUser(userName,emailAddress,password,userID,userType);
        }
        else {
            System.out.println("Having issue with userType!");
        }
        return user;
    }

    @Override
    public List<String> readFile(String fileNameWithExtension)
    {
        List<String> fileData = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameWithExtension)))
        {
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                fileData.add(line);
            }
        }catch (IOException e)
        {
            System.out.println("Error happened: " + e.getMessage());
        }
        return fileData;
    }

    public boolean authenticateUser(String username, String password) {
        // Implementation to authenticate user
        List<String> fileData = this.readFile("User.csv");
        for(String line : fileData){
            String[] data = line.split(",");
            if (Objects.equals(data[1], username) && Objects.equals(data[3], password)) {
                System.out.println("User authenticated: " + username);
                return true;
            }
        }

        System.out.println("Authentication failed for: " + username);
        return false;
    }



}
