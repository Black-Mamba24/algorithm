import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zhaiyi on 2018/8/29.
 */
public class ThreadPoolTest {
    private static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        Thread check = new Thread(() -> {
            int activeCount, queueSize ,poolSize;
            while (true) {
                activeCount = executor.getActiveCount();
                queueSize = executor.getQueue().size();
                poolSize = executor.getPoolSize();
                System.out.printf("poolSize: %d, activeCount: %d, queueSize: %d\n",poolSize, activeCount, queueSize);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        check.start();
        final Random random = new Random();
        int i = 0;
        while (i++ < 1000) {
            executor.submit(() -> {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread.sleep(1000);
        }
    }
}
