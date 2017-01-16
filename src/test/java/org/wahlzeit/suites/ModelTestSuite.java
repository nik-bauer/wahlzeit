package org.wahlzeit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.*;
import org.wahlzeit.model.car.CarManagerTest;
import org.wahlzeit.model.car.CarPhotoFactoryTest;
import org.wahlzeit.model.car.CarPhotoTest;
import org.wahlzeit.model.car.CarTypeTest;
import org.wahlzeit.model.persistence.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
		AbstractCoordinateTest.class,
        AccessRightsTest.class,
        CarPhotoFactoryTest.class,
        CarManagerTest.class,
        CarPhotoTest.class,
		CarTypeTest.class,
        CartesianCoordinateTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        LocationTest.class,
        PhotoFilterTest.class,
		SphericCoordinateTest.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class,
        AbstractAdapterTest.class,
        DatastoreAdapterTest.class,
        GcsAdapterTest.class
})

public class ModelTestSuite {
}
