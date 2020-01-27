package com.mobiquityinc.validation;

import com.mobiquityinc.domain.Package;
import com.mobiquityinc.domain.PackageClientBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PackageValidatorTest {
    @Test
    public void shouldValidPackage(){
        Package aPackage = PackageClientBuilder.builder()
                .index(new ArrayList<>())
                .weight(50)
                .cost(50)
                .build();
        assertTrue(PackageValidator.validate(aPackage));
    }

    @Test
    public void shouldInvalidatePackageByWeight(){
        Package aPackage = PackageClientBuilder.builder()
                .index(new ArrayList<>())
                .weight(150)
                .cost(50)
                .build();
        assertFalse(PackageValidator.validate(aPackage));
    }

    @Test
    public void shouldInvalidatePackageByCost(){
        Package aPackage = PackageClientBuilder.builder()
                .index(new ArrayList<>())
                .weight(50)
                .cost(150)
                .build();
        assertFalse(PackageValidator.validate(aPackage));
    }
}
