package academic.driver;

/**
 * @author 12S24008 Rospika Sarah Yosefin Siregar
 */

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment; // Menggunakan Enrollment sesuai template user
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Driver4 {

    public static void main(String[] _args) {

        Scanner input = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>(); // Menggunakan Enrollment list

        System.out.println("Masukkan data (course-add, student-add, enrollment-add). Ketik '---' untuk berhenti:");

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("#");

            if (data.length < 1) { // Minimal harus ada command
                System.err.println("Peringatan: Format input tidak valid. Lewati baris ini: " + line);
                continue;
            }

            String command = data[0].trim(); // Command seperti "course-add"

            try {
                if (command.equals("course-add")) {
                    if (data.length != 5) { // command + 4 data
                        System.err.println("Peringatan: Format input 'course-add' tidak valid. Lewati baris ini: " + line);
                        continue;
                    }
                    String code = data[1].trim();
                    String name = data[2].trim();
                    int credits = Integer.parseInt(data[3].trim());
                    String grade = data[4].trim(); // Grade bisa jadi "None" atau nilai tertentu
                    Course newCourse = new Course(code, name, credits, grade);
                    courses.add(newCourse);
                } else if (command.equals("student-add")) {
                    if (data.length != 5) { // command + 4 data
                        System.err.println("Peringatan: Format input 'student-add' tidak valid. Lewati baris ini: " + line);
                        continue;
                    }
                    String nim = data[1].trim();
                    String name = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    String studyProgram = data[4].trim();
                    Student newStudent = new Student(nim, name, year, studyProgram);
                    students.add(newStudent);
                } else if (command.equals("enrollment-add")) {
                    // Sesuai dengan input Task 4 dan interpretasi Enrollment.java
                    // Format: enrollment-add#NIM_MHS#KODE_MK#TAHUN_AKADEMIK#SEMESTER
                    if (data.length != 5) { // command + 4 data
                        System.err.println("Peringatan: Format input 'enrollment-add' tidak valid. Lewati baris ini: " + line);
                        continue;
                    }
                    String studentNim = data[1].trim();
                    String courseCode = data[2].trim(); // Di Task 3 ini adalah student2Nim
                    String academicYear = data[3].trim();
                    String semester = data[4].trim();
                    // Menggunakan konstruktor Enrollment yang mengisi grade default "None"
                    Enrollment newEnrollment = new Enrollment(studentNim, courseCode, academicYear, semester);
                    enrollments.add(newEnrollment);
                } else {
                    System.err.println("Peringatan: Perintah tidak dikenal: " + command + ". Lewati baris ini: " + line);
                }
            } catch (NumberFormatException e) {
                System.err.println("Peringatan: Data numerik tidak valid. Lewati baris ini: " + line + " (" + e.getMessage() + ")");
            } catch (IllegalArgumentException e) {
                System.err.println("Peringatan: Data tidak valid. Lewati baris ini: " + line + " (" + e.getMessage() + ")");
            } catch (Exception e) {
                System.err.println("Peringatan: Terjadi kesalahan tidak terduga saat memproses baris: " + line + " (" + e.getMessage() + ")");
            }
        }

        input.close();

        // Menampilkan semua data yang tersimpan, sesuai urutan input secara logis
        // Mengikuti urutan output yang Anda berikan: Courses, Students, Enrollments
        System.out.println("\nDaftar Data yang Tersimpan:");

        for (Course course : courses) {
            System.out.println(course);
        }
        for (Student student : students) {
            System.out.println(student);
        }
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

    }

}