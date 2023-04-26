import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JavaJdbc {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/student";              //]
            String uname = "root";                                           //]
            String pass = "jdbc12345";                                       //] --> These are the setps to create a Table and Connect to Database
            Connection con = DriverManager.getConnection(url, uname, pass);  //]
            if(con.isClosed()){
                System.out.println("Connection is closed");
            }
            else {
                System.out.println("Connection Created");                        //]
            }
            String Query = "insert into Employee(id,salary)values(3,1000)";
            Statement s = con.createStatement();
            s.executeUpdate(Query);
            System.out.println("inserted");
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
