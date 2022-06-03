import org.testng.annotations.Test;

public class Basics {

    @Test(priority = 1, description = "This is a login test")
    public void testOpen(){
        System.out.println("Launch is success");
    }

    @Test(priority = 2)
    public void testLogin(){
        System.out.println("Login is success");
    }

    @Test(priority = 3)
    public void testClose(){
        System.out.println("Logout is success");
    }
}
