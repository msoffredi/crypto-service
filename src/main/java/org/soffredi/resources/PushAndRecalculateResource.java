package org.soffredi.resources;

// import javax.ws.rs.Consumes;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import org.soffredi.api.AvgAndDev;
import org.soffredi.core.InputNumber;

@Path("/push-and-recalculate")
@Produces(MediaType.APPLICATION_JSON)
public class PushAndRecalculateResource {

    @POST
    @Timed
    // @Consumes(MediaType.APPLICATION_JSON)
    public AvgAndDev pushAndRecalculate(@Valid InputNumber inputNumber) {
        return new AvgAndDev(inputNumber.getNumber(), 0);
    }
}
