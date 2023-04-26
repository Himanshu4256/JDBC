import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// Prepared Statement is used for dynamic user input
public class PreparedStmt {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/practice";
            String uname = "root";
            String pass = "jdbc12345";
            Connection con = DriverManager.getConnection(url,uname,pass);

            //create query
            String q = "insert into excel(Name,City) values(?,?)"; //yha hm "?" ki jgh Dynamically value dalenge.

            //get the PreparedStmt object
            PreparedStatement ps = con.prepareStatement(q); //prepareStatement() is method && PreparedStmt is interface.

            // set the values to query
            ps.setString(1,"D");
            ps.setString(2,"Mumbai");
            ps.executeUpdate();

            System.out.println("inserted...");
            con.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
