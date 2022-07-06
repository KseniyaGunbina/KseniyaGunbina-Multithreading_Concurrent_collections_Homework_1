import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ATS implements Runnable {
    public static final int CALLS_SIZE = 60;
    public static final int WAIT_TIME = 500;
    public static LinkedBlockingQueue<String> atsQueue = new LinkedBlockingQueue<>();
    public static AtomicInteger answeredCallsCount = new AtomicInteger(0);

    @Override
    public void run(){
        try {
            for (int i = 1; i <= CALLS_SIZE; i++) {
                System.out.println("Поступил Звонок № " + i + "\n");
                atsQueue.offer("Звонок № " + i);
                Thread.sleep(WAIT_TIME);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



