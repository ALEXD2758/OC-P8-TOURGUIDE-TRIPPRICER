package tripPricer.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UUIDException extends Exception {

    private Logger logger = LoggerFactory.getLogger(UUIDException.class);
    public UUIDException(String attractionId) {
        super("UUID attractionId invalid  : " + attractionId);
        logger.error("UUID attractionId invalid  : " + attractionId);
    }
}