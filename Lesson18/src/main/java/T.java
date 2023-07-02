public class T implements Runnable {
    int count = 0;
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
