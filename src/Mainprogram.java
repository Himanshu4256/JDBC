import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Mainprogram {
    public static void main(String[] args) {
        try {
            Connection c = MainconnectionProvidr.getConnection();
            String q = "insert into largeimg(picture) values(?)";
            PreparedStatement psmt = c.prepareStatement(q); // c se prepareStatement ko call krenge bcoz ye Connection interface ka mtd hai.

            JFileChooser jfc = new JFileChooser(); // file choose krne k liye.
            jfc.showOpenDialog(null); // esse dialog box show hoga.

            File file = jfc.getSelectedFile(); //--> ek file select krne k liye
            //File[] file = jfc.getSelectedFiles(); //--> Multiple files select krne k liye.

            FileInputStream fis = new FileInputStream(file);
            psmt.setBinaryStream(1,fis,fis.available()); //fis.available for file length
            psmt.executeUpdate();

           // System.out.println("Images Uploaded"); -> normal msg show krana.
            JOptionPane.showMessageDialog(null,"Images Uploaded"); //swing ki help se msg show krana






        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
