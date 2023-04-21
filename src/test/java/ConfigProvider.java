import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
    Integer AGE = readConfig().getInt("age");
    String ADMIN_LOGIN = readConfig().getString("usersParams.admin.login");
    String USER_PASSWORD = readConfig().getString("usersParams.user.password");
    Boolean USER_IS_ADMIN = readConfig().getBoolean("usersParams.user.isAdmin");
    Boolean ADMIN_IS_ADMIN = readConfig().getBoolean("usersParams.admin.isAdmin");

}
