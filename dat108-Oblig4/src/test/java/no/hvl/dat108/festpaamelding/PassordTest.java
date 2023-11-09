package no.hvl.dat108.festpaamelding;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat108.registrering.util.SessionUtil;

public class PassordTest {
	
	PassordService service;
	
	String p0;
	String p1;
	String s0;
	String s1;
	String h0;
	String h1;
	
	@BeforeEach
	void setup() {
		
		service = new PassordService();
		
		p0 = "passord123";
		p1 = "paSSord321!_%&";
		
		s0 = service.genererTilfeldigSalt();
		s1 = service.genererTilfeldigSalt();
		
		h0 = service.hashMedSalt(p0, s0);
		h1 = service.hashMedSalt(p1, s1);
	}

	@Test
	void testPassordKonversjon() {
		
	assertTrue(service.erKorrektPassord(p0, s0, h0));	
	assertTrue(service.erKorrektPassord(p1, s1, h1));
		
	}
	
	@Test
	void testPassordFeil() {
		
	assertFalse(service.erKorrektPassord(p1, s0, h0));	
	assertFalse(service.erKorrektPassord(p0, s1, h1));
		
	}

 }

