package no.hvl.dat108.registrering.util;

public class InputValidator {

	public static String MobilRegex() {
    return "^\\d{8}$";
	}
	public static String FornavnRegex() {
	    return "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-\\s]*";
	}
	public static String EtternavnRegex() {
	    return "^[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-]*";
	}
	public static String KjonnRegex() {
	    return "^(mann|kvinne)$";
	}   

}
	







