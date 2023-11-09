package no.hvl.dat108.festpaamelding;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.registrering.util.SessionUtil;

class IsSessionUnvalidTest {

	@Test
	void test() {
		assertFalse(SessionUtil.erLoggetInn(null));
	}

}
