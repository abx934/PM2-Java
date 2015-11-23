package aufgabenblatt2;
import java.util.ArrayList;
import java.util.List;

public class Autorennen {
	public static List<Rennauto> teilnehmerListe;
	
	public static void main(String[] args){
		teilnehmerListe=new ArrayList<Rennauto>();
		for(int teilnehmer=0; teilnehmer<10; teilnehmer++){
			teilnehmerListe.add(new Rennauto(1,10,teilnehmer));
		}
		
		for(int teilnehmer=0; teilnehmer<10; teilnehmer++){
			teilnehmerListe.get(teilnehmer).start();
		}
		
		RennAbbruch rennAbbrecher=new RennAbbruch();
		rennAbbrecher.start();
		
		teilnehmerListe.forEach(teilnehmer->{
			try{
				teilnehmer.join();
			}catch(InterruptedException e){

			}
		});
		rennAbbrecher.interrupt();
		
		System.out.println("Das Rennen ist beendet!");
		System.out.println("Die Ergebnisse: ");
		teilnehmerListe.sort(null);
		teilnehmerListe.forEach(teilnehmer -> teilnehmer.toPrintStream());
	}
}
