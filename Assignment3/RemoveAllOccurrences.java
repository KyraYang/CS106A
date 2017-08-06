/* 
* File: RemoveAllOccurrences.java
 * -------------------
 * 
 *Removes all occurrences of the character ch from the string str
 */


import acm.program.*;

public class RemoveAllOccurrences extends ConsoleProgram {

private String removeAllOccurrences(String str, char ch){
	String deletedSentence = "";
	int i=0;
	while(i<str.length()){
		if (str.charAt(i)!=ch){
			deletedSentence+=str.substring(i, i+1);
		}
		i++;
	}
	return deletedSentence;
}

public void run() { 
	while (true) {
	String sentence = readLine("Enter a sentence: "); 
	char toDelete = readLine("Enter an character: ").charAt(0);
	println(removeAllOccurrences(sentence,toDelete));
} }
}
