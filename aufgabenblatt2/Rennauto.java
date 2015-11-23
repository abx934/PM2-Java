package aufgabenblatt2;

import java.io.PrintStream;

public class Rennauto extends Thread implements Comparable<Rennauto>{
	private double durchschnittsGeschwindigkeit;
	private double streckeInMeter;
	private double rennzeitInSekunden;
	private int wagenID;
	
	public Rennauto(int wagenID){
		durchschnittsGeschwindigkeit=1;
		streckeInMeter=10;
		this.wagenID=wagenID;
	}
	
	public Rennauto(double durchschnittsGeschwindigkeit, double streckeInMeter, int wagenID){
		this.durchschnittsGeschwindigkeit=durchschnittsGeschwindigkeit;
		this.streckeInMeter=streckeInMeter;
		this.wagenID=wagenID;
	}
	
	@Override
	public void run(){
		double start=System.currentTimeMillis();
		try{
			for(double i=0; i<streckeInMeter+1; i+=durchschnittsGeschwindigkeit){
				Thread.sleep(800 + ((int)Math.random()*400));
				System.err.printf("Der Wagen" + wagenID + ": %.1f/%1f", i, streckeInMeter);
			}
		}catch(InterruptedException e){
			interrupted();
		}
		rennzeitInSekunden=(((double)(System.currentTimeMillis()-start))/1000);
	}
	
	@Override
	public int compareTo(Rennauto anderesAuto) {
		if(getRennZeitDauer()>anderesAuto.getRennZeitDauer()){
			return 1;
		}else if(getRennZeitDauer()<anderesAuto.getRennZeitDauer()){
			return -1;
		}else{
			return 0;
		}
	}
	
	public double getRennZeitDauer(){
		return rennzeitInSekunden;
	}
	
	public double getWagenID(){
		return wagenID;
	}
	
	public PrintStream toPrintStream(){
		return System.out.printf("Wagen " + wagenID + ": %1f Sekunden \n", rennzeitInSekunden);
	}
}