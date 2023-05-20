package com.keelean.tech;

import com.keelean.com.Flight;

import javax.enterprise.inject.Produces;
import java.io.IOException;

public class FlightProducer {

    @Produces
    public Flight createFlight() throws IOException {
        return FlightBuilderUtil.buildFlightFromCsv();
    }
}
