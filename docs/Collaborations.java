/**
 * Collaboration between Car and CarPhoto
 */
public collaboration Car_CarPhoto {

    public role CarPhoto {
        /**
         * @methodtype getter
         * returns the corresponding Car object
         */
        public Car getCar();

        /**
         * @methodtype setter
         * sets the corresponding Car object
         */
        public void setCar(Car car);
    }

    public role Car {
        // no relevant methods for this collaboration
    }
}

/**
 * Collaboration between Car and CarType
 */
public collaboration Car_CarType {

    public role CarType {
        /**
         * @methodtype factory
         * creates a new Car object
         */
        public Car createCar(String modelName);
    }

    public role Car {
        /**
         * @methodtype getter
         * returns the corresponding CarType
         */
        public CarType getCarType();
    }
}

/**
 * Collaboration between Car and CarManager
 */
public collaboration Car_CarManager {
    public role CarManager {
        /**
         * @methodtype factory
         * creates a new Car object
         */
        public Car createCar(String type, String modelName, CarManufacturer manufacturer);

        /**
         * @methodtype getter
         * returns all corresponding Car objects
         */
        public Set<Car> getAllCars();
    }

    public role Car {
        // no relevant methods for this collaboration
    }
}


public class CarPhoto extends Photo binds Car_CarType.CarPhoto {
        // ...
}

public class Car extends DataObject binds Car_CarPhoto.Car, Car_CarType.Car, Car_CarManager.Car {
        // ...
}

public class CarType extends DataObject binds Car_CarType.CarType {
        // ...
}

public class CarManager extends ObjectManager binds ? {
        // ...
}
