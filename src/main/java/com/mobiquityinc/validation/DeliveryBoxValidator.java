package com.mobiquityinc.validation;

import com.mobiquityinc.domain.DeliveryBox;
import com.mobiquityinc.domain.Package;
import com.mobiquityinc.validation.impl.DeliveryBoxMaxItemsValidation;
import com.mobiquityinc.validation.impl.DeliveryBoxMaxWeightValidation;
import com.mobiquityinc.validation.impl.MaxCostValidation;
import com.mobiquityinc.validation.impl.MaxWeightValidation;

import java.util.ArrayList;
import java.util.List;

public class DeliveryBoxValidator {
    public static Boolean validate(DeliveryBox deliveryBox) {
        Boolean isValidDeliveryBox = true;
        List<DeliveryBoxValidation> validationList = new ArrayList<>();
        validationList.add(new DeliveryBoxMaxItemsValidation());
        validationList.add(new DeliveryBoxMaxWeightValidation());
        for(DeliveryBoxValidation validation : validationList){
            isValidDeliveryBox = validation.validate(deliveryBox);
            if(!isValidDeliveryBox) break;
        }
        return isValidDeliveryBox;
    }
}
