package giadatonni.PROGETTO_SETTIMANALE_S18.payload;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ViaggioDTO (
    @NotBlank(message = "La destinazione deve essere inserita")
    @Size(min = 3, max = 30, message = "La destinazione deve essere compresa tra 3 e 30 caratteri")
    String destinazione,
    @NotNull
    @Future
    LocalDate dataPartenza,
    @NotNull
    @Future
    LocalDate dataRitorno){
}
