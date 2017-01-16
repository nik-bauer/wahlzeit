package org.wahlzeit.model.car;

import com.googlecode.objectify.annotation.Entity;
import org.wahlzeit.model.CarManufacturer;
import org.wahlzeit.services.DataObject;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CarType extends DataObject {

    protected CarType parentType = null;
    protected Set<CarType> subTypes = new HashSet<>();
    private final String name;


    public CarType(String name) {
        this.name = name;
    }

    protected Car createCar(String modelName, CarManufacturer manufacturer) {
        return new Car(modelName, this, manufacturer);
    }

    /**
     * @methodtype setter
     * @param subTypes
     */
    public void setSubTypes(Set<CarType> subTypes) {
        this.subTypes = subTypes;
    }

    /**
     * @methodtype getter
     * @return
     */
    public Set<CarType> getSubTypes() {
        return subTypes;
    }

    /**
     * @methodtype getter
     * @return
     */
    public String getName() {
        return name;
    }

    protected void addSubType(CarType subType) {
        if(subType.getParentType() != null) {
            throw new IllegalStateException(subType.name + "cannot have more than one parent type!");
        }
        subType.setParentType(this);
        this.subTypes.add(subType);
    }

    public boolean isSubTypeOf(CarType other) {
        if(other == null) {
            return false;
        }

        for (CarType carType : other.getSubTypes()) {
            if(carType.equals(this)) {
                return true;
            }
        }
        return false;

    }
    /**
     * @methodtype setter
     * @param parentType
     */
    public void setParentType(CarType parentType) {
        this.parentType = parentType;
    }

    /**
     * @methodtype getter
     * @return
     */
    public CarType getParentType() {
        return this.parentType;
    }

}
