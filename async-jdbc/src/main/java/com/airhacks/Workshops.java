package com.airhacks;

import java.util.concurrent.CompletionStage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.vertx.axle.pgclient.PgPool;
import io.vertx.axle.sqlclient.Row;
import io.vertx.axle.sqlclient.RowSet;

@RequestScoped
public class Workshops {

    @Inject
    PgPool client;

    public CompletionStage<RowSet<Row>> queryWorkshops() {
        return client.query("select * from workshop").th;
    }




    
}