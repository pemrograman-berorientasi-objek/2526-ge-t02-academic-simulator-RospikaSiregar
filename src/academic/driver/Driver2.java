package academic.driver;

/**
 * @author 12S24008 Rospika Sarah Yosefin Siregar
 */

import academic.model.Student;
import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");

            students[count++] = new Student(
                    data[0],
                    data[1],
                    Integer.parseInt(data[2]),
                    data[3]
            );
        }

        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }

        input.close();
    }
}

