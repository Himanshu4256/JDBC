import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Connection_rollBack {
    public static void main(String args[]) throws SQLException {
        //Registering the Driver
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String url = "jdbc:mysql://localhost/practice";
        Connection con = DriverManager.getConnection(url, "root", "jdbc12345");
        System.out.println("Connection established......");
        //Setting the auto commit false
        con.setAutoCommit(false);
        //Creating a Statement object
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        //Retrieving the data
        ResultSet rs = stmt.executeQuery("select * from Transactions");
        System.out.println("Contents of the table initially");
        while(rs.next()) {
            System.out.print("ID: "+rs.getString("ID")+", ");
            System.out.print("Name: "+rs.getString("Name")+", ");
            System.out.print("City: "+rs.getString("City")+", ");
            System.out.print("carName: "+rs.getString("carName")+", ");
            System.out.print("Education: "+rs.getString("Education")+", ");
            System.out.print("Course: "+rs.getString("Course"));
            System.out.print("Position: "+rs.getString("Position"));
            System.out.print("Salary: "+rs.getString("Salary"));
            System.out.println("");
        }
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO MyPlayers VALUES (?, ?, ?, ?, ?, ?)");
        pstmt.setInt(1, 8);
        pstmt.setString(2, "Ishant");
        pstmt.setString(3, "Delhi");
        //pstmt.setDate(4, new Date(904694400000L));
        pstmt.setString(4, "AVTAR");
        pstmt.setString(5, "UG");
        pstmt.setString(6, "B.Tech");
        pstmt.setString(7, "Software Developer");
        pstmt.setString(8, "99999");

        pstmt.executeUpdate();
        //Committing the transaction
        con.commit();
        //Deleting the record
        stmt.execute("Delete from MyPlayers where id = 8");
        //Rolling back to the save pointf
        con.rollback();
        //Contents of the table after the roll-back
        System.out.println("Contents of the table");
        rs = stmt.executeQuery("select * from MyPlayers");
        while(rs.next()) {
            System.out.print("ID: "+rs.getString("ID")+", ");
            System.out.print("Name: "+rs.getString("Name")+", ");
            System.out.print("City: "+rs.getString("City")+", ");
            System.out.print("carName: "+rs.getString("carName")+", ");
            System.out.print("Education: "+rs.getString("Education")+", ");
            System.out.print("Course: "+rs.getString("Course"));
            System.out.print("Position: "+rs.getString("Position"));
            System.out.print("Salary: "+rs.getString("Salary"));
            System.out.println("");
        }
    }
}
