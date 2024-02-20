package com.aircompany.framework;

import com.aircompany.bo.Airport;

import static com.aircompany.test_data.AirportPlanes.PLANES;

public class Runner {

    public static void main(String[] args) {
        Airport airport = new Airport(PLANES);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());
        System.out.println("Military airport sorted by max distance: " + militaryAirport.sortByMaxFlightDistance());
        System.out.println("Passenger airport sorted by max speed: " + passengerAirport.sortByMaxSpeed());
        System.out.println("Plane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
