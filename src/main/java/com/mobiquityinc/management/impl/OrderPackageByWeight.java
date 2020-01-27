package com.mobiquityinc.management.impl;

import com.mobiquityinc.domain.DeliveryBox;
import com.mobiquityinc.domain.DeliveryBoxClientBuilder;
import com.mobiquityinc.domain.Package;
import com.mobiquityinc.management.PackageTask;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This task allows sort the package list by weight
 */
public class OrderPackageByWeight implements PackageTask {
    @Override
    public DeliveryBox execute(DeliveryBox deliveryBox) {
        List<Package> orderedList = deliveryBox.getPackageList().stream()
                .sorted(Comparator.comparing(Package::getWeight))
                .collect(Collectors.toList());
        return DeliveryBoxClientBuilder
                .builder()
                .totalWeight(deliveryBox.getTotalWeight())
                .packagesList(orderedList)
                .build();
    }
}
