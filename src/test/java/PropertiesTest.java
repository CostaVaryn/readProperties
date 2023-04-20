import core.BaseTest;
import org.junit.Test;

import java.io.IOException;

public class PropertiesTest extends BaseTest {

    @Test
    public void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String urlFromProperty = System.getProperty("url");
        System.out.println("URL from properties: " + urlFromProperty);
    }

    @Test
    public void readFromConf() {
        String urlFromConf = ConfigProvider.URL;
        System.out.println("URL from config: " + urlFromConf);
        Boolean isUserAdmin = ConfigProvider.IS_USER_ADMIN;
        System.out.println("User is admin: " + isUserAdmin);
        if (ConfigProvider.readConfig().getBoolean("usersParams.admin.isAdmin")) {
            System.out.println("Admin is really admin");
        } else {
            System.out.println("Get out, Impostor!");
        }
    }
}
