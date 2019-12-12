package com.airhacks;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.vertx.axle.sqlclient.Row;
import io.vertx.axle.sqlclient.RowSet;

@Path("/hello")
public class HelloResource {

    @Inject
    Workshops workshops;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> hello() {
        CompletionStage<RowSet<Row>> stage = workshops.queryWorkshops();
        return stage.thenApply(this::convert);
    }

    String convert(RowSet<Row> data) {
        String result = "-";
        for (Row row : data) {
            result += row.getValue(0);
        }
        return result;
    }
}