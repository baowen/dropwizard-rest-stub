package com.benaowen.reststub;

import com.benaowen.reststub.persistence.PersonDB;
import com.codahale.metrics.health.HealthCheck;

/**
 * Created by benowen on 29/08/2017.
 */
public class RestStubCheck extends HealthCheck {
    private final String version;

    public RestStubCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception {
        if (PersonDB.getCount() == 0) {
            return Result.unhealthy("No persons in DB! Version: " +
                    this.version);
        }
        return Result.healthy("OK with version: " + this.version +
                ". Persons count: " + PersonDB.getCount());
    }
}
