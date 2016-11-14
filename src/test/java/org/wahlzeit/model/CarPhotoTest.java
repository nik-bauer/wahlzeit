package org.wahlzeit.model;


import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class CarPhotoTest {

    @ClassRule
    public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());

    private CarPhoto carPhoto;

    @Before
    public void setUp() {
        carPhoto = new CarPhoto();
    }

    @Test
    public void manufacturerTest() {
        carPhoto.setManufacturer(CarManufacturer.ASTON_MARTIN);
        Assert.assertEquals(carPhoto.getManufacturer(), CarManufacturer.ASTON_MARTIN);
    }

    @Test
    public void classificationTest() {
        carPhoto.setClassification(CarClassification.CONVERTIBLE);
        Assert.assertEquals(carPhoto.getClassification(), CarClassification.CONVERTIBLE);
    }

    @Test
    public void modelNameTest() {
        carPhoto.setModelName("foo");
        Assert.assertEquals(carPhoto.getModelName(), "foo");
    }

    @Test
    public void productionYearTest() {
        carPhoto.setProductionYear(123);
        Assert.assertEquals(carPhoto.getProductionYear(), 123);
    }

    @Test
    public void numDoorsTest() {
        carPhoto.setNumDoors(123);
        Assert.assertEquals(carPhoto.getNumDoors(), 123);
    }

    @Test
    public void numSeatsTest() {
        carPhoto.setNumSeats(123);
        Assert.assertEquals(carPhoto.getNumSeats(), 123);
    }

    @Test
    public void engineHPTest() {
        carPhoto.setEngineHP(123);
        Assert.assertEquals(carPhoto.getEngineHP(), 123);
    }
}
