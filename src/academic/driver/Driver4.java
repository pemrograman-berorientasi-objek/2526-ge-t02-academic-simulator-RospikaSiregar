package academic.driver;

/**
 * @author 12S24008 Rospika Sarah Yosefin Siregar
 */

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;

public class Driver4 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Course[] courses = new Course[100];
        Student[] students = new Student[100];
        Enrollment[] enrollments = new Enrollment[100];

        int cCount = 0;
        int sCount = 0;
        int eCount = 0;

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");

            if (data[0].equals("course-add")) {

                courses[cCount++] = new Course(
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        data[4]
                );
            
            } else if (data[0].equals("student-add")) {

                students[sCount++] = new Student(
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        data[4]
                );
            
            } else if (data[0].equals("enrollment-add")) {

                enrollments[eCount++] = new Enrollment(
                        data[1],
                        data[2],
                        data[3],
                        data[4]
                );
            }
        }

         for (int i = 0; i < cCount; i++) {
            System.out.println(courses[i]);
        }

        for (int i = 0; i < sCount; i++) {
            System.out.println(students[i]);
        }

        for (int i = 0; i < eCount; i++) {
            System.out.println(enrollments[i]);
        }

        input.close();
    }
}
