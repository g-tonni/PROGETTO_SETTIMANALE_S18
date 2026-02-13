package giadatonni.PROGETTO_SETTIMANALE_S18.controllers;


import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Dipendente;
import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Prenotazione;
import giadatonni.PROGETTO_SETTIMANALE_S18.exceptions.ValidationException;
import giadatonni.PROGETTO_SETTIMANALE_S18.payload.DipendenteDTO;
import giadatonni.PROGETTO_SETTIMANALE_S18.payload.PrenotazioneDTO;
import giadatonni.PROGETTO_SETTIMANALE_S18.payload.PutPrenotazioneDTO;
import giadatonni.PROGETTO_SETTIMANALE_S18.services.PrenotazioniService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

    private final PrenotazioniService prenotazioniService;

    public PrenotazioniController(PrenotazioniService prenotazioniService) {
        this.prenotazioniService = prenotazioniService;
    }

    @GetMapping
    public Page<Prenotazione> getPrenotazioni(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "dataPrenotazione") String orderBy){
        return this.prenotazioniService.getPrenotazioni(page, size, orderBy);
    }

    @GetMapping("/{prenotazioneId}")
    public Prenotazione getPrenotazioneById(@PathVariable UUID prenotazioneId){
        return this.prenotazioniService.findById(prenotazioneId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione postPrenotazione(@RequestBody @Validated PrenotazioneDTO body, BindingResult validationResults){
        if (validationResults.hasErrors()){
            List<String> errors = validationResults.getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).toList();
            throw new ValidationException(errors);
        } else {
            return this.prenotazioniService.postPrenotazione(body);
        }
    }

    @PutMapping("/{prenotazioneId}")
    public Prenotazione putPrenotazione(@PathVariable UUID prenotazioneId, @RequestBody @Validated PutPrenotazioneDTO body, BindingResult validationResults){
        if (validationResults.hasErrors()){
            List<String> errors = validationResults.getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).toList();
            throw new ValidationException(errors);
        } else {
            return this.prenotazioniService.putPrenotazione(prenotazioneId, body);
        }
    }

    /*@DeleteMapping("/{PrenotazioneId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Prenotazione deletePrenotazione(@PathVariable UUID PrenotazioneId){}*/
}
