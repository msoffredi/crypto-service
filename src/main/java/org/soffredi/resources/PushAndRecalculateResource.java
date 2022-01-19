package org.soffredi.resources;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import org.soffredi.api.AvgAndDev;
import org.soffredi.core.Calculator;
import org.soffredi.core.InputNumber;

@Path("/push-and-recalculate")
@Produces(MediaType.APPLICATION_JSON)
public class PushAndRecalculateResource {

    @POST
    @Timed
    public AvgAndDev pushAndRecalculate(@Valid InputNumber inputNumber) {
        final Calculator cal = Calculator.getInstance();
        cal.push(inputNumber.getNumber());

        // return new AvgAndDev(cal.getAvg(), cal.getStdDev());
        return new AvgAndDev(cal.getMean(), cal.getStdDev());
    }
}
