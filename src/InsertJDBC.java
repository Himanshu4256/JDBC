import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertJDBC {
    public static void main(String[] args) {
        try {
            // connection creation
            String url = "jdbc:mysql://localhost:3306/practice";
            String uName= "root";
            String Pss = "jdbc12345";
            Connection c = DriverManager.getConnection(url,uName,Pss);

            //create query
            String q = "create table excel1(Id int(20) primary key auto_increment, Name varchar(200) not null, City varchar(400), carName varchar(200), Education varchar(200))"; // auto_increment changeable row;

            //create statement
            Statement stm = c.createStatement();
            stm.executeUpdate(q); // agr koi err aati hai to yha se exception through ho jaegi means niche wala print ni chalega.
            System.out.println("Table Created...");
            c.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
