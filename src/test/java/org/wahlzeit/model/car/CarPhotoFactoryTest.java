package org.wahlzeit.model.car;


import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.model.CarManufacturer;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.car.CarPhoto;
import org.wahlzeit.model.car.CarPhotoFactory;
import org.wahlzeit.model.car.CarType;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class CarPhotoFactoryTest {

    private CarPhotoFactory carPhotoFactory;
    private Car quattroporte;
    private CarPhoto quattroportePhoto;

    @ClassRule
    public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());

    @Before
    public void setUp() {
        carPhotoFactory = CarPhotoFactory.getInstance();
        quattroporte = new Car("Quattroporte", new CarType("GrandTourer"), CarManufacturer.MASERATI);
        quattroportePhoto = carPhotoFactory.createPhoto(PhotoId.NULL_ID, quattroporte);
    }

    @Test
    public void initTest() {
        Assert.assertNotNull(carPhotoFactory);
    }

    @Test
    public void photoCreationTest() {
        Assert.assertEquals(CarPhoto.class, carPhotoFactory.createPhoto().getClass());
        Assert.assertEquals(CarPhoto.class, carPhotoFactory.createPhoto(PhotoId.NULL_ID).getClass());
        Assert.assertEquals(Car.class, quattroporte.getClass());
    }

    @Test
    public void fieldsTest() {
        Assert.assertEquals(quattroportePhoto.getId(), 0);
        Assert.assertEquals(quattroportePhoto.getCar(), quattroporte);
    }
}
