package giadatonni.PROGETTO_SETTIMANALE_S18.controllers;

import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Viaggio;
import giadatonni.PROGETTO_SETTIMANALE_S18.payload.ViaggioDTO;
import giadatonni.PROGETTO_SETTIMANALE_S18.services.ViaggiService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/viaggi")
public class ViaggiController {

    private final ViaggiService viaggiService;

    public ViaggiController(ViaggiService viaggiService) {
        this.viaggiService = viaggiService;
    }

    @GetMapping
    public Page<Viaggio> getViaggi(){}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio postViaggio(@RequestBody ViaggioDTO body){}

    @PutMapping("/{viaggioId}")
    public Viaggio putViaggio(@PathVariable UUID viaggioId, @RequestBody ViaggioDTO body){}

    @DeleteMapping("/{viaggioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Viaggio deleteViaggio(@PathVariable UUID viaggioId){}
}
