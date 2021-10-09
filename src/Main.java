import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {

//        String folderPath = "D:\\Desktop\\Files";
//        File file = new File(folderPath);
//        System.out.println(getFolderSize(file));

//        MyThread myThread = new MyThread(1);
//        MyThread myThread2 = new MyThread(2);
//        myThread.start();
//        myThread2.start();

        String folderPath = "D:\\Desktop\\Files";
        File file = new File(folderPath);
        Node root = new Node(file);
        long start = System.currentTimeMillis();

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);

        long duration = System.currentTimeMillis() - start;
        System.out.println(duration + "ms");

        //System.out.println(getSizeFromHumanReadable("235K"));
        //System.out.println(getHumanReadableSize(240640));
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
