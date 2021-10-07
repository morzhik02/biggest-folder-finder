import java.io.File;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        String folderPath = "D:\\Desktop\\Files";
        File file = new File(folderPath);
        System.out.println(getFolderSize(file));

    }

    public static long getFolderSize(File folder){
        if (folder.isFile()){
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for (File file : files) {
            sum += getFolderSize(file);
        }
        return sum;
    }
}
