package com.mobiquityinc.validation.impl;

import com.mobiquityinc.domain.Package;
import com.mobiquityinc.validation.PackageValidation;

/**
 * Validate the max weight that a package can take
 */
public class MaxWeightValidation implements PackageValidation {
    @Override
    public Boolean validate(Package aPackage) {
        return aPackage.getWeight() <= 100;
    }
}
