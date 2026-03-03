package academic.driver;

/**
* @author 12S24008 Rospika Sarah Yosefin Siregar
 */

import academic.model.Enrollment;
import java.util.Scanner;

public class Driver3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Enrollment[] enrollments = new Enrollment[100];
        int count = 0;

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");

            enrollments[count++] = new Enrollment(
                    data[0],
                    data[1],
                    data[2],
                    data[3]
            );
        }

        for (int i = 0; i < count; i++) {
            System.out.println(enrollments[i]);
        }

        input.close();
    }
}