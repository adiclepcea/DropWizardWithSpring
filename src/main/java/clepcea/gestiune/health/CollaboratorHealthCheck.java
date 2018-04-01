package clepcea.gestiune.health;

import com.codahale.metrics.health.HealthCheck;

public class CollaboratorHealthCheck extends HealthCheck {

    protected Result check() throws Exception{
        return Result.healthy();
    }
}
