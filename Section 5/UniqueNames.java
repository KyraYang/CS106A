/*
 * File: UniqueNames.java
 * ---------------------
 * Ask user to enter name, until the user enters a blank line.
 * Print out names entered, each name is listed only once.
 */

import java.util.ArrayList;
import acm.program.*;

public class UniqueNames extends ConsoleProgram {

	
	
	public void run() {
		ArrayList<String> nameList = new ArrayList<String>();
		while (true){
			String name = readLine("Enter name: ");
			if (name.equals("")) break;
			if (!nameList.contains(name)){
				nameList.add(name);
				};
		}
		println("Unique name list contains: ");
		for (int i = 0; i<nameList.size();i++){
			println(nameList.get(i));
		}
		}
	}


