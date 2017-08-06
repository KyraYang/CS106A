/* 
* File: altCaps.java
 * -------------------
 *Converts a string to alternating capital letters, 
 *meaning you alternate between uppercase and lowercase
 */


import acm.program.*;

public class altCaps extends ConsoleProgram {

private String altCaps(String str){
	String alted = "";
	int i=0;
	while(i<str.length()){
		if (i%2==0){
			if (str.charAt(i)>='A' && str.charAt(i)<='z'){
				String sub = str.substring(i, i+1);
				alted += sub.toLowerCase();
			}else {
				alted+= str.substring(i, i+1);
			}}else {
				if (str.charAt(i)>='A' && str.charAt(i)<='z'){
					String sub = str.substring(i, i+1);
					alted += sub.toUpperCase();
				}else {
					alted+= str.substring(i, i+1);
			}
		}
		i++;
	}
	return alted;
}

public void run() { 
	while (true) {
	String str = readLine("Enter a string: "); 
	if (str.length()==0) break;
	println(altCaps(str));
} }
}
