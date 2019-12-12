package com.airhacks;

import java.security.Principal;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;

@PermitAll
@Path("/hello")
public class HelloResource {

    @Inject
    JsonWebToken token;

    @Inject
    Principal prince;

    @GET
    @RolesAllowed("pilot")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello " + token.getGroups() + " and the price is: " + this.prince.getName();
    }
}