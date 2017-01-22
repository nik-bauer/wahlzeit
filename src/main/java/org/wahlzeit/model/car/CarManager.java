package org.wahlzeit.model.car;


import org.wahlzeit.model.CarManufacturer;
import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.utils.DesignPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

@DesignPattern(
        name = "Singleton",
        participants = {"Singleton"}
)
public class CarManager extends ObjectManager {

    public static final CarManager INSTANCE = new CarManager();

    private static final Logger log = Logger.getLogger(CarManager.class.getName());

    private Set<Car> cars = new HashSet<>();
    private Map<String, CarType> carTypes = new HashMap<>();

    private CarManager() {
        // Singleton
    }

    public static CarManager getInstance() {
        return INSTANCE;
    }


    // Car creation step #2:
    public synchronized CarType getType(String name, CarManufacturer manufacturer) {
        if (carTypes.containsKey(name)) {
            return carTypes.get(name);
        } else {
            CarType newType = new CarType(name, manufacturer);
            carTypes.put(name, newType);
            return newType;
        }
    }

    // Car creation step #1:
    public Car createCar(String type, String modelName, CarManufacturer manufacturer) {
        Car car = getType(type, manufacturer).createCar(modelName);
        cars.add(car);
        return car;
    }

    public Set<Car> getAllCars() {
        return new HashSet<>(cars);
    }

    public Set<CarType> getAllTypes() {
        return new HashSet<>(carTypes.values());
    }

    protected void addCarType(CarType carType) {
        if(!carTypes.containsKey(carType.getName())) {
            carTypes.put(carType.getName(), carType);
        }
    }

    public void saveObjects() {
        for (Car car : cars) {
            super.writeObject(car);
        }

        for (CarType carType: carTypes.values()) {
            super.writeObject(carType);
        }
    }

    public void deleteObject(CarType carType) {
        super.deleteObject(carType);
    }
}
