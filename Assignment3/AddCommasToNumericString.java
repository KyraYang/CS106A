/* 
* File: AddCommasToNumbericSTring.java
 * -------------------
 * 
 *Add comma to every 3 number.
 */


import acm.program.*;

public class AddCommasToNumericString extends ConsoleProgram {

private String addCommasToNumericString(String digits){
	String CommaedDigits ="";
	while(digits.length()>3){
		CommaedDigits = ","+digits.substring(digits.length()-3)+CommaedDigits;
		digits = digits.substring(0, digits.length()-3);
	}
	return digits+CommaedDigits;
}

public void run() { 
	while (true) {
	String digits = readLine("Enter a numeric string: "); 
	if (digits.length() == 0) break; 
	println(addCommasToNumericString(digits));
} }
}
