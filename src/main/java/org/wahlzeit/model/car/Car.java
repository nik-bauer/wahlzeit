package org.wahlzeit.model.car;


import com.googlecode.objectify.annotation.Entity;
import org.wahlzeit.model.CarManufacturer;
import org.wahlzeit.services.DataObject;

import static org.wahlzeit.utils.CustomAssert.assertNotNull;

@Entity
public class Car extends DataObject {

    private CarType carType;
    private CarManufacturer manufacturer;
    private String modelName;
    private int productionYear;
    private int numDoors;
    private int numSeats;
    private int engineHP;


    /**
     * @methodtype constructor
     */
    public Car(String modelName, CarType carType, CarManufacturer manufacturer) {
        assertHasMinimumParameters(modelName, carType, manufacturer);

        this.modelName = modelName;
        this.carType = carType;
        this.manufacturer = manufacturer;
    }

    /**
     * @methodtype constructor
     */
    public Car(String modelName, CarType carType, CarManufacturer manufacturer, int productionYear, int numDoors, int numSeats, int engineHP) {
        assertHasMinimumParameters(modelName, carType, manufacturer);

        this.modelName = modelName;
        this.carType = carType;
        this.manufacturer = manufacturer;
        this.productionYear = productionYear;
        this.numDoors = numDoors;
        this.numSeats = numSeats;
        this.engineHP = engineHP;
    }

    /**
     *
     * @methodtype set
     * @param modelName
     */
    public void setModelName(String modelName) {
        assertNotNull(modelName);
        this.modelName = modelName;
    }

    /**
     *
     * @methodtype get
     * @return Model name of the car.
     */
    public String getModelName() {
        return this.modelName;
    }

    /**
     *
     * @methodtype get
     * @return CarType of the car.
     */
    public CarType getCarType() {
        return this.carType;
    }

    /**
     *
     * @methodtype set
     * @param manufacturer
     */
    public void setManufacturer(CarManufacturer manufacturer) {
        assertNotNull(manufacturer);
        this.manufacturer = manufacturer;
    }

    /**
     *
     * @methodtype get
     * @return Manufacturer of the car.
     */
    public CarManufacturer getManufacturer() {
        return this.manufacturer;
    }

    /**
     *
     * @methodtype set
     * @param productionYear
     */
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    /**
     *
     * @methodtype
     * @return Production year of the car.
     */
    public int getProductionYear() {
        return this.productionYear;
    }

    /**
     * @methodtype set
     * @param numDoors
     */
    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    /**
     * @methodtype get
     * @return Number of the car's doors.
     */
    public int getNumDoors() {
        return this.numDoors;
    }

    /**
     * @methodtype set
     * @param numSeats
     */
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    /**
     * @methodtype get
     * @return Number of the car's seats.
     */
    public int getNumSeats() {
        return this.numSeats;
    }

    /**
     * @methodtype set
     * @param engineHP
     */
    public void setEngineHP(int engineHP) {
        this.engineHP = engineHP;
    }

    /**
     * @methodtype get
     * @return Total horsepower of the car's engine.
     */
    public int getEngineHP() {
        return this.engineHP;
    }

    protected void assertHasMinimumParameters(String modelName, CarType carType, CarManufacturer manufacturer) {
        assertNotNull(modelName);
        assertNotNull(carType);
        assertNotNull(manufacturer);
    }
}
