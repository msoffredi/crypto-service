package org.soffredi.resources;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import org.soffredi.api.DecryptedNumber;
import org.soffredi.core.AES;
import org.soffredi.core.InputEncryptedNumber;

@Path("/decrypt")
@Produces(MediaType.APPLICATION_JSON)
public class DecryptResource {

    @POST
    @Timed
    public DecryptedNumber run(@Valid InputEncryptedNumber inputEncryptedNumber)
            throws WebApplicationException {
            
        try {
            final String strNum = AES.decrypt(
                inputEncryptedNumber.getEncryptedNumber(), 
                "abc123"
            );
            return new DecryptedNumber(Double.parseDouble(strNum));
        } catch (Exception e) {
            throw new WebApplicationException("Error decrypting number");
        }
    }
}
