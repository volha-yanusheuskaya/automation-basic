package com.aircompany.bo;

import com.aircompany.models.ClassificationLevel;
import com.aircompany.planes.ExperimentalPlane;
import com.aircompany.models.MilitaryType;
import com.aircompany.planes.MilitaryPlane;
import com.aircompany.planes.PassengerPlane;
import com.aircompany.planes.Plane;

import java.util.*;

public class Airport {
    private final List<? extends Plane> planes;

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getMilitaryType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getMilitaryType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public List<ExperimentalPlane> getNotUnclassifiedExperimentalPlanes() {
        List<ExperimentalPlane> notUnclassifiedExperimentalPlanes = new ArrayList<>();
        List<ExperimentalPlane> experimentalPlanes = getExperimentalPlanes();
        for (ExperimentalPlane plane : experimentalPlanes) {
            if (plane.getClassificationLevel() != ClassificationLevel.UNCLASSIFIED) {
                notUnclassifiedExperimentalPlanes.add(plane);
            }
        }
        return notUnclassifiedExperimentalPlanes;
    }

    public Airport sortByMaxFlightDistance() {
        planes.sort((Comparator<Plane>) (o1, o2) -> o2.getMaxFlightDistance() - o1.getMaxFlightDistance());
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort((Comparator<Plane>) (o1, o2) -> o2.getMaxSpeed() - o1.getMaxSpeed());
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort((Comparator<Plane>) (o1, o2) -> o2.getMaxLoadCapacity() - o1.getMaxLoadCapacity());
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                "}\n";
    }

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
