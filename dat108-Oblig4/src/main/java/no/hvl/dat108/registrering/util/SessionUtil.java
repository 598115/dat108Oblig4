package no.hvl.dat108.registrering.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionUtil {
	
   public static boolean erLoggetInn(HttpSession session) {
	   
	if(session != null) {
	   try {
	        session.getAttribute("deltager");
	        if(session.getAttribute("deltager") != null) {
	        return true; 
	        }
	        return false;
	    } catch (IllegalStateException e) {
	        return false;
	    }
   }
  return false;
}
}