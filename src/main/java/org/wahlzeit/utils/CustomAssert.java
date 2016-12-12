package org.wahlzeit.utils;


public class CustomAssert {

    /**
     * @methodtype assert
     */
    public static void assertNotNull(Object object) {
        if(object == null) {
            throw new IllegalArgumentException("Given argument " + object.getClass().getSimpleName() + " must not be null!");
        }
    }

    /**
     * @methodtype assert
     */
    public static void assertIsValidDouble(double value, String fieldName) {
        if(Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Given value " + fieldName + " must be a valid double!");
        }
    }
}
