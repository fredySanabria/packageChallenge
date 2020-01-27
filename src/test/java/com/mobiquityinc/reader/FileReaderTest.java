package com.mobiquityinc.reader;

import com.mobiquityinc.domain.DeliveryBox;
import com.mobiquityinc.domain.Package;
import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.mapper.PackageMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    @Test
    public void shouldReadFile(){
        String filePath = FileReaderTest.class.getClassLoader()
                .getResource("fileTest.txt").toExternalForm();
        List<DeliveryBox> result = FileReader.readFile(filePath);
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    public void shouldThrowsException() throws APIException{
        APIException exception = assertThrows(APIException.class, () -> {
            List<DeliveryBox> result = FileReader.readFile("C://badPath");
        });
        String expectedMessage = "Error Trying to parse file: C://badPath";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}