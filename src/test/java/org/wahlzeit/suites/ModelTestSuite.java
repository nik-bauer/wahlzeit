package org.wahlzeit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.*;
import org.wahlzeit.model.persistence.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        AccessRightsTest.class,
        CarPhotoFactoryTest.class,
        CarPhotoManagerTest.class,
        CarPhotoTest.class,
        CartesianCoordinate.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        LocationTest.class,
        PhotoFilterTest.class,
		SphericCoordinate.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class,
        AbstractAdapterTest.class,
        DatastoreAdapterTest.class,
        GcsAdapterTest.class
})

public class ModelTestSuite {
}
