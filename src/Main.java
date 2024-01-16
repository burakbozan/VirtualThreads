import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        //try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
        try (ExecutorService executor = Executors.newThreadPerTaskExecutor(Thread::new)) {
            long startTime = System.nanoTime();
            for (int i = 0; i < 4000; i++) {
                int sqrt = i;
                executor.submit(() -> {
                    try {
                        Thread.sleep(1000);
                        int result = (int) Math.sqrt(sqrt);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
            long elapsedTime = System.nanoTime() - startTime;
            double seconds = (double)elapsedTime / 1_000_000_000.0;
            System.out.println("Toplam gecen sure (milisaniye):  " + seconds);
        }
    }
}