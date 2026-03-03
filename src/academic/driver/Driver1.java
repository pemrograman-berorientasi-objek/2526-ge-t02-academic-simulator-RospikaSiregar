package academic.driver;

/**
 * @author 12S24008 Rospika Sarah Yosefin Siregar
 */
import academic.model.Course; // Mengimpor kelas Course
import java.util.Scanner; // Untuk membaca input dari pengguna
import java.util.ArrayList; // Menggunakan ArrayList karena ukuran array dinamis lebih mudah
import java.util.List; // Interface List

public class Driver1 {

    public static void main(String[] _args) {

         Scanner input = new Scanner(System.in); // Objek Scanner untuk membaca input
        List<Course> courses = new ArrayList<>(); // Menggunakan ArrayList untuk menyimpan objek Course

        // Menampilkan pesan untuk pengguna
        System.out.println("Masukkan data mata kuliah (format: KODE#NAMA#SKS#GRADE). Ketik '---' untuk berhenti:");

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
                String code = data[0].trim();
                String name = data[1].trim();
                int credits = Integer.parseInt(data[2].trim()); // Mengubah SKS dari String ke int
                String grade = data[3].trim();

                // Membuat objek Course baru dan menambahkannya ke list
                Course newCourse = new Course(code, name, credits, grade);
                courses.add(newCourse);
            } catch (NumberFormatException e) {
                System.err.println("Peringatan: SKS harus berupa angka. Lewati baris ini: " + line + " (" + e.getMessage() + ")");
            } catch (IllegalArgumentException e) {
                System.err.println("Peringatan: Data mata kuliah tidak valid. Lewati baris ini: " + line + " (" + e.getMessage() + ")");
            } catch (Exception e) {
                System.err.println("Peringatan: Terjadi kesalahan tidak terduga saat memproses baris: " + line + " (" + e.getMessage() + ")");
            }
        }

        input.close(); // Menutup objek Scanner untuk menghindari resource leak

        // Menampilkan semua mata kuliah yang tersimpan
        System.out.println("\nDaftar Mata Kuliah yang Tersimpan:");
        for (Course course : courses) {
            System.out.println(course); // Menggunakan method toString() yang sudah di-override
        }

    }

}