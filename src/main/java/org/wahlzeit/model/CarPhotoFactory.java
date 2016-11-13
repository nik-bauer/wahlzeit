package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;


public class CarPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(CarPhotoFactory.class.getName());
    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static PhotoFactory instance = null;

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
    public static synchronized PhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting CarPhotoFactory").toString());
            setInstance(new CarPhotoFactory());
        }

        return instance;
    }

    /**
     * Method to set the singleton instance of PhotoFactory.
     */
    protected static synchronized void setInstance(PhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initialize PhotoFactory twice");
        }

        instance = photoFactory;
    }

    /**
     * @methodtype factory
     */
    public Photo createPhoto() {
        return new CarPhoto();
    }

    /**
     * @methodtype factory
     * Creates a new photo with the specified id
     */
    public Photo createPhoto(PhotoId id) {
        return new Photo(id);
    }

    /**
     * @methodtype factory
     * Creates a new photo with the specified id and additional fields
     */
    public Photo createPhoto(PhotoId id, CarManufacturer manufacturer, CarClassification classification, int numDoors, int numSeats, int engineHP, float engineDisplacementInLiters, float carLength, float carWidth) {
        return new CarPhoto(id, manufacturer, classification, numDoors, numSeats, engineHP, engineDisplacementInLiters, carLength, carWidth);
    }
}
