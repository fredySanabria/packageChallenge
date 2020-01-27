package com.mobiquityinc.packer;

import com.mobiquityinc.domain.DeliveryBox;
import com.mobiquityinc.domain.Package;
import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.management.PackageTaskManager;
import com.mobiquityinc.management.impl.BestOptionSelectionTask;
import com.mobiquityinc.management.impl.OrderPackageByWeight;
import com.mobiquityinc.management.impl.RemoveHeavyPackagesTask;
import com.mobiquityinc.management.impl.SubPackagesCreatorTask;
import com.mobiquityinc.reader.FileReader;

import java.util.List;
import java.util.stream.Collectors;

public class Packer {

  private Packer() {
  }

  public static String pack(String filePath) throws APIException {
    //Task Manager
    PackageTaskManager taskManager = new PackageTaskManager();
    //Task list
    RemoveHeavyPackagesTask removeTask = new RemoveHeavyPackagesTask();
    OrderPackageByWeight orderPackageTask = new OrderPackageByWeight();
    SubPackagesCreatorTask subPackagesTask = new SubPackagesCreatorTask();
    BestOptionSelectionTask bestOptionTask = new BestOptionSelectionTask();
    List<DeliveryBox> deliveryBoxes = FileReader.readFile(filePath);
    deliveryBoxes = deliveryBoxes.stream()
            .map(item -> taskManager.executeTask(removeTask,item))
            .map(item -> taskManager.executeTask(orderPackageTask,item))
            .map(item -> taskManager.executeTask(subPackagesTask,item))
            .map(item -> taskManager.executeTask(bestOptionTask, item))
            .collect(Collectors.toList());

    return deliveryBoxes.stream()
            .flatMap(deliveryBox->deliveryBox.getPackageList().stream())
            .map(Package::toString)
            .collect( Collectors.joining(",") );
  }
}
