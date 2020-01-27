package com.mobiquityinc.mapper;

import com.mobiquityinc.domain.DeliveryBox;
import com.mobiquityinc.exception.APIException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryBoxMapperTest {
    @Test
    public void shouldMappingLine() throws APIException {
        String line = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9)";
        DeliveryBox box = DeliveryBoxMapper.map(line);
        assertNotNull(box);
        assertEquals(81, box.getTotalWeight());
        assertEquals(5, box.getPackageList().size());
    }


}
