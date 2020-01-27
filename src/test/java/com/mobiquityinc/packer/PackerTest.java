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
        assertTrue(result.contains("[4]"));
    }

    @Test
    public void shouldMapFileToListOfDeliveryBoxesWithCompleteInfo() {
        String filePath = PackerTest.class.getClassLoader()
                .getResource("fileTest.txt").toExternalForm();
        String result = Packer.packWithCompleteInformation(filePath);
        assertNotNull(result);
        assertTrue(result.contains("Package{index=[4], weight=72.3, cost=76}"));
    }

}