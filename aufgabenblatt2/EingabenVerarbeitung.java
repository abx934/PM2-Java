package aufgabenblatt2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EingabenVerarbeitung {
	public List<String> verarbeite(String[] eingabe){
		List<String> ergebnisListe = new ArrayList<String>();
		List<String> eingabenListe = Arrays.asList(eingabe);
		eingabenListe.stream().filter(x -> x!=null).map(x -> x.trim())
							  .map(x -> x.toUpperCase())
							  .map(x -> x.replace("�", "AE"))
							  .map(x -> x.replace("�", "OE"))
							  .map(x -> x.replace("�", "UE"))
							  .map(x -> x.replace("�", "SS"))
							  .map(x -> {
								  if(x.length() > 8){
									  return x.substring(0,8);
								  }
								  return x;
							  }).forEach(x -> ergebnisListe.add(x));
		return ergebnisListe;
	}
}
