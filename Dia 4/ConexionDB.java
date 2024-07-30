import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String DB_URL = "jdbc:mysql://bnmdqezhcn9afq24veg4-mysql.services.clever-cloud.com:3306/bnmdqezhcn9afq24veg4";
    private static final String USER = dotenv.get("CLEVER_CLOUD_USER");
    private static final String PASS = dotenv.get("CLEVER_CLOUD_PASS");

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

