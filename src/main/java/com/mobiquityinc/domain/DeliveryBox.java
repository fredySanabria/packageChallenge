package com.mobiquityinc.domain;

import java.util.List;
import lombok.Value;


/**
 * This class represents a group of packages
 */
@Value
public final class DeliveryBox {
    final int totalWeight;
    final List<Package> packageList;

    @Override
    public String toString() {
        return "DeliveryBox{" +
                "totalWeight=" + totalWeight +
                ", packageList=" + packageList +
                '}';
    }
}
