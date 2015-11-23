package aufgabenblatt2;

public class RennAbbruch extends Thread{
	@Override
	public void run(){
		boolean abbruchErfuellt=false;
		try{
			while(!abbruchErfuellt){
				Thread.sleep(1000);
				if(Math.random()*10<1){
					
				}
			}
		}catch(InterruptedException e){
			interrupt();
		}
	}
}
