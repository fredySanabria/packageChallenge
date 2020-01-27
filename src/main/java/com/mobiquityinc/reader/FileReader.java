package com.mobiquityinc.reader;

import com.mobiquityinc.domain.DeliveryBox;
import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.mapper.DeliveryBoxMapper;
import com.mobiquityinc.validation.DeliveryBoxValidator;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    public static List<DeliveryBox> readFile(String filePath) throws APIException{
        try (Stream<String> stream = Files.lines(Paths.get(URI.create(filePath)))) {
            return stream
                    .map(DeliveryBoxMapper::map)
                    .filter(DeliveryBoxValidator::validate)
                    .collect(Collectors.toList());
        } catch (IOException | FileSystemNotFoundException e ) {
            throw new APIException("Error Trying to parse file: " + filePath, e);
        }
    }
}
