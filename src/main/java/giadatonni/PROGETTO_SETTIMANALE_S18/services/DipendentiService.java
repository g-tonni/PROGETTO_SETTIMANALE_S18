package giadatonni.PROGETTO_SETTIMANALE_S18.services;

import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Dipendente;
import giadatonni.PROGETTO_SETTIMANALE_S18.exceptions.BadRequestException;
import giadatonni.PROGETTO_SETTIMANALE_S18.exceptions.NotFoundException;
import giadatonni.PROGETTO_SETTIMANALE_S18.exceptions.ValidationException;
import giadatonni.PROGETTO_SETTIMANALE_S18.payload.DipendenteDTO;
import giadatonni.PROGETTO_SETTIMANALE_S18.repositories.DipendentiRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DipendentiService {
    private final DipendentiRepository dipendentiRepository;

    public DipendentiService(DipendentiRepository dipendentiRepository) {
        this.dipendentiRepository = dipendentiRepository;
    }

    public Page<Dipendente> getDipendenti(int page, int size, String orderBy){
        if(page < 0) page = 0;
        if(page > 30) page = 30;
        if(size < 0) size = 0;
        if(size > 20) size = 20;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return this.dipendentiRepository.findAll(pageable);
    }

    public Dipendente findById(UUID dipendenteId){
        return this.dipendentiRepository.findById(dipendenteId).orElseThrow(() -> new NotFoundException(dipendenteId));
    }

    public Dipendente postDipendente(DipendenteDTO body){
        if (this.dipendentiRepository.existsByUsername(body.username())) throw new BadRequestException("Username già in uso");
        if (this.dipendentiRepository.existsByEmail(body.email())) throw new BadRequestException("Email già in uso");
        String imageUrl = "https://ui-avatars.com/api/?name=" + body.nome() + "+" + body.cognome();
        Dipendente nuovoDipendente = new Dipendente(body.username(), body.nome(), body.cognome(), body.email(), imageUrl);
        this.dipendentiRepository.save(nuovoDipendente);
        System.out.println("Dipendente salvato");
        return nuovoDipendente;
    }

    public Dipendente putDipendente(UUID dipendenteId, DipendenteDTO body){
        Dipendente found = this.findById(dipendenteId);
        if(!found.getUsername().equals(body.username())){
           if (this.dipendentiRepository.existsByUsername(body.username())) throw new BadRequestException("Username già in uso");
        }
        if(!found.getEmail().equals(body.email())){
           if (this.dipendentiRepository.existsByEmail(body.email())) throw new BadRequestException("Email già in uso");
        }
        found.setUsername(body.username());
        found.setNome(body.nome());
        found.setCognome(body.cognome());
        found.setEmail(body.email());
        this.dipendentiRepository.save(found);
        System.out.println("Dipendente aggiornato");
        return found;
    }
}
