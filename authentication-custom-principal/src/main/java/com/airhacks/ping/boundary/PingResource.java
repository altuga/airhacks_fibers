package com.airhacks.ping.boundary;

import com.airhacks.authentication.entity.AirhacksPrincipal;

import java.security.Principal;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.security.enterprise.SecurityContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

    @Inject
    SecurityContext securityContext;

    @Inject
    Principal prince;

    @GET
    public Response ping() {
        System.out.println("Injected principal: " + this.prince);
        AirhacksPrincipal airhacksPrincipal = (AirhacksPrincipal) securityContext.getCallerPrincipal();
        String userName = airhacksPrincipal.getName();
        boolean alumni = airhacksPrincipal.isAlumni();
            JsonObject result = Json.createObjectBuilder()
                    .add("user", userName)
                    .add("alumni?", alumni)
                    .build();
            return Response.ok(result).build();
        }

}
