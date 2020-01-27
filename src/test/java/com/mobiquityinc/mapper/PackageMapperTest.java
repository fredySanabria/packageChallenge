package com.mobiquityinc.mapper;


import com.mobiquityinc.domain.Package;
import com.mobiquityinc.exception.APIException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PackageMapperTest {
    @Test
    public void shouldMappingString() throws APIException {
        String packageString = "(2,88.62,€98)";
        Package mappedPackage = PackageMapper.map(packageString);
        Assertions.assertNotNull(mappedPackage);
        Assertions.assertTrue(mappedPackage.getIndex().contains(2));
        Assertions.assertEquals(88.62f, mappedPackage.getWeight());
        Assertions.assertEquals(98, mappedPackage.getCost());
    }

    @Test
    public void shouldExceptionThrownWhenMoneyFormatIsWrong() throws APIException{

        String packageString = "(2,88.62,%98)";
        APIException exception = assertThrows(APIException.class, () -> {
            Package mappedPackage = PackageMapper.map(packageString);
        });
        String expectedMessage = "Cost doesn't have correct money format";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void shouldExceptionThrownForNumberOfParameters() throws APIException{

        String packageString = "(2,88.62)";
        APIException exception = assertThrows(APIException.class, () -> {
            Package mappedPackage = PackageMapper.map(packageString);
        });
        String expectedMessage = "Error trying to map a String, incorrect package parameters";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
