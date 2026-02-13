package giadatonni.PROGETTO_SETTIMANALE_S18.exceptions;

import java.util.List;

public class ValidationException extends RuntimeException {

    public List<String> listaErrori;

    public ValidationException(List<String> listaErrori) {

        super("Errore nella validazione");
        this.listaErrori = listaErrori;

    }
}
