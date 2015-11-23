package aufgabenblatt2;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class EingabenVerarbeitungTest {
	private String[] woerterTest={null, "EINGABE", "Äussere", " ha-ha ",null , "Straßen-Feger"};
	List<String> verarbeitungTest;
	EingabenVerarbeitung filter;
	
	public EingabenVerarbeitungTest(){
		filter=new EingabenVerarbeitung();
	}
	
	@Test
	public void test() {
		verarbeitungTest=filter.verarbeite(woerterTest);
		assertEquals("Die Laenge des Arrays muss 4 sein!", 4,verarbeitungTest.size());
		assertTrue("Das erste Wort muss 'EINGABE' lauten!",verarbeitungTest.get(0).equals("EINGABE"));
		assertTrue("Das zweite Wort muss 'AEUSSERE' lauten!",verarbeitungTest.get(1).equals("AEUSSERE"));
		assertTrue("Das dritte Wort muss'HA-HA' lauten!", verarbeitungTest.get(2).equals("HA-HA"));
		assertTrue("Das vierte Wort muss 'STRASSEN-FEGER' lauten!", verarbeitungTest.get(3).equals("STRASSEN"));
	}
}
