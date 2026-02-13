package giadatonni.PROGETTO_SETTIMANALE_S18.controllers;

import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Dipendente;
import giadatonni.PROGETTO_SETTIMANALE_S18.exceptions.ValidationException;
import giadatonni.PROGETTO_SETTIMANALE_S18.payload.DipendenteDTO;
import giadatonni.PROGETTO_SETTIMANALE_S18.services.DipendentiService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

    private final DipendentiService dipendentiService;

    public DipendentiController(DipendentiService dipendentiService) {
        this.dipendentiService = dipendentiService;
    }

    @GetMapping
    public Page<Dipendente> getDipendenti(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "cognome") String orderBy){
        return this.dipendentiService.getDipendenti(page, size, orderBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente postDipendente(@RequestBody @Validated DipendenteDTO body, BindingResult validationResults){
        if (validationResults.hasErrors()){
            List<String> errors = validationResults.getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).toList();
            throw new ValidationException(errors);
        } else {
           return this.dipendentiService.postDipendente(body);
        }
    }

    @GetMapping("/{dipendenteId}")
    public Dipendente getDipendenteById(@PathVariable UUID dipendenteId){
        return this.dipendentiService.findById(dipendenteId);
    }

    @PutMapping("/{dipendenteId}")
    public Dipendente putDipendente(@PathVariable UUID dipendenteId, @RequestBody @Validated DipendenteDTO body, BindingResult validationResults){
        if (validationResults.hasErrors()){
            List<String> errors = validationResults.getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).toList();
            throw new ValidationException(errors);
        } else {
            return this.dipendentiService.putDipendente(dipendenteId, body);
        }
    }

    /*@DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Dipendente deleteDipendente(@PathVariable UUID dipendenteId){}*/


}
