import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author xiaqing
 * @date 2017/11/15.
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue <>(2);

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        final ThreadFactory nameFactory = new ThreadFactoryBuilder().setNameFormat("pool-name-%d").build();

        ExecutorService executorService = new ThreadPoolExecutor(
                1,
                1,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                nameFactory,
                new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.shutdown();
    }
}
