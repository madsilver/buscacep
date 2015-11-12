package org.buscacep.conf;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice
public class JsonAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonAdvice() {
        super("callback");
    }
}
