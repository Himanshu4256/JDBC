import java.io.FileInputStream;
import java.sql.*;

public class Practice {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/Dcode";
            String un = "root";
            String p = "jdbc12345";
            Connection c = DriverManager.getConnection(url,un,p);

          //  String q = "insert into CodeToa(LargeImg) values(?)";

            String q = "ALTER TABLE CodeToa ADD LargeImg longblob VALUES(?))";

            PreparedStatement ps = c.prepareStatement(q);
            FileInputStream fis = new FileInputStream("/Users/laxminarayansharma/IdeaProjects/JDBC/src/jdbc-tutorial.png");
            ps.setBinaryStream(1,fis);
            //ps.setInt(2,11011);
            //ps.setInt(3,8860);
            ps.executeUpdate();
            System.out.println("Done...");
            c.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
