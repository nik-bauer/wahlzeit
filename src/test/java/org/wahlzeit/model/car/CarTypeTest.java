package org.wahlzeit.model.car;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CarTypeTest {

    private CarType sportsCar;
    private CarType superSportsCar;
    private CarType racingCar;

    @Before
    public void setUp() {
        sportsCar = new CarType("SportsCar", CarManufacturer.JAGUAR);
        superSportsCar = new CarType("SuperSportsCar", CarManufacturer.ASTON_MARTIN);
        racingCar = new CarType("RacingCar", CarManufacturer.AUDI);
        sportsCar.addSubType(superSportsCar);
    }

    @Test
    public void getSubTypes() throws Exception {
        Assert.assertEquals(sportsCar.getSubTypes().size(), 1);
    }

    @Test
    public void addSubType() throws Exception {
        sportsCar.addSubType(racingCar);
        Assert.assertEquals(sportsCar.getSubTypes().size(), 2);
    }

    @Test
    public void isSubTypeOf() throws Exception {
        Assert.assertTrue(superSportsCar.isSubTypeOf(sportsCar));
    }

    @Test
    public void setterGetterParentType() throws Exception {
        racingCar.setParentType(superSportsCar);
        Assert.assertTrue(racingCar.getParentType().equals(superSportsCar));
    }
}