package com.mobiquityinc.packer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackerTest {
    @Test
    public void shouldMapFileToListOfDeliveryBoxes() {
        String filePath = PackerTest.class.getClassLoader()
                .getResource("fileTest.txt").toExternalForm();
        String result = Packer.pack(filePath);
        assertNotNull(result);
    }

}