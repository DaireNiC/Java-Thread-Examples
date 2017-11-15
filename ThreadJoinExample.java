package inClass;

public class ThreadJoinExample {
	
	
	
	public void go() throws InterruptedException{
		 Thread t1 = new Thread(new Task(), "T1");
		 Thread t2 = new Thread(new Task(), "T2");
		 Thread t3 = new Thread(new Task(), "T3");
		 
		 t1.start(); 
		 t1.join(2000);//waits for thread to finish 
		 
		 t2.start();
		 t1.join(); //waiting until thread finished before exiting JVM
		 
		 t3.start();
		 
		 t1.join();
		 t2.join();
		 t3.join();
		 
		 System.out.println("All thread dead....exiting JVM");
	}
	
	private class Task implements Runnable{ //better to implement than to extend
		
		public void run(){
			System.out.println(Thread.currentThread().getName() + "started");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "finished");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new ThreadJoinExample().go();
	}

}
