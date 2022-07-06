public class Main {

    public static final int SUPPORT_TEAM = 10;

    public static void main(String[] args) throws InterruptedException {
        Thread ats = new Thread(null, new ATS()::run);
        ats.start();

        for( int i = 1; i <= SUPPORT_TEAM; i++) {
            new Thread(null, new SupportEngineer()::run, "Специалист № " + i).start();
        }
    }
}
