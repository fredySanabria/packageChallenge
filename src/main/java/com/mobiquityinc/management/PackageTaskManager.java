package com.mobiquityinc.management;

import com.mobiquityinc.domain.DeliveryBox;

/**
 * This class implements a command pattern
 */
public class PackageTaskManager {
    public DeliveryBox executeTask(PackageTask task, DeliveryBox box){
        return task.execute(box);
    }
}
