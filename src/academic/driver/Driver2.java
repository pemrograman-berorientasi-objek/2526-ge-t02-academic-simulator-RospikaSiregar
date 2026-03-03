package academic.driver;

/**
 * @author 12S24008 Rospika Sarah Yosefin Siregar
 */

import academic.model.Student; // Mengimpor kelas Student
import java.util.Scanner; // Untuk membaca input dari pengguna
import java.util.ArrayList; // Menggunakan ArrayList karena ukuran list dinamis lebih mudah
import java.util.List; // Interface List

public class Driver2 {

    public static void main(String[] _args) {

        Scanner input = new Scanner(System.in); // Objek Scanner untuk membaca input
        List<Student> students = new ArrayList<>(); // Menggunakan ArrayList untuk menyimpan objek Student

        // Menampilkan pesan untuk pengguna
        System.out.println("Masukkan data mahasiswa :");

        while (true) { // Loop tak terbatas untuk membaca input
            String line = input.nextLine(); // Membaca satu baris input dari pengguna

            if (line.equals("---")) { // Memeriksa jika pengguna ingin berhenti
                break; // Keluar dari loop
            }

            // Validasi format input
            String[] data = line.split("#"); // Memisahkan baris input berdasarkan '#'

            if (data.length != 4) { // Memastikan ada 4 segmen data
                System.err.println("Peringatan: Format input tidak valid. Lewati baris ini: " + line);
                continue; // Lanjutkan ke input berikutnya
            }

            try {
                String nim = data[0].trim();
                String name = data[1].trim();
                int year = Integer.parseInt(data[2].trim()); // Mengubah Angkatan dari String ke int
                String studyProgram = data[3].trim();

                // Membuat objek Student baru dan menambahkannya ke list
                Student newStudent = new Student(nim, name, year, studyProgram);
                students.add(newStudent);
            } catch (NumberFormatException e) {
                System.err.println("Peringatan: Angkatan harus berupa angka. Lewati baris ini: " + line + " (" + e.getMessage() + ")");
            } catch (IllegalArgumentException e) {
                System.err.println("Peringatan: Data mahasiswa tidak valid. Lewati baris ini: " + line + " (" + e.getMessage() + ")");
            } catch (Exception e) {
                System.err.println("Peringatan: Terjadi kesalahan tidak terduga saat memproses baris: " + line + " (" + e.getMessage() + ")");
            }
        }

        input.close(); // Menutup objek Scanner untuk menghindari resource leak

        // Menampilkan semua mahasiswa yang tersimpan
        System.out.println("\nDaftar Mahasiswa yang Tersimpan:");
        for (Student student : students) {
            System.out.println(student); // Menggunakan method toString() yang sudah di-override
        }

    }

}