package com.mobiquityinc.management;

import com.mobiquityinc.domain.DeliveryBox;

public interface PackageTask {
    public abstract DeliveryBox execute(DeliveryBox deliveryBox);
}
