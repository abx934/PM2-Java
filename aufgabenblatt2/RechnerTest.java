package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

public class RechnerTest {
	private final double EPSILON=0.000000000001;
	
	DoubleDoubleZuDouble add=(zahl1,zahl2)->(zahl1+zahl2);
	DoubleDoubleZuDouble sub=(zahl1,zahl2)->(zahl1-zahl2);
	DoubleDoubleZuDouble mul=(zahl1,zahl2)->(zahl1*zahl2);
	DoubleDoubleZuDouble div=(zahl1,zahl2)->{
		if((Math.abs(0.0+zahl2)<EPSILON)){
			throw new ArithmeticException("Sie duerfen keine 0 als Divisor nehmen");
		}else{
			return zahl1/zahl2;
		}
	};
	
	@Test
	public void testAddition() {
		try{
			assertTrue("Das Ergebnis sollte sein: 3,0",(Math.abs(add.werteAus(1.0, 2.0) - 3.0)<EPSILON));
			assertTrue("Das Ergebnis sollte sein: 8,0",(Math.abs(add.werteAus(9.0, -1.0) - 8.0)<EPSILON));
			assertTrue("Das Ergebnis sollte sein: 2,0",(Math.abs(add.werteAus(2.0, 0.0) - 2.0)<EPSILON));
			assertTrue("Das Ergebnis sollte sein: 1,0",(Math.abs(add.werteAus(-2.0, 3.0) - 1.0)<EPSILON));
		}catch(Exception e){
			System.err.println("Ein oder mehrere Addier-Test/s funktionieren nicht einwandfrei!");
		}
	}

	@Test
	public void testSubtraktion(){
		try{
			assertTrue("Das Ergebnis sollte sein: -1,0",(Math.abs(sub.werteAus(1.0, 2.0) + 1.0)<EPSILON));
			assertTrue("Das Ergebnis sollte sein: -10,0",(Math.abs(sub.werteAus(-1,9) + 10.0)<EPSILON));
			assertTrue("Das Ergebnis sollte sein: 2,0",(Math.abs(sub.werteAus(2.0, 0.0) - 2.0)<EPSILON));
			assertTrue("Das Ergebnis sollte sein: 5,0",(Math.abs(sub.werteAus(-2.0, 3.0) + 5.0)<EPSILON));
		}catch(Exception e){
			System.err.println("Ein oder mehrere Subtrahier-Test/s funktionieren nicht einwandfrei!");
		}
	}
	
	@Test
	public void testMultiplikation() {
		try{
			assertTrue("Das Ergebnis sollte sein: 2,0",(Math.abs(mul.werteAus(1.0, 2.0) - 2.0)<EPSILON));
			assertTrue("Das Ergebnis sollte sein: -9,0",(Math.abs(mul.werteAus(9.0, -1.0) + 9.0)<EPSILON));
			assertTrue("Das Ergebnis sollte sein: 0,0",(Math.abs(mul.werteAus(2.0, 0.0))<EPSILON));
			assertTrue("Das Ergebnis sollte sein: -6,0",(Math.abs(mul.werteAus(-2.0, 3.0) + 6.0)<EPSILON));
		}catch(Exception e){
			System.err.println("Ein oder mehrere Multiplizier-Test/s funktionieren nicht einwandfrei!");
		}
	}
	
	@Test
	public void testDivision(){
		try{
			assertTrue("Das Ergebnis sollte sein: 10",(Math.abs(div.werteAus(20, 2)-10)<EPSILON));
			assertTrue("Das Ergebnis sollte sein: 1",(Math.abs(div.werteAus(10, 10)-1)<EPSILON));
			assertTrue("Das Ergebnis sollte sein: -2",(Math.abs(div.werteAus(-20, 10)+2)<EPSILON));
			try{
				assertTrue("Das Ergebnis sollte sein: -10",(Math.abs(div.werteAus(-10, 0)+10)<EPSILON));
			}catch(ArithmeticException e){
				System.err.println("Sie duerfen keine Null als Divisor nehmen!");
			}
		}catch(Exception e){
			System.err.println("Ein oder mehrere Division-Test/s funktionieren nicht einwandfrei!");
		}
	}
}
