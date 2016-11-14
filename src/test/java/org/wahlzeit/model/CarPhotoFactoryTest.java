package org.wahlzeit.model;


import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class CarPhotoFactoryTest {

    private CarPhotoFactory carPhotoFactory;
    private CarPhoto quattroporte;

    @ClassRule
    public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());

    @Before
    public void setUp() {
        carPhotoFactory = CarPhotoFactory.getInstance();
        quattroporte = carPhotoFactory.createPhoto(new PhotoId(1), CarManufacturer.MASERATI, CarClassification.GRAND_TOURER, "Quattroporte", 2013, 5, 5, 530);
    }

    @Test
    public void initTest() {
        Assert.assertNotNull(carPhotoFactory);
    }

    @Test
    public void photoCreationTest() {
        Assert.assertEquals(CarPhoto.class, carPhotoFactory.createPhoto().getClass());
        Assert.assertEquals(CarPhoto.class, carPhotoFactory.createPhoto(new PhotoId(1)).getClass());
        Assert.assertEquals(CarPhoto.class, quattroporte.getClass());
    }

    @Test
    public void fieldsTest() {
        Assert.assertEquals(quattroporte.getManufacturer(), CarManufacturer.MASERATI);
        Assert.assertEquals(quattroporte.getClassification(), CarClassification.GRAND_TOURER);
        Assert.assertEquals(quattroporte.getModelName(), "Quattroporte");
        Assert.assertEquals(quattroporte.getProductionYear(), 2013);
        Assert.assertEquals(quattroporte.getNumDoors(), 5);
        Assert.assertEquals(quattroporte.getNumSeats(), 5);
        Assert.assertEquals(quattroporte.getEngineHP(), 530);
    }
}
