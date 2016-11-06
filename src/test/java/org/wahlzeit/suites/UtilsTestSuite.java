package org.wahlzeit.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.utils.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        StringUtilTest.class,
        VersionTest.class
})

public class UtilsTestSuite {
}
