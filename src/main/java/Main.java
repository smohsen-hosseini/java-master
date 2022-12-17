import com.javaMaster.security.Ciphers;
import com.javaMaster.security.MySecurity;
import com.javaMaster.utils.FileManipulation;
import ch.qos.logback.classic.util.ContextInitializer;

import javax.crypto.Cipher;

/**
 * @Author Seyed Mohsen Hosseini
 * @Since 31 August 2022
 */

public class Main {
    static {
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, "config/logback.xml");
    }

    public static void main(String[] args) {
//        FileManipulation fileManipulation = new FileManipulation();
//        fileManipulation.compressAndDecompressFile();

        Ciphers ciphers = new Ciphers();
        ciphers.getList();


    }
}
