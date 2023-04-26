import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DatabaseService database = new DatabaseService();
        database.connect();
        database.save("ducat1","java",50000);
        System.out.println("Successfully save");

    }
}
