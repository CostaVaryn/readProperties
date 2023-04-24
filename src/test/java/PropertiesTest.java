import core.BaseTest;
import org.junit.Test;

import java.io.IOException;

public class PropertiesTest extends BaseTest {

    @Test
    public void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        System.out.println("URL from properties: " + System.getProperty("url"));
        System.out.println("Login from properties: " + System.getProperty("users.admin.login"));
        System.out.println("Login from properties: " + System.getProperty("users.adam.login"));
    }

    @Test
    public void readFromConf() {
        System.out.println("URL from config: " + ConfigProvider.URL);
        System.out.println("Login(admin): " + ConfigProvider.ADMIN_LOGIN);
        System.out.println("Age: " + ConfigProvider.AGE);
        System.out.println("User is admin: " + ConfigProvider.USER_IS_ADMIN);
        System.out.println("Admin is admin: " + ConfigProvider.ADMIN_IS_ADMIN);
        if (ConfigProvider.readConfig().getBoolean("usersParams.admin.isAdmin")) {
            System.out.println("Admin is really admin");
        } else {
            System.out.println("Get out, Impostor!");
        }
    }
}
