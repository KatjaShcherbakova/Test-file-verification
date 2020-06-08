package utils;

import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.core.ZipFile;

public class ZIPUtils {

    public  void unzip(String source, String destination){
        unzip(source,destination, "");
    }

    public  void unzip(String source, String destination, String password){

        try {
            ZipFile zipFile = new ZipFile(source);
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(password);
            }
            zipFile.extractAll(destination);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

}
