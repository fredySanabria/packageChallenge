package com.mobiquityinc.management.impl;

import com.mobiquityinc.domain.DeliveryBox;
import com.mobiquityinc.domain.DeliveryBoxClientBuilder;
import com.mobiquityinc.domain.Package;
import com.mobiquityinc.management.PackageTask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


/**
 * This task finds the highest price among the existing options,
 * if there are 2 equal prices, look for the lowest weight.
 */
public class BestOptionSelectionTask implements PackageTask {
    @Override
    public DeliveryBox execute(DeliveryBox deliveryBox) {
        List<Package> bestOptionList = new ArrayList<>();
        Optional<Package> bestOption = deliveryBox.getPackageList().stream()
        .sorted(Comparator.comparing(Package::getCost).reversed()
                .thenComparing(Package::getWeight))
                .findFirst();

        if(bestOption.isPresent()){
             bestOptionList.add(bestOption.get());
        }

        return DeliveryBoxClientBuilder
                .builder()
                .totalWeight(deliveryBox.getTotalWeight())
                .packagesList(bestOptionList)
                .build();
    }
}
