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

/**
 * Defines the resource class for the /push-and-recalculate POST endpoint
 */
@Path("/push-and-recalculate")
@Produces(MediaType.APPLICATION_JSON)
public class PushAndRecalculateResource {

    /**
     * Processes a new input number, pushes the new number to the calculator, gets 
     * the new average and standard deviation, and formats the output using a 
     * representation class.
     * 
     * Input format: { "number": 4 }
     * 
     * @param inputNumber new number to recalculate the average and standard deviation
     * @return object with new average and standard deviation
     */
    @POST
    @Timed
    public AvgAndDev run(@Valid MyNumber inputNumber) {
        final Calculator cal = Calculator.getInstance();
        cal.push(inputNumber.getNumber());
        return new AvgAndDev(cal.getMean(), cal.getStdDev());
    }
}
