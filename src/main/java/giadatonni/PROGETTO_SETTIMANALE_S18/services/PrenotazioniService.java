package giadatonni.PROGETTO_SETTIMANALE_S18.services;

import giadatonni.PROGETTO_SETTIMANALE_S18.repositories.PrenotazioniRepository;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioniService {

    private final PrenotazioniRepository prenotazioniRepository;

    public PrenotazioniService(PrenotazioniRepository prenotazioniRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
    }
}
