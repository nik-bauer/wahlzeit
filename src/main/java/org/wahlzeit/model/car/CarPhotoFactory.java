package org.wahlzeit.model.car;

import org.wahlzeit.model.CarManufacturer;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.DesignPattern;

import java.util.logging.Logger;

import static org.wahlzeit.utils.CustomAssert.assertNotNull;

@DesignPattern(
        name = "AbstractFactory",
        participants = {"AbstractFactory", "ConcreteFactory"}
)
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
        assertNotNull(id);
        return new CarPhoto(id);
    }

    /**
     * @methodtype factory
     * Creates a new photo with the specified id and additional fields
     */
    public CarPhoto createPhoto(PhotoId id, Car car) {
        assertNotNull(id);
        assertNotNull(car);
        return new CarPhoto(id, car);
    }
}
