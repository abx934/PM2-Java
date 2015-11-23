package aufgabenblatt2;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Woerterliste {
	private String[] woerterListe={"Eingabe ","Äußeres ",null,"Strassen-Feger"," ein Haus"};
	List<String> liste=Arrays.asList(woerterListe);
	Stream<String> woerterStream=liste.stream();
	
	Stream<String> woerterStreamNachBearbeitung=woerterStream.filter(wort->(wort!=null))
			.filter(wort->(wort.length()<=8))
			.map(wort->(wort.toUpperCase()))
			.map(wort->(wort.replace("Ä", "AE")))
			.map(wort->(wort.replace("Ö", "OE")))
			.map(wort->(wort.replace("Ü", "UE")))
			.map(wort->(wort.replace("ß", "SS")));
}
