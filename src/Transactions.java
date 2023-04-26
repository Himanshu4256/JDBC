import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transactions {
    public static void main(String[] args) throws SQLException {
        // connection creation
        String url = "jdbc:mysql://localhost:3306/practice";
        String uName= "root";
        String Pss = "jdbc12345";
        Connection con = DriverManager.getConnection(url,uName,Pss);

        try {
            con.setAutoCommit(false);

            //create query
           // String q = "create table Transactions (Id int(20) primary key auto_increment, Name varchar(200) not null, City varchar(400), carName varchar(200), Education varchar(200), Course varchar(20), Position varchar(20), Salary int)"; // auto_increment changeable row;

            String q = "insert into Transactions(Id,Name,City,carName,Education,Course,Position,Salary)values(12,'J','Delhi','abc','UG','B.Tech','Software_Developer',99999)";
            //create statement
            Statement stm = con.createStatement();
            stm.executeUpdate(q); // agr koi err aati hai to yha se exception through ho jaegi means niche wala print ni chalega.

            //for successfully complete if there is no error.
            con.commit(); // ye data ko save krega

            System.out.println("Data Inserted...");
            con.close(); // for connection close ye connection ko close krega

        }catch (SQLException e){
            String msg = e.getMessage();
            msg = "SQLException Occured with message: "+msg;
            System.out.println(msg);
            System.out.println("starting rolebck operation");
            con.rollback();

        }














//        try {
//           //  connection creation
//            String url = "jdbc:mysql://localhost:3306/practice";
//            String uName= "root";
//            String Pss = "jdbc12345";
//            Connection con = DriverManager.getConnection(url,uName,Pss);
//            con.setAutoCommit(false);
//
//            //create query
//           // String q = "create table Transactions (Id int(20) primary key auto_increment, Name varchar(200) not null, City varchar(400), carName varchar(200), Education varchar(200), Course varchar(20), Position varchar(20), Salary int)"; // auto_increment changeable row;
//
//            String q = "insert into Transactions(Id,Name,City,carName,Education,Course,Position,Salary)values(10,'J','Delhi','abc','UG','B.Tech','Software_Developer',99999)";
//            //create statement
//            Statement stm = con.createStatement();
//            stm.executeUpdate(q); // agr koi err aati hai to yha se exception through ho jaegi means niche wala print ni chalega.
//            //for successfully complete if there is no error.
//            con.commit();
//
//            System.out.println("Data Inserted...");
//            //c.close(); // for connection close
//
//        } catch (SQLException se) {
//            String msg = se.getMessage();
//            msg = "SQLException occured with message: " + msg;
//            System.out.println(msg);
//            System.out.println("Starting rollback operations...");
//            try {
//                con.rollback();
//            } catch (SQLException se2) {
//                se2.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }






    }
}
