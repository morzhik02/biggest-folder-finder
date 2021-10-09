public class MyThread extends Thread {
    private int threadNUmber;

    public MyThread(int threadNumber) {
        this.threadNUmber = threadNumber;
    }

    @Override
    public void run() {
        for (;;){
            System.out.println(threadNUmber);
        }

    }
}
