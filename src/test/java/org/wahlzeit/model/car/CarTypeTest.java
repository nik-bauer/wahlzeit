package org.wahlzeit.model.car;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ranges.Range;
import org.wahlzeit.model.car.CarType;

import static org.junit.Assert.*;


public class CarTypeTest {

    private CarType sportsCar;
    private CarType superSportsCar;
    private CarType racingCar;

    @Before
    public void setUp() {
        sportsCar = new CarType("SportsCar");
        superSportsCar = new CarType("SuperSportsCar");
        racingCar = new CarType("RacingCar");
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