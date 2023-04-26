import java.sql.Connection;
import java.sql.DriverManager;

public class MainconnectionProvidr {

    private static Connection con;
    public static Connection getConnection(){
        try {
            if (con == null) {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "jdbc12345");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return con;
    }
}
