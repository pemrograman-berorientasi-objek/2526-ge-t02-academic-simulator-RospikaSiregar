package academic.model;

/**
 * @author 12S24008 Rospika Sarah Yosefin Siregar
 */
public class Course {

    private String code;
    private String name;
     private int credits;
    private String grade;

    public Course(String code, String name, int credits, String grade) {
        // Lakukan validasi dasar di konstruktor
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode mata kuliah tidak boleh kosong.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama mata kuliah tidak boleh kosong.");
        }
        if (credits <= 0) {
            throw new IllegalArgumentException("SKS harus lebih dari nol.");
        }
        // Asumsi grade bisa kosong di awal atau divalidasi nanti
        // Untuk saat ini, kita akan membiarkan grade bisa kosong atau null
        // Karena contoh input menunjukkan grade 'C' dan 'D', kita bisa asumsikan ini adalah string.

        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Getter methods
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    // Override toString() untuk format output yang diminta
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}