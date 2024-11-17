public class Main {
    public static void main(String[] args) {
        UserManager userManager = UserManager.getInstance();
        User user = userManager.assignUser("nafisa","nafisa@gmail.com",
                "abc123","naf1","Admin");
    }
}