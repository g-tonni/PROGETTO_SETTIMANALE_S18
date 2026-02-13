package giadatonni.PROGETTO_SETTIMANALE_S18.services;

import giadatonni.PROGETTO_SETTIMANALE_S18.repositories.ViaggiRepository;
import org.springframework.stereotype.Service;

@Service
public class ViaggiService {

    private final ViaggiRepository viaggiRepository;

    public ViaggiService(ViaggiRepository viaggiRepository) {
        this.viaggiRepository = viaggiRepository;
    }
}
