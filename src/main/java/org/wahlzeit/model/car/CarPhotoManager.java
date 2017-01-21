package org.wahlzeit.model.car;


import org.wahlzeit.model.PhotoManager;

public class CarPhotoManager extends PhotoManager {

    static {
        instance = new CarPhotoManager();
    }

    /**
     * Public singleton access method
     */
    public static synchronized CarPhotoManager getInstance() {
        return (CarPhotoManager)instance;
    }
}
