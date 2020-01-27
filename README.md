# packageChallenge
Calculates the best option for package your stuffs

In order to test the solution here an example:
import com.mobiquityinc.packer.Packer;

public class Main {

    public static void main(String[] args) {
        String result = Packer.pack("file:/C:/tmp/fileTest.txt");
        System.out.println(result);
    }
}

If you need more information about the packages please run method:

public class Main {

    public static void main(String[] args) {
        String result = Packer.packWithCompleteInformation("file:/C:/tmp/fileTest.txt");
        System.out.println(result);
    }
}