package aufgabenblatt2;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Rechner{
	private Map<Operation,BinaryOperator<Double>> eingabe;
	private final double EPSILON;
	
	public Rechner(){
		EPSILON=0.0000000000001;
		eingabe=new HashMap<Operation,BinaryOperator<Double>>();
		eingabe.put(Operation.add, (zahl1,zahl2)->zahl1+zahl2);
		eingabe.put(Operation.sub, (zahl1,zahl2)->zahl1-zahl2);
		eingabe.put(Operation.mul, (zahl1,zahl2)->zahl1*zahl2);	
		eingabe.put(Operation.div, (zahl1,zahl2)->{
			if((Math.abs(0.0+zahl2)<EPSILON)){
				throw new ArithmeticException();
			}else{
				return zahl1/zahl2;
				}
		});
	}
	
	public double berechne(Operation operation, double zahl1, double zahl2){
		return eingabe.get(operation).apply(zahl1, zahl2);
	}
}
