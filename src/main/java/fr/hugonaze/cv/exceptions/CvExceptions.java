package fr.hugonaze.cv.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Ma classe de gestion des exceptions
 * @author hugon
 *
 */
public class CvExceptions extends Exception {

private List<String> messages = new ArrayList<String>();
	
	public CvExceptions() {
		
	}
	
	public void addMessage (String message) {
		messages.add(message);
	}
	
	public boolean hasErrors() {
		boolean hasErrors = false;
		if(messages.size() > 0) {
			hasErrors = true;
		}
		return hasErrors;
	}
	
	public void clear() {
		messages.clear();
	}
	
	public String getMessage(int index) {
		return messages.get(index);
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
	@Override
	public String toString() {
		String resultat = "";
		
		for(int i = 0; i < messages.size(); i++) {
			resultat = resultat + messages.get(i) + "\n";
		}
		
		return resultat;
	}
	
}
