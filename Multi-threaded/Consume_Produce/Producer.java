//Andrew McKeown
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {
	LinkedBlockingQueue<String> queue = null;
	ReentrantLock lock;
	Condition cond;
	int max;

	// constructor
	public Producer(ReentrantLock lock, Condition cond, int max, LinkedBlockingQueue<String> queue) {
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
			// i < 2 gives us 2 Strings to the queue
			for (int i = 0; i < 2; i++) {
				// while the queue is full, wait to be consumed!
				while (queue.size() == max) {
					try {
						System.out.println("List is full");
						cond.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("--------------------");
				// new string produced
				System.out.println("Produced String " + i);
				// add this new string to queue
				queue.add("String " + i);
				// display what is currently in the queue
				System.out.println(queue);
				// display current thread
				System.out.println(Thread.currentThread());
				// signal to the other thread lock
				cond.signalAll();
				try {
					// if cond.await() is placed here then each string
					// is immediately consumed after being produced.

					Thread.sleep(500);// make thread sleep for half a second.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			// attempts to release the lock
			lock.unlock();

		}
	}
}
