package inClass;

import java.io.IOException;

public class SimpleThreadExample {

	
	public void go(){
		Task t = new Task(777);
		
		for(int i = 10; i< 20; i++){
			//new Thread(new Task(i), "T " + i).start(); //Hollywood principle
			new Thread(t, "T " + i).start(); //Hollywood principle
		}
	}
	
	private class Task implements Runnable{//task is sitting on the heap as it's an object

		private int value ;
		
		private Task(int num){
			this.value = num;
			
		}
		public void run() {
			
			int counter = 0; 
			while(counter < value){
				if (counter > 15){
					Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
				}
				System.out.println(Thread.currentThread().getName() + "...running");
				
				try {
					Thread.sleep(1000);// let sleeping threads lie
				} catch (InterruptedException e) {}
				counter++;
			}
			System.out.println("Task" + value + " finished");		
		}
	}
	
	public static void main(String[] args) throws IOException {
		int i = System.in.read();
		new SimpleThreadExample().go();
		
	}
}
