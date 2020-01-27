package com.mobiquityinc.management.impl;

import com.mobiquityinc.domain.DeliveryBox;
import com.mobiquityinc.domain.DeliveryBoxClientBuilder;
import com.mobiquityinc.domain.Package;
import com.mobiquityinc.management.PackageTask;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveHeavyPackagesTask implements PackageTask {

    /**
     * This task reduces the package list, filtering the packages that exceed the maximum weight
     * @param deliveryBox
     * @return
     */
    @Override
    public DeliveryBox execute(DeliveryBox deliveryBox) {
        List<Package> filteredList = deliveryBox.getPackageList().stream()
                .filter(aPackage -> aPackage.getWeight() <= deliveryBox.getTotalWeight())
                .collect(Collectors.toList());

    return DeliveryBoxClientBuilder
            .builder()
            .totalWeight(deliveryBox.getTotalWeight())
            .packagesList(filteredList)
            .build();
    }
}
