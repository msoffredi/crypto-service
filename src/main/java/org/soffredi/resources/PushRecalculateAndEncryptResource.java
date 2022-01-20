package org.soffredi.resources;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import org.soffredi.api.EncryptedAvgAndDev;
import org.soffredi.core.Calculator;
import org.soffredi.core.InputNumber;

@Path("/push-recalculate-and-encrypt")
@Produces(MediaType.APPLICATION_JSON)
public class PushRecalculateAndEncryptResource {
    private final String encryptionKey;

    public PushRecalculateAndEncryptResource(String key) {
        encryptionKey = key;
    }

    @POST
    @Timed
    public EncryptedAvgAndDev push(@Valid InputNumber inputNumber) {
        final Calculator cal = Calculator.getInstance();
        cal.push(inputNumber.getNumber());
        return new EncryptedAvgAndDev(cal.getMean(), cal.getStdDev(), encryptionKey);
    }
}
