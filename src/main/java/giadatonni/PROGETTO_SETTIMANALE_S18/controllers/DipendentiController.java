package giadatonni.PROGETTO_SETTIMANALE_S18.controllers;

import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Dipendente;
import giadatonni.PROGETTO_SETTIMANALE_S18.payload.DipendenteDTO;
import giadatonni.PROGETTO_SETTIMANALE_S18.services.DipendentiService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

    private final DipendentiService dipendentiService;

    public DipendentiController(DipendentiService dipendentiService) {
        this.dipendentiService = dipendentiService;
    }

    @GetMapping
    public Page<Dipendente> getDipendenti(){}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente postDipendente(@RequestBody DipendenteDTO body){}

    @PutMapping("/{dipendenteId}")
    public Dipendente putDipendente(@PathVariable UUID dipendenteId, @RequestBody DipendenteDTO body){}

    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Dipendente deleteDipendente(@PathVariable UUID dipendenteId){}


}
