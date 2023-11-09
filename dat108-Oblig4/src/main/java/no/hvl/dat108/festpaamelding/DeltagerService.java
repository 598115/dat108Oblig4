package no.hvl.dat108.festpaamelding;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DeltagerService {
	
	@Autowired private RegistreringRepo repo;
	
	public void registrerDeltager(Deltager d) {
		System.err.println(d.toString());
		repo.save(d);
		System.err.println("Deltager ble registrert");
	}
	
	public List<Deltager> finnDeltagere() {
		System.err.println("Deltagere ble hentet");
		return repo.findAll();
	}
	
	public Optional<Deltager> finnDeltagerMedId(String s) {
		System.err.println("En deltager ble hentet");
		return repo.findById(s);
	}

}
