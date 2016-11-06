package org.wahlzeit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.*;
import org.wahlzeit.services.mailing.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        EmailAddressTest.class,
        LogBuilderTest.class,
        EmailServiceTest.class
})
public class ServicesTestSuite {
}
