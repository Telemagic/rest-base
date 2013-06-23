package no.telemagic.hello;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import no.telemagic.hello.health.HelloHealthCheck;
import no.telemagic.hello.rs.HelloResource;

public class HelloService extends Service<HelloConfiguration> {
    public static void main(final String[] args) throws Exception {
        new HelloService().run(args);
    }

    @Override
    public void initialize(final Bootstrap<HelloConfiguration> bootStrap) {
        bootStrap.setName("hello-world");

    }

    @Override
    public void run(final HelloConfiguration conf, final Environment env) throws Exception {
        final String template = conf.getTemplate();
        final String defaultName = conf.getDefaultName();
        env.addResource(new HelloResource(template, defaultName));
        env.addHealthCheck(new HelloHealthCheck(template));
    }

}
