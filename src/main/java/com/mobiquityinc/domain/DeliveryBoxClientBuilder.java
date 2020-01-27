package com.mobiquityinc.domain;

import lombok.Builder;

import java.util.List;

/**
 *This class implements a Builder Pattern for Immutable objects
 */
public class DeliveryBoxClientBuilder {
    @Builder(builderMethodName = "builder")
    public static DeliveryBox newDeliveryBox(int totalWeight, List<Package> packagesList){
        return new DeliveryBox(totalWeight, packagesList);
    }
}
