import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminUser extends User implements IRead,IAdd,Imodify{
    public AdminUser(String userName, String emailAddress, String password, String userID, String userType) {
        super(userName, emailAddress, password, userID, userType);
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

    @Override
    public void addUserDetail(User user) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("User.csv",true)))
        {
            bufferedWriter.write( user.getUserID() +
                    "," + user.getUserName()+","+user.getEmailAddress()
                    +","+user.getPassword() + "," + user.getUserType());
            bufferedWriter.newLine();
            if(Objects.equals(user.getUserType(), "Admin"))
            {
                try(BufferedWriter bufferedWriter1 = new BufferedWriter(
                        new FileWriter("Admin.csv",true)))
                {
                    bufferedWriter1.write(user.getUserID() +
                            "," + user.getUserName()+","+user.getEmailAddress()
                            +","+user.getPassword());
                    bufferedWriter.newLine();
                }catch (IOException e)
                {
                    System.out.println("Error happened: " + e.getMessage());
                }
            }
        }catch (IOException e)
        {
            System.out.println("Error happened: " + e.getMessage());
        }
    }

    public void setPrivilege(String password,String privilege)
    {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("User.csv")))
        {
            String line;
            while((line= bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if(Objects.equals(password, data[2]) && Objects.equals(data[4], "N/A"))
                {
                    try(BufferedWriter bufferedWriter = new BufferedWriter(
                            new FileWriter("User.csv",true)))
                    {
                        bufferedWriter.write( data[0] +
                                "," + data[1] +","+data[2]
                                +","+data[3] + "," + privilege);
                        bufferedWriter.newLine();
                    }catch (IOException e)
                    {
                        System.out.println("Error happened: " + e.getMessage());
                    }
                }
            }
        }catch (IOException e)
        {
            System.out.println("Error happened: " + e.getMessage());
        }
    }

    public void modifySettings(String newFileName,String fileToChange)
    {
        try {
            File myObj = new File(newFileName);
            if (myObj.createNewFile()) {
                //System.out.println("File created: " + myObj.getName());
                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFileName,true))){
                    List<String> fileData = this.readFile(fileToChange);
                    for(String line : fileData)
                    {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    }
                }catch (IOException e)
                {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
