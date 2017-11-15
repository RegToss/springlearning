import java.util.concurrent.BlockingQueue;

/**
 * @author xiaqing
 * @date 2017/11/15.
 */
public class Producer implements Runnable {

    private BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue <String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        try {
            blockingQueue.put("1");
            System.out.println("blockingQueue put 1");
            Thread.sleep(1000);
            blockingQueue.put("2");
            System.out.println("blockingQueue put 2");
            Thread.sleep(1000);
            blockingQueue.put("3");
            System.out.println("blockingQueue put 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
