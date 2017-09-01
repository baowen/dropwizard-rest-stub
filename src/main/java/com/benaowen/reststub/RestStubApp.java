package com.benaowen.reststub;

import com.benaowen.reststub.resources.PersonService;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Environment;
import io.dropwizard.setup.Bootstrap;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Created by benowen on 29/08/2017.
 */
public class RestStubApp extends Application<RestStubConfig> {

    public static void main(String[] args) throws Exception {
        new RestStubApp().run(args);
    }
    @Override
    public void initialize(Bootstrap<RestStubConfig> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
                bootstrap.getConfigurationSourceProvider(),
                new EnvironmentVariableSubstitutor(false)));

        bootstrap.addBundle(new SwaggerBundle<RestStubConfig>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(RestStubConfig configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(RestStubConfig config, Environment env) {
        final PersonService personService = new PersonService();
        env.jersey().register(personService);

        env.healthChecks().register("template",
                new RestStubCheck(config.getVersion()));


    }

}