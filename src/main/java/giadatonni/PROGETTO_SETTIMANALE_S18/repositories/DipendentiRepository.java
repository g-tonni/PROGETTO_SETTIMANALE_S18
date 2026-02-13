package giadatonni.PROGETTO_SETTIMANALE_S18.repositories;

import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DipendentiRepository extends JpaRepository<Dipendente, UUID> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
