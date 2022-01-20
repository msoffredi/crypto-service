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

@Path("/decrypt")
@Produces(MediaType.APPLICATION_JSON)
public class DecryptResource {
    private final String encryptionKey;

    public DecryptResource(String key) {
        encryptionKey = key;
    }

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
