public class SupportEngineer implements Runnable {
    private static final int TIME_OF_WORK = 1000;
    
    @Override
    public void run() {
        try {
            while (true) {
                String call = ATS.atsQueue.poll();
                if (call != null) {
                    System.out.println("***** Инженер " + Thread.currentThread().getName() + " взял в работу звонок " + call + " *****");
                    Thread.sleep(TIME_OF_WORK);
                    System.out.println("+++++ Инженер " + Thread.currentThread().getName() + " обработал звонок "
                            + call + ". Количество отвеченных звонков: " + ATS.answeredCallsCount.incrementAndGet() + " +++++\n");
                } else if (ATS.answeredCallsCount.get() >= ATS.CALLS_SIZE) {
                    ATS.answeredCallsCount.incrementAndGet();
                    System.out.println("_________ " + Thread.currentThread().getName() + ": все звонки обработаны!_________");
                    break;
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



