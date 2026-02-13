package giadatonni.PROGETTO_SETTIMANALE_S18.repositories;

import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ViaggiRepository extends JpaRepository<Viaggio, UUID> {
}
