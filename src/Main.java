import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {

        /*for (int i = 0; i <args.length; i++){
            System.out.println(i + " => " + args[i]);
        }
        System.exit(0);
        String[] argums = {"-d", "D:\\Desktop", "-l", "54G"};
        ParametersBag bag = new ParametersBag(argums);*/

        String folderPath = "D:\\Desktop\\Files";
        long sizeLimit = 2 * 1024*1024;

        /*String folderPath = bag.getPath();
        long sizeLimit = bag.getLimit();*/

        File file = new File(folderPath);
        Node root = new Node(file);

        long start = System.currentTimeMillis();

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);

        long duration = System.currentTimeMillis() - start;
        System.out.println(duration + "ms");

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
