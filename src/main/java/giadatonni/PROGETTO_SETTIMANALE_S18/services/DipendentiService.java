package giadatonni.PROGETTO_SETTIMANALE_S18.services;

import giadatonni.PROGETTO_SETTIMANALE_S18.repositories.DipendentiRepository;
import org.springframework.stereotype.Service;

@Service
public class DipendentiService {
    private final DipendentiRepository dipendentiRepository;

    public DipendentiService(DipendentiRepository dipendentiRepository) {
        this.dipendentiRepository = dipendentiRepository;
    }
}
