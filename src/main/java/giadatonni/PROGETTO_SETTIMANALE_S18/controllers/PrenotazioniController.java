package giadatonni.PROGETTO_SETTIMANALE_S18.controllers;


import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Dipendente;
import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Prenotazione;
import giadatonni.PROGETTO_SETTIMANALE_S18.payload.DipendenteDTO;
import giadatonni.PROGETTO_SETTIMANALE_S18.payload.PrenotazioneDTO;
import giadatonni.PROGETTO_SETTIMANALE_S18.services.PrenotazioniService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

    private final PrenotazioniService prenotazioniService;

    public PrenotazioniController(PrenotazioniService prenotazioniService) {
        this.prenotazioniService = prenotazioniService;
    }

    /*@GetMapping
    public Page<Prenotazione> getPrenotazioni(){}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione postPrenotazione(@RequestBody PrenotazioneDTO body){}

    @PutMapping("/{PrenotazioneId}")
    public Prenotazione putPrenotazione(@PathVariable UUID PrenotazioneId, @RequestBody PrenotazioneDTO body){}

    @DeleteMapping("/{PrenotazioneId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Prenotazione deletePrenotazione(@PathVariable UUID PrenotazioneId){}*/
}
