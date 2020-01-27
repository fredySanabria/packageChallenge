package com.mobiquityinc.validation;

import com.mobiquityinc.domain.Package;
import com.mobiquityinc.validation.impl.MaxCostValidation;
import com.mobiquityinc.validation.impl.MaxWeightValidation;

import java.util.ArrayList;
import java.util.List;

public class PackageValidator {
    public static Boolean validate(Package aPackage) {
        Boolean isValidPackage = true;
        List<PackageValidation> validationList = new ArrayList<>();
        validationList.add(new MaxCostValidation());
        validationList.add(new MaxWeightValidation());
        for(PackageValidation validation : validationList){
            isValidPackage = validation.validate(aPackage);
            if(!isValidPackage) break;
        }
        return isValidPackage;
    }
}
