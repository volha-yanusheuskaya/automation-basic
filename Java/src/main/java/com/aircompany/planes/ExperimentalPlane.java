package com.aircompany.planes;

import com.aircompany.models.ClassificationLevel;
import com.aircompany.models.ExperimentalType;

public class ExperimentalPlane extends Plane {

    private final ExperimentalType experimentalType;
    private final ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType experimentalType, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalType getExperimentalType() {
        return experimentalType;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + "experimentalPlane {" +
                "experimentalType='" + getExperimentalType() + '\'' +
                ", classificationLevel='" + getClassificationLevel() +
                '}';
    }
}
