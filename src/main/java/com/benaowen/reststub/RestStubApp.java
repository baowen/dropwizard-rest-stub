package com.benaowen.reststub;

import com.benaowen.reststub.resources.PersonService;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Environment;
import io.dropwizard.setup.Bootstrap;

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
    }

    @Override
    public void run(RestStubConfig config, Environment env) {
        final PersonService personService = new PersonService();
        env.jersey().register(personService);

        env.healthChecks().register("template",
                new RestStubCheck(config.getVersion()));
    }
}