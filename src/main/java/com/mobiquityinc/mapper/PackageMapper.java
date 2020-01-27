package com.mobiquityinc.mapper;

import com.mobiquityinc.domain.Package;
import com.mobiquityinc.domain.PackageClientBuilder;
import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PackageMapper {
    public static Package map(String packageString) throws APIException {
        List<Integer> index = new ArrayList<>();
        Float weight;
        Integer cost;
        packageString = packageString.substring(1, packageString.length()-1);
        String[] splitString = packageString.split(",");
        if(splitString.length > 2) {
            index.add(StringUtils.convertToInteger(Optional.ofNullable(splitString[0])));
            weight = StringUtils.convertToFloat(Optional.ofNullable(splitString[1]));
            cost = StringUtils.convertToMoney(Optional.ofNullable(splitString[2]));
        } else {
            throw new APIException("Error trying to map a String, incorrect package parameters");
        }
        return PackageClientBuilder.builder()
                .index(index)
                .weight(weight)
                .cost(cost)
                .build();
    }
}
