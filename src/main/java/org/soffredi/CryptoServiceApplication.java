package org.soffredi;

import org.soffredi.health.DefaultHealthCheck;
import org.soffredi.resources.DecryptResource;
import org.soffredi.resources.PushAndRecalculateResource;
import org.soffredi.resources.PushRecalculateAndEncryptResource;

import io.dropwizard.Application;
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
    public void run(final CryptoServiceConfiguration configuration,
                    final Environment environment) {
        final PushAndRecalculateResource pushAndRecalculateResource = 
                new PushAndRecalculateResource();
        final PushRecalculateAndEncryptResource pushRecalculateAndEncryptResource =
                new PushRecalculateAndEncryptResource(configuration.getEncryptionKey());
        final DecryptResource decryptResource = 
                new DecryptResource(configuration.getEncryptionKey());
        final DefaultHealthCheck defaultHealthCheck = new DefaultHealthCheck();
            
        environment.healthChecks().register("default", defaultHealthCheck);
        environment.jersey().register(pushAndRecalculateResource);
        environment.jersey().register(pushRecalculateAndEncryptResource);
        environment.jersey().register(decryptResource);
    }
}
