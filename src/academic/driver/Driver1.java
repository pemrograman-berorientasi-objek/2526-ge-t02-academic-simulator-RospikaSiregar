package academic.driver;

/**
 * @author 12S24008 Rospika Sarah Yosefin Siregar
 */
import academic.model.Course;
import java.util.Scanner;

public class Driver1 {

    public static void main(String[] _args) {

        Scanner input = new Scanner(System.in);
        Course[] courses = new Course[100];
        int count = 0;

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");

            String code = data[0].trim();
            String name = data[1].trim();
            int credits = Integer.parseInt(data[2].trim());
            String grade = data[3].trim();

            courses[count++] = new Course(code, name, credits, grade);
        }

        for (int i = 0; i < count; i++) {
            System.out.println(courses[i]);
        }

        input.close();
    }
}