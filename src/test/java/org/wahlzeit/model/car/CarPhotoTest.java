package org.wahlzeit.model.car;


import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.model.CarManufacturer;
import org.wahlzeit.model.car.Car;
import org.wahlzeit.model.car.CarPhoto;
import org.wahlzeit.model.car.CarType;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class CarPhotoTest {

    @ClassRule
    public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());

    private CarPhoto carPhoto;
    private Car audi_fullsize;

    @Before
    public void setUp() {
        carPhoto = new CarPhoto();
        audi_fullsize = new Car("AudiFullsize", new CarType("FullsizeCar", CarManufacturer.AUDI));
    }

    @Test
    public void setterGetterTest() {
        carPhoto.setCar(audi_fullsize);
        Assert.assertEquals(carPhoto.getCar(), audi_fullsize);
    }
}
