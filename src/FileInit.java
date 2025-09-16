import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileInit {
    public static String FILE_PATH = "D:\\Do_an\\libraryBook.txt";

    public static void createFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Logger.getLogger(FileInit.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
