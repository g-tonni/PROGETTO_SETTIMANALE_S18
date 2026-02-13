package giadatonni.PROGETTO_SETTIMANALE_S18.repositories;

import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {

    @Query("SELECT p FROM Prenotazione p WHERE p.dipendente.dipendenteId = :dipendenteId")
    List<Prenotazione> findByDipendente(UUID dipendenteId);
}
