package no.telemagic.hello.health;

import com.yammer.metrics.core.HealthCheck;

public class HelloHealthCheck extends HealthCheck {
    private final String template;

    public HelloHealthCheck(final String template) {
        super(template);
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String format = String.format(template, "TEST");
        if (!format.contains("TEST")) {
            return Result.unhealthy("Template has no string substitution");
        }
        return Result.healthy();
    }

}
