package tr.gov.ua.obs.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class OgrenciNotFoundException extends RuntimeException{

    public OgrenciNotFoundException(String message) {
        super(message);
    }
}
