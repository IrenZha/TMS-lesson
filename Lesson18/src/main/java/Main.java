public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new MyThread("T1"));
        Thread t2 = new Thread(new MyThread("T2"));
        Thread t3 = new Thread(new MyThread("T3"));


        t3.start();
        t3.join();
        t2.start();
        t2.join();
        t1.start();
        t1.join();

        Thread thread = Thread.currentThread();
        System.out.println("Main " + thread.getState());
        System.out.println("Main.main");
    }
}
