package org.soffredi.resources;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import org.soffredi.api.AvgAndDev;
import org.soffredi.api.MyNumber;
import org.soffredi.core.Calculator;

@Path("/push-and-recalculate")
@Produces(MediaType.APPLICATION_JSON)
public class PushAndRecalculateResource {

    @POST
    @Timed
    public AvgAndDev run(@Valid MyNumber inputNumber) {
        final Calculator cal = Calculator.getInstance();
        cal.push(inputNumber.getNumber());
        return new AvgAndDev(cal.getMean(), cal.getStdDev());
    }
}
