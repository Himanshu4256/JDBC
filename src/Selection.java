import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Selection {
   public static void getImageIconById(int id, Connection con) {
       ImageIcon icon = null;
       try {
           String q = "select pic from images where id = ?";
           PreparedStatement pstmt = con.prepareStatement(q);
           pstmt.setInt(1, id);
           ResultSet set = pstmt.executeQuery(); // query data lagea to executeQuery & ab Data Resultset m store hua hai.
           if (set.next()) // if icon ki value null hui to null return hoga. & if next koi raw hoga to icon ko nikaleke icon wale var m daal denge.
           {

           }


       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
