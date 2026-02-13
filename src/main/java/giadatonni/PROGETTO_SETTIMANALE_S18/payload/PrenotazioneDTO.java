package giadatonni.PROGETTO_SETTIMANALE_S18.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record PrenotazioneDTO (
        @Size(max = 30, message = "Le richieste speciali non possono superare i 500 caratteri")
        String richiesteSpeciali,
        @NotNull
        UUID viaggio,
        @NotNull
        UUID dipendente
) {
}
