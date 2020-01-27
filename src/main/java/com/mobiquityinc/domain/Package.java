package com.mobiquityinc.domain;

import lombok.Value;

import java.util.List;


@Value
public final class Package {
    final List<Integer> index;
    final float weight;
    final int cost;

    @Override
    public String toString() {
        return "Package{" +
                "index=" + index +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
