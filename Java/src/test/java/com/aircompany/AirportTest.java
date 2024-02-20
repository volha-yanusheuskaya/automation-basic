package com.aircompany;

import com.aircompany.bo.Airport;

import com.aircompany.planes.Plane;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static com.aircompany.test_data.AirportPlanes.PLANES;
import static org.testng.Assert.*;

public class AirportTest {

    private final Airport airport = new Airport(PLANES);
    @Test
    public void hasTransportInMilitaryPlanes() {
        assertFalse(airport.getTransportMilitaryPlanes().isEmpty());
    }

    @Test
    public void checkPassengerPlaneWithMaxCapacity() {
        assertEquals(airport.getPassengerPlaneWithMaxPassengersCapacity(), PLANES.get(2));
    }

    @Test
    public void checkSortedPlanesWithMaxLoadCapacity() {
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getPlanes();
        PLANES.sort(Comparator.comparing(Plane::getMaxLoadCapacity));
        assertEquals(planesSortedByMaxLoadCapacity, PLANES);
    }

    @Test
    public void hasBomberInMilitaryPlanes() {
        assertFalse(airport.getBomberMilitaryPlanes().isEmpty());
    }

    @Test
    public void hasNotUnclassifiedInExperimentalPlanes() {
        assertFalse(airport.getNotUnclassifiedExperimentalPlanes().isEmpty());
    }
}
