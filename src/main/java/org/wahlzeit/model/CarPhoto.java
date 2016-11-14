package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class CarPhoto extends Photo {

    public static final String CLASSIFICATION = "classification";
    public static final String MANUFACTURER = "manufacturer";

    // TODO: maybe add color in case the actual car on the photo should be described instead of the car in general
    private CarManufacturer manufacturer;
    private CarClassification classification;
    private String modelName;
    private int productionYear;
    private int numDoors;
    private int numSeats;
    private int engineHP;


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
    public CarPhoto(PhotoId id, CarManufacturer manufacturer, CarClassification classification, String modelName, int productionYear, int numDoors, int numSeats, int engineHP) {
        super(id);
        this.manufacturer = manufacturer;
        this.classification = classification;
        this.modelName = modelName;
        this.productionYear = productionYear;
        this.numDoors = numDoors;
        this.numSeats = numSeats;
        this.engineHP = engineHP;
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
}
