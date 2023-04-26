import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DatabaseService {
    private Connection con;
    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","jdbc12345");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void save(String name, String pos, int salary) throws SQLException {
        try(Statement stmt = con.createStatement()) {

            String sql = String.format("insert into excel1(name,position,salary) values(\\\"%s\\\",\\\"%s\\\",%d",name,pos,salary);
            stmt.executeUpdate(sql);


        }catch (SQLException e){
            e.printStackTrace();
        }

    }



    public void saveByPS(String name, String pos, int Salary){
        String sql = String.format("insert into excel1(name,position,salary) values(?,?,?)");
        try(PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setString(1,name);
                pstmt.setString(2,pos);
                pstmt.setInt(3,Salary);
                pstmt.executeUpdate();
            System.out.println("Successfully save");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}