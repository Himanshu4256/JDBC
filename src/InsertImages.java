import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImages {
    public static void main(String[] args) {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","jdbc12345");
            String q = "insert into images(id,picture) values(?,?)"; // pic is column
            PreparedStatement ps = con.prepareStatement(q);
//            ps.setString(1,"values");  -> Jab Hme (String ka input) dena ho.
              FileInputStream fis = new FileInputStream("/Users/laxminarayansharma/IdeaProjects/JDBC/src/jdbc-tutorial.png"); // blob sirf [65kb] se km ka data rakh skta hai.
            ps.setInt(1,123);
            ps.setBinaryStream(2,fis); //fis.available= fis m kitne byte ki memory available hai||| setBinaryStream() mtd is used for (inserting the image as an input).
              ps.executeUpdate();
            System.out.println("image inserted..");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
