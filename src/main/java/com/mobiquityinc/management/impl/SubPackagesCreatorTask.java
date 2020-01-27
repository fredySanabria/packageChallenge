package com.mobiquityinc.management.impl;

import com.mobiquityinc.domain.DeliveryBox;
import com.mobiquityinc.domain.DeliveryBoxClientBuilder;
import com.mobiquityinc.domain.Package;
import com.mobiquityinc.domain.PackageClientBuilder;
import com.mobiquityinc.management.PackageTask;

import java.util.ArrayList;
import java.util.List;

public class SubPackagesCreatorTask implements PackageTask {
    @Override
    public DeliveryBox execute(DeliveryBox deliveryBox) {
        List<Package> completePackageList = new ArrayList<>();
        for(Package packageItem : deliveryBox.getPackageList()){
            completePackageList.addAll(createPossibleSubPackage(packageItem, deliveryBox.getPackageList(), deliveryBox.getTotalWeight()));
        }
        return DeliveryBoxClientBuilder
                .builder()
                .totalWeight(deliveryBox.getTotalWeight())
                .packagesList(completePackageList)
                .build();
    }

    /**
     * This method groups possible sub packages that not exceed the max weight
     * @param packageItem
     * @param packageList
     * @param maxWeight
     * @return
     */
    private List<Package> createPossibleSubPackage(Package packageItem, List<Package> packageList, int maxWeight) {
        List<Package> completeList = new ArrayList<>();
        List<Package> iteratorList = new ArrayList<>();
        iteratorList.addAll(packageList);
        iteratorList.remove(packageItem);
        int count = 0;
        while(count < iteratorList.size()-1){
            if(iteratorList.get(count).getWeight() + packageItem.getWeight() <= maxWeight){
                List<Integer> indexes = new ArrayList<>();
                indexes.addAll(iteratorList.get(count).getIndex());
                indexes.addAll(packageItem.getIndex());
                completeList.add(PackageClientBuilder.builder()
                        .index(indexes)
                        .weight(iteratorList.get(count).getWeight() + packageItem.getWeight())
                        .cost(iteratorList.get(count).getCost() + packageItem.getCost())
                        .build());
            }
            count++;
        }
        if(completeList.isEmpty()){
            completeList.add(packageItem);
        }
        return completeList;
    }
}
