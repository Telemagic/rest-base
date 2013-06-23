package no.telemagic.hello.rs;

import com.google.common.base.Optional;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import no.telemagic.hello.bean.Saying;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter = new AtomicLong();

    /**
     * @param template
     * @param defaultName
     */
    public HelloResource(final String template, final String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
    }

    @GET
    public Saying sayHello(@QueryParam("name") final Optional<String> name) {
        return new Saying(counter.getAndIncrement(), String.format(template, name.or(defaultName)));
    }


}
