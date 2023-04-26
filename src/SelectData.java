import java.sql.Connection;

public class SelectData {
    public static void main(String[] args) {
        try {
            Connection con = MainconnectionProvidr.getConnection();
            String q = "Select * from excel";

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
