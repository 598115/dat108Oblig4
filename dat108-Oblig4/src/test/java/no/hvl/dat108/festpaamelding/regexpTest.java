package no.hvl.dat108.festpaamelding;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat108.registrering.util.InputValidator;

public class regexpTest {
	
	String m;
	String fn;
	String en;
	String kj;
	
	@BeforeEach
	public void setup() {
    	m = InputValidator.MobilRegex();
    	fn = InputValidator.FornavnRegex();
    	en = InputValidator.EtternavnRegex();
    	kj = InputValidator.KjonnRegex();
    }

	
    @Test
    public void regExpValidTest() {
    	
    	String validM = "11223344";
    	String validFn = "Trym";
    	String validEn = "Berger";
    	String validKj = "kvinne";
    	
    	assertTrue(validM.matches(m));
    	assertTrue(validFn.matches(fn));
    	assertTrue(validEn.matches(en));
    	assertTrue(validKj.matches(kj));
    }
    
    @Test
    public void regExpUnValidTest() {
    	
    	String unvalidM = "112f233443";
    	String unvalidFn = "T67";
    	String unvalidEn = "Berger ere";
    	String unvalidKj = "Helikopter";
    	
    	assertFalse(unvalidM.matches(m));
    	assertFalse(unvalidFn.matches(fn));
    	assertFalse(unvalidEn.matches(en));
    	assertFalse(unvalidKj.matches(kj));
    }

}
