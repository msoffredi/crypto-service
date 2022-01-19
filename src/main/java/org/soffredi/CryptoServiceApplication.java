package org.soffredi;

import org.soffredi.health.DefaultHealthCheck;
import org.soffredi.resources.PushAndRecalculateResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CryptoServiceApplication extends Application<CryptoServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new CryptoServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "crypto-service";
    }

    @Override
    public void initialize(final Bootstrap<CryptoServiceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final CryptoServiceConfiguration configuration,
                    final Environment environment) {
        final PushAndRecalculateResource pushAndRecalculateResource = 
                new PushAndRecalculateResource();
        final DefaultHealthCheck defaultHealthCheck = new DefaultHealthCheck();
            
        environment.healthChecks().register("default", defaultHealthCheck);
        environment.jersey().register(pushAndRecalculateResource);
    }
}
