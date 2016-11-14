package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;


public class CarPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(CarPhotoFactory.class.getName());
    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static CarPhotoFactory instance = null;

    /**
     *
     */
    protected CarPhotoFactory() {
        // do nothing
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize() {
        getInstance(); // drops result due to getInstance() side-effects
    }

    /**
     * Public singleton access method.
     */
    public static synchronized CarPhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting CarPhotoFactory").toString());
            setInstance(new CarPhotoFactory());
        }

        return instance;
    }

    /**
     * Method to set the singleton instance of PhotoFactory.
     */
    protected static synchronized void setInstance(CarPhotoFactory carPhotoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initialize PhotoFactory twice");
        }

        instance = carPhotoFactory;
    }

    /**
     * @methodtype factory
     */
    public CarPhoto createPhoto() {
        return new CarPhoto();
    }

    /**
     * @methodtype factory
     * Creates a new photo with the specified id
     */
    public CarPhoto createPhoto(PhotoId id) {
        return new CarPhoto(id);
    }

    /**
     * @methodtype factory
     * Creates a new photo with the specified id and additional fields
     */
    public CarPhoto createPhoto(PhotoId id, CarManufacturer manufacturer, CarClassification classification, String modelName, int productionYear, int numDoors, int numSeats, int engineHP) {
        return new CarPhoto(id, manufacturer, classification, modelName, productionYear, numDoors, numSeats, engineHP);
    }
}
