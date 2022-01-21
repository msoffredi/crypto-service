package org.soffredi.resources;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import org.soffredi.api.EncryptedNumber;
import org.soffredi.api.MyNumber;
import org.soffredi.core.AES;

/**
 * Defines the resource class for the /decrypt POST endpoint
 */
@Path("/decrypt")
@Produces(MediaType.APPLICATION_JSON)
public class DecryptResource {
    final private String encryptionKey;

    /**
     * Constructor
     * 
     * @param key decryption key
     */
    public DecryptResource(String key) {
        encryptionKey = key;
    }

    /**
     * Processes a new input encrypted number, decrypts the number, and formats the
     * output using a representation class.
     * 
     * Input format: { "encryptedNumber": "W7+AeY5oqQgkfMYYPw6/FQ==" }
     * 
     * @param inputEncryptedNumber POST input as a JSON object with an encrypted number
     * @return a MyNumber object
     * @throws WebApplicationException if an error occurs while decrypting the input string
     */
    @POST
    @Timed
    public MyNumber run(@Valid EncryptedNumber inputEncryptedNumber)
            throws WebApplicationException {
            
        try {
            final String strNum = AES.decrypt(
                inputEncryptedNumber.getEncryptedNumber(), 
                encryptionKey
            );
            return new MyNumber(Double.parseDouble(strNum));
        } catch (Exception e) {
            throw new WebApplicationException("Error decrypting number");
        }
    }
}
