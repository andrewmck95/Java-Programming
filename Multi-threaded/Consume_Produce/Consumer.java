//Andrew McKeown
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {
	LinkedBlockingQueue<String> queue = null;
	ReentrantLock lock;
	Condition cond;
	int max;

	// constructor
	public Consumer(ReentrantLock lock, Condition cond, int max, LinkedBlockingQueue<String> queue) {
		super();
		this.lock = lock;
		this.cond = cond;
		this.max = max;
		this.queue = queue;
	}

	@Override
	public void run() {
		lock.lock();
		try {
			// i < 2 takes 2 strings from the queue
			for (int i = 0; i < 2; i++) {
				while (queue.isEmpty()) {
					try {
						System.out.println("List is empty");
						cond.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("--------------------");
				// prints string that is consumed
				System.out.println("Consumed " + queue.remove());
				// prints current queue size and current remaining capacity of
				// queue
				System.out.println(
						queue + " \nQueue size: " + queue.size() + "\nRemaining capacity:" + queue.remainingCapacity());
				// prints the current thread
				System.out.println(Thread.currentThread());
				cond.signalAll();
			}
		} finally {
			// attempts to release lock
			lock.unlock();
		}
	}
}