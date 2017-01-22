package org.wahlzeit.model.car;


import org.junit.*;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class CarManagerTest {

    private CarManager carManager;

    @ClassRule
    public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());


    @Before
    public void setUp() {
        carManager = CarManager.getInstance();
    }

    @Test
    public void initTest() {
        Assert.assertNotNull(carManager);
    }

    @Test
    public void classTest() {
        Assert.assertTrue(carManager instanceof CarManager);
    }

    @Test
    public void createCarTest() {
        Car audiA3 = carManager.createCar("FullsizeCar", "AudiA3",CarManufacturer.AUDI);
        Car audiA1 = carManager.createCar("CompactCar", "AudiA1", CarManufacturer.AUDI);
        Car vwPassat = carManager.createCar("FullsizeCar", "VWPassat", CarManufacturer.VOLKSWAGEN);

        Assert.assertTrue(audiA3 instanceof Car);
        Assert.assertTrue(carManager.getAllCars().size() == 3);
        Assert.assertTrue(carManager.getAllTypes().size() == 3);
    }
}
