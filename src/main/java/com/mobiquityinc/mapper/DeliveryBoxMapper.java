package com.mobiquityinc.mapper;

import com.mobiquityinc.domain.DeliveryBox;
import com.mobiquityinc.domain.DeliveryBoxClientBuilder;
import com.mobiquityinc.domain.Package;
import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.utils.StringUtils;
import com.mobiquityinc.validation.PackageValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DeliveryBoxMapper {
    public static DeliveryBox map(String line) throws APIException {
        String[] boxInformation = line.split(":");
        if(boxInformation.length == 2) {
            int totalWeight = StringUtils.convertToInteger(Optional.ofNullable(boxInformation[0]));
            List<Package> packageList = extractPackageInformationFromString(Optional.ofNullable(boxInformation[1]));
            return DeliveryBoxClientBuilder
                    .builder()
                    .totalWeight(totalWeight)
                    .packagesList(packageList)
                    .build();
        } else {
            throw new APIException("Error trying to map a String, incorrect package parameters");
        }
    }

    private static List<Package> extractPackageInformationFromString(Optional<String> line) throws APIException{
        List<Package> packagesList = new ArrayList<>();
        if(line.isPresent()){
            String[] packageArray = line.get().trim().split(" ");
            List<String> packagesStringList = Arrays.asList(packageArray);
            for (String packageInformation : packagesStringList) {
                Package map = PackageMapper.map(packageInformation);
                if (PackageValidator.validate(map)) {
                    packagesList.add(map);
                }
            }
        }
        return packagesList;
    }
}
