import java.util.concurrent.BlockingQueue;

/**
 * @author xiaqing
 * @date 2017/11/15.
 */
public class Consumer implements Runnable{

    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue <String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    public void run() {
        try {
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
