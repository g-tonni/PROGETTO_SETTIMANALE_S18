package giadatonni.PROGETTO_SETTIMANALE_S18.payload;

import jakarta.persistence.Column;

import java.time.LocalDate;

public record ViaggioDTO (
    String destinazione,
    LocalDate dataPartenza,
    LocalDate dataRitorno){
}
