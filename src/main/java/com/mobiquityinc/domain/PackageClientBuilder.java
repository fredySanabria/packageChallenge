package com.mobiquityinc.domain;

import lombok.Builder;

import java.util.List;

/**
 *This class implements a Builder Pattern for Immutable objects
 */
public class PackageClientBuilder {
    @Builder(builderMethodName = "builder")
    public static Package newPackage(List<Integer> index, float weight, int cost){
        return new Package(index, weight, cost);
    }
}
