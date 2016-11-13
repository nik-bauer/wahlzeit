package org.wahlzeit.model;


import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class CarPhotoManager extends PhotoManager {

    /**
     *
     */
    protected static final CarPhotoManager instance = new CarPhotoManager();

    private static final Logger log = Logger.getLogger(CarPhotoManager.class.getName());

    public CarPhotoManager() {
        super();
    }

    /**
     *
     * @param classification
     * @return Photos with the given classification.
     */
    public Set<CarPhoto> findByClassification(CarClassification classification) {
        Set<CarPhoto> result = new HashSet<>();

        readObjects(result, CarPhoto.class, CarPhoto.CLASSIFICATION, classification);

        for (CarPhoto carPhoto : result) {
            doAddPhoto(carPhoto);
        }

        return result;
    }

    /**
     *
     * @param manufacturer
     * @return Photos from the given manufacturer.
     */
    public Set<CarPhoto> findByManufacturer(CarManufacturer manufacturer) {
        Set<CarPhoto> result = new HashSet<>();

        readObjects(result, CarPhoto.class, CarPhoto.MANUFACTURER, manufacturer);

        for (CarPhoto carPhoto : result) {
            doAddPhoto(carPhoto);
        }

        return result;
    }
}
