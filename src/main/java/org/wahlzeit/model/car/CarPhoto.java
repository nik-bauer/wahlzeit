package org.wahlzeit.model.car;


import com.googlecode.objectify.annotation.Subclass;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.car.Car;

import static org.wahlzeit.utils.CustomAssert.assertNotNull;

@Subclass
public class CarPhoto extends Photo {

    public static final String CLASSIFICATION = "classification";
    public static final String MANUFACTURER = "manufacturer";

    private Car car;

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
     * @methodtype setter
     * @param car
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * @methodtype getter
     * @return
     */
    public Car getCar() {
        return car;
    }
}
