package org.soffredi.resources;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import org.soffredi.api.EncryptedAvgAndDev;
import org.soffredi.api.MyNumber;
import org.soffredi.core.AES;
import org.soffredi.core.Calculator;

/**
 * Defines the resource class for the /push-recalculate-and-encrypt POST endpoint
 */
@Path("/push-recalculate-and-encrypt")
@Produces(MediaType.APPLICATION_JSON)
public class PushRecalculateAndEncryptResource {
    final private String encryptionKey;

    /**
     * Constructor
     * 
     * @param key encryption key
     */
    public PushRecalculateAndEncryptResource(String key) {
        encryptionKey = key;
    }

    /**
     * Processes a new input number, pushes the new number to the calculator, gets 
     * the new average and standard deviation, encrypts the results, and formats the 
     * output using a representation class.
     * 
     * Input format: { "number": 4 }
     * 
     * @param inputNumber new number to recalculate the average and standard deviation
     * @return object with new encrypted average and standard deviation
     * @throws WebApplicationException if an error occurs while encrypting numbers
     */
    @POST
    @Timed
    public EncryptedAvgAndDev run(@Valid MyNumber inputNumber)
            throws WebApplicationException {
            
        final Calculator cal = Calculator.getInstance();
        cal.push(inputNumber.getNumber());

        try {
            return new EncryptedAvgAndDev(
                AES.encrypt(Double.toString(cal.getMean()), encryptionKey), 
                AES.encrypt(Double.toString(cal.getStdDev()), encryptionKey)
            );
        } catch (Exception e) {
            throw new WebApplicationException("Error encrypting results");
        }
    }
}
