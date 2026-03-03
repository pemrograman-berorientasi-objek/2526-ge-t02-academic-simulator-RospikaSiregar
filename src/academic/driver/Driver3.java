package academic.driver;

/**
* @author 12S24008 Rospika Sarah Yosefin Siregar
 */

import academic.model.Enrollment; 
import java.util.Scanner; // Untuk membaca input dari pengguna
import java.util.ArrayList; // Menggunakan ArrayList karena ukuran list dinamis lebih mudah
import java.util.List; // Interface List

public class Driver3 {

    public static void main(String[] _args) {

        Scanner input = new Scanner(System.in); // Objek Scanner untuk membaca input
        List<Enrollment> enrollment = new ArrayList<>();

        // Menampilkan pesan untuk pengguna
        System.out.println("Masukkan data relasi mahasiswa :");

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
                String student1Nim = data[0].trim();
                String student2Nim = data[1].trim();
                String academicYear = data[2].trim();
                String semester = data[3].trim();

                
                Enrollment newEnrollment = new Enrollment(student1Nim, student2Nim, academicYear, semester);
                enrollment.add(newEnrollment);
            } catch (IllegalArgumentException e) {
                System.err.println("Peringatan: Data relasi mahasiswa tidak valid. Lewati baris ini: " + line + " (" + e.getMessage() + ")");
            } catch (Exception e) {
                System.err.println("Peringatan: Terjadi kesalahan tidak terduga saat memproses baris: " + line + " (" + e.getMessage() + ")");
            }
        }

        input.close(); // Menutup objek Scanner untuk menghindari resource leak

        // Menampilkan semua relasi mahasiswa yang tersimpan
        System.out.println("\nDaftar Relasi Mahasiswa yang Tersimpan:");
        for (Enrollment enrollment : enrollment) {
            System.out.println(enrollment); // Menggunakan method toString() yang sudah di-override
        }

    }

}