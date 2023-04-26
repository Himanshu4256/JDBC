import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserInputData {
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

            // BufferReader is the second type of user input Like Scanner.
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in)); // user input
            System.out.println("Enter name");
            String name = b.readLine(); //esse hm e line read kr lenge

            System.out.println("Enter City");
            String city = b.readLine();

            // set the values to query

            ps.setString(1,name);
            ps.setString(2,city);

            ps.executeUpdate();
            System.out.println("inserted");
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
