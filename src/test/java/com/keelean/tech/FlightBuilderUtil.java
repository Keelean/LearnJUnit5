package com.keelean.tech;

import com.keelean.com.Flight;
import com.keelean.com.Passenger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FlightBuilderUtil {

    public static Flight buildFlightFromCsv() throws IOException {
        Flight flight = new Flight("AA123A", 20);
        try(BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/flights_information.csv"))){
            String line = null;
            do {
                line = reader.readLine();
                if(line != null){
                    String[] passengerString = line.toString().split(";");
                    Passenger passenger = new Passenger(passengerString[0].trim(), passengerString[1].trim());
                    flight.addPassenger(passenger);
                }
            }while (line != null);
        }
        return flight;
    }
}
