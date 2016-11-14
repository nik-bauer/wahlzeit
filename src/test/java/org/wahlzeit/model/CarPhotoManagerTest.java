package org.wahlzeit.model;


import com.googlecode.objectify.ObjectifyService;
import org.junit.*;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.services.OfyService;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

import java.util.HashSet;
import java.util.Set;

public class CarPhotoManagerTest {

    private CarPhotoManager carPhotoManager;
    private CarPhoto audi_compact;
    private CarPhoto audi_fullsize;
    private CarPhoto vw_fullsize;
    Set<CarPhoto> fullsize_set;
    Set<CarPhoto> audi_set;

    @ClassRule
    public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());


    @Before
    public void setUp() {
        carPhotoManager = CarPhotoManager.getInstance();

        audi_compact = new CarPhoto(null, CarManufacturer.AUDI, CarClassification.COMPACT_CAR, null, 0, 0, 0, 0);
        audi_fullsize = new CarPhoto(null, CarManufacturer.AUDI, CarClassification.FULLSIZE_CAR, null, 0, 0, 0, 0);
        vw_fullsize = new CarPhoto(null, CarManufacturer.VOLKSWAGEN, CarClassification.FULLSIZE_CAR, null, 0, 0, 0, 0);

        fullsize_set = new HashSet<>();
        fullsize_set.add(audi_fullsize);
        fullsize_set.add(vw_fullsize);

        audi_set = new HashSet<>();
        fullsize_set.add(audi_compact);
        fullsize_set.add(audi_fullsize);
    }

    @Test
    public void initTest() {
        Assert.assertNotNull(carPhotoManager);
    }

    @Test
    public void classTest() {
        Assert.assertEquals(CarPhotoManager.class, carPhotoManager);
    }

    // TODO: fix exception for findBy tests: java.lang.IllegalStateException: You have not started an Objectify context. You are probably missing the ObjectifyFilter.

    @Ignore
    @Test
    public void findByClassifiactionTest() {
        Set<CarPhoto> result_set = carPhotoManager.findByClassification(CarClassification.FULLSIZE_CAR);
        Assert.assertEquals(fullsize_set, result_set);
    }

    @Ignore
    @Test
    public void findByManufacturerTest() {
        Set<CarPhoto> result_set = carPhotoManager.findByManufacturer(CarManufacturer.AUDI);
        Assert.assertEquals(audi_set, result_set);
    }

}
