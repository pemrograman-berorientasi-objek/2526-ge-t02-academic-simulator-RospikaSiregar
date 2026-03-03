package academic.model;

/**
 * @author 12S24008 Rospika Sarah Yosefin Siregar
 */
public class Student {

    private String nim;
    private String name;
    private int year; // Angkatan
    private String studyProgram; // Prodi

    public Student(String nim, String name, int year, String studyProgram) {
        // Lakukan validasi dasar di konstruktor, sesuai dengan ekspektasi "validasi data harus tepat"
        if (nim == null || nim.trim().isEmpty()) {
            throw new IllegalArgumentException("NIM tidak boleh kosong.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama mahasiswa tidak boleh kosong.");
        }
        if (year <= 0 || year > 9999) { // Angkatan harus angka positif yang masuk akal
            throw new IllegalArgumentException("Angkatan tidak valid.");
        }
        if (studyProgram == null || studyProgram.trim().isEmpty()) {
            throw new IllegalArgumentException("Prodi tidak boleh kosong.");
        }

        this.nim = nim;
        this.name = name;
        this.year = year;
        this.studyProgram = studyProgram;
    }

    // Getter methods
    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    // Override toString() untuk format output yang diminta
    @Override
    public String toString() {
        return nim + "|" + name + "|" + year + "|" + studyProgram;
    }

}