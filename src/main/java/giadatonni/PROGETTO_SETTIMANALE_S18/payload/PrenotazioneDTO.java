package giadatonni.PROGETTO_SETTIMANALE_S18.payload;

import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Dipendente;
import giadatonni.PROGETTO_SETTIMANALE_S18.entities.Viaggio;

public record PrenotazioneDTO (
        String richiesteSpeciali,
        Viaggio viaggio,
        Dipendente dipendente
) {
}
