package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Entity;

@Entity
public class CarPhoto extends Photo {

    public static final String CLASSIFICATION = "classification";
    public static final String MANUFACTURER = "manufacturer";

    // TODO: maybe add color in case the actual car on the photo should be described instead of the car in general
    private CarManufacturer manufacturer;
    private CarClassification classification;
    private String modelName;
    private int numDoors;
    private int numSeats;
    private int engineHP;
    private float engineDisplacementInLiters;
    private float carLength;
    private float carWidth;

    /**
     * @methodtype constructor
     */
    public CarPhoto() {
        super();
    }

    /**
     * @methodtype constructor
     */
    public CarPhoto(PhotoId id) {
        super(id);
    }

    /**
     * @methodtype constructor
     */
    public CarPhoto(PhotoId id, CarManufacturer manufacturer, CarClassification classification, String modelName, int numDoors, int numSeats, int engineHP, float engineDisplacementInLiters, float carLength, float carWidth) {
        super(id);
        this.manufacturer = manufacturer;
        this.classification = classification;
        this.modelName = modelName;
        this.numDoors = numDoors;
        this.numSeats = numSeats;
        this.engineHP = engineHP;
        this.engineDisplacementInLiters = engineDisplacementInLiters;
        this.carLength = carLength;
        this.carWidth = carWidth;
    }

    /**
     *
     * @methodtype set
     * @param manufacturer
     */
    public void setManufacturer(CarManufacturer manufacturer) {
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
     * @param classification
     */
    public void setClassification(CarClassification classification) {
        this.classification = classification;
    }

    /**
     *
     * @methodtype get
     * @return Classification of the car.
     */
    public CarClassification getClassification() {
        return this.classification;
    }

    /**
     *
     * @methodtype set
     * @param modelName
     */
    public void setModelName(String modelName) {
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

    /**
     * @methodtype set
     * @param engineDisplacementInLiters
     */
    public void setEngineDisplacementInLiters(int engineDisplacementInLiters) {
        this.engineDisplacementInLiters = engineDisplacementInLiters;
    }

    /**
     * @methodtype get
     * @return Total displacement of the car'S engine.
     */
    public float getEngineDisplacementInLiters() {
        return this.engineDisplacementInLiters;
    }

    /**
     * @methodtype set
     * @param carLength
     */
    public void setCarLength(float carLength) {
        this.carLength = carLength;
    }

    /**
     * @methodtype get
     * @return Length of the car.
     */
    public float getCarLength() {
        return this.carLength;
    }

    /**
     * @methodtype set
     * @param carWidth
     */
    public void setCarWidth(float carWidth) {
        this.carWidth = carWidth;
    }

    /**
     * @methodtype get
     * @return Width of the car.
     */
    public float getCarWidth() {
        return this.carWidth;
    }
}
