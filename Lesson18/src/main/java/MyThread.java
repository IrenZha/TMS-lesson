public class MyThread implements Runnable {
    String name;
    int count = 0;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " " + thread.getState());
        for (int i = 0; i<1000000; i++){
            count+=1;
        }
        System.out.println(thread.getName() + " = "+ count);
    }
}
