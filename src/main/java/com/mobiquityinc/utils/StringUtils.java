package com.mobiquityinc.utils;


import com.mobiquityinc.exception.APIException;

import java.util.Optional;

/**
 * Utility class for conversion purposes
 */
public final class StringUtils {
    public static Integer convertToInteger(Optional<String> string) {
        if(string.isPresent()){
            return Integer.parseInt(string.get().trim());
        }
        return null;
    }

    public static Float convertToFloat(Optional<String> string) {
        if(string.isPresent()){
            return Float.parseFloat(string.get());
        }
        return null;
    }

    public static Integer convertToMoney(Optional<String> string) throws APIException{
        String s ="-?(€+\\d{1,3}\\s*?([.,]|$|\\s)\\s*?)";
        if(string.isPresent() && string.get().matches(s)){
            return Integer.parseInt(string.get().replace("€",""));
        }
        throw new APIException("Cost doesn't have correct money format");
    }
}
