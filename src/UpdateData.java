import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateData {
    public static void main(String[] args) {
        try {
            Connection con = MainconnectionProvidr.getConnection(); // ye simple MainconnectionProvidr wala connection de de dega
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","jdbc12345");

            String q = "update excel set Name=? , City=? where Id=?";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter new Name :");
            String name = br.readLine();

            System.out.println("Enter new City :");
            String city = br.readLine();

            System.out.println("Enter Student ID :");
            int id = Integer.parseInt(br.readLine()); // id string m aaegi to use int m convert kiya hai.

            PreparedStatement psmt = con.prepareStatement(q);

            psmt.setString(1,name);
            psmt.setString(2,city);
            psmt.setInt(3,id);

            psmt.executeUpdate();

            System.out.println("Data Successfully Updated...");

            con.close();

        }
        catch (Exception e){

        }

    }
}
