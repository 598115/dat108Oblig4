package no.hvl.dat108.festpaamelding;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistreringRepo extends JpaRepository<Deltager, String> {	
}
