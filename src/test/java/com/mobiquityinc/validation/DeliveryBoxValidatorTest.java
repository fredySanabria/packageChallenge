package com.mobiquityinc.validation;

import com.mobiquityinc.domain.DeliveryBox;
import com.mobiquityinc.domain.DeliveryBoxClientBuilder;
import com.mobiquityinc.domain.Package;
import com.mobiquityinc.domain.PackageClientBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeliveryBoxValidatorTest {

    private static List<Package> packageList;
    @BeforeAll
    public static void init(){
        packageList = new ArrayList<>();
    }

    @Test
    public void shouldValidDeliveryBox(){

        DeliveryBox deliveryBox = DeliveryBoxClientBuilder
                .builder()
                .totalWeight(80)
                .packagesList(packageList)
                .build();
        assertTrue(DeliveryBoxValidator.validate(deliveryBox));
    }

    @Test
    public void shouldInvalidateDeliveryBoxByWeight(){
        Package aPackage = PackageClientBuilder.builder()
                .index(new ArrayList<>())
                .weight(50)
                .cost(50)
                .build();
        packageList.add(aPackage);
        DeliveryBox deliveryBox = DeliveryBoxClientBuilder
                .builder()
                .totalWeight(180)
                .packagesList(packageList)
                .build();
        assertFalse(DeliveryBoxValidator.validate(deliveryBox));
    }

}
