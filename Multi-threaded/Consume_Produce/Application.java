//Andrew McKeown
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
	public static void main(String[] args) throws InterruptedException {
		// maximum capacity of this queue is set to 4,
		// though 2 Strings will be produced to make the
		// test less complex and easier to read
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(4);
		ReentrantLock lock = new ReentrantLock();
		Condition cond = lock.newCondition();
		Random rand = new Random();
		// random number between 1 and 10
		int random = rand.nextInt(10) + 1;
		// thread pool
		ExecutorService executor = Executors.newFixedThreadPool(random);
		// creating a random number of threads
		for (int i = 0; i < random; i++) {
			// creating a producer thread
			Runnable worker = new Thread(new Producer(lock, cond, 2, queue));
			// creating a consumer thread
			Runnable worker2 = new Thread(new Consumer(lock, cond, 2, queue));
			executor.execute(worker);
			executor.execute(worker2);
		}
		// shutting down thread pool
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("\n**********************");
		System.out.println("Finished all threads");
		System.out.println("Number of threads created is: " + random);
	}
}
