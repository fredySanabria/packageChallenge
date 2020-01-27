package com.mobiquityinc.validation.impl;

import com.mobiquityinc.domain.DeliveryBox;
import com.mobiquityinc.validation.DeliveryBoxValidation;

public class DeliveryBoxMaxItemsValidation implements DeliveryBoxValidation {
    @Override
    public Boolean validate(DeliveryBox deliveryBox) {

        return deliveryBox.getPackageList().size() <= 15;
    }
}
