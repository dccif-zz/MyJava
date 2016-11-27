
public class LearnThread extends Thread{
	String threadName;
	public LearnThread(String threadName){
		System.out.println(threadName);
			this.threadName = threadName;
	}
	public void run(){
		for(int i = 0 ; i < 3 ; i ++){
			System.out.println(threadName);
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
		LearnThread thread1 = new LearnThread("he");
		LearnThread thread2 = new LearnThread("yu");
		thread1.start();
		thread2.start();
	}

}
