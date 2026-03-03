package academic.model;

/**
* @author 12S24008 Rospika Sarah Yosefin Siregar
 */
public class Enrollment {

    private String student1Nim; // Diinterpretasikan sebagai NIM mahasiswa yang mendaftar
        private String student2Nim; // Diinterpretasikan sebagai Kode Mata Kuliah atau NIM mahasiswa lain untuk relasi tertentu
        private String academicYear; // Tahun akademik
        private String semester;     // Semester (e.g., "even", "odd")
        private String grade;        // Mengganti 'status' menjadi 'grade' atau biarkan 'status' jika lebih umum.
                                     // Berdasarkan contoh output Task 3 (None), saya akan gunakan 'grade'
                                     // dan default ke "None" untuk konsistensi.

        // Perluasan untuk mendukung input Task 4 yang menggunakan ini untuk 'enrollment-add'
        // Dengan format: NIM_MHS#KODE_MK#TAHUN_AKADEMIK#SEMESTER
        // Dan output: NIM_MHS|KODE_MK|TAHUN_AKADEMIK|SEMESTER|GRADE (default None)
        public Enrollment(String studentNim, String courseCode, String academicYear, String semester) {
            this(studentNim, courseCode, academicYear, semester, "None"); // Default grade ke "None"
        }

        public Enrollment(String studentNim, String courseCode, String academicYear, String semester, String grade) {
            if (studentNim == null || studentNim.trim().isEmpty()) {
                throw new IllegalArgumentException("NIM mahasiswa tidak boleh kosong.");
            }
            if (courseCode == null || courseCode.trim().isEmpty()) {
                throw new IllegalArgumentException("Kode mata kuliah tidak boleh kosong.");
            }
            if (academicYear == null || academicYear.trim().isEmpty()) {
                throw new IllegalArgumentException("Tahun Akademik tidak boleh kosong.");
            }
            if (semester == null || semester.trim().isEmpty()) {
                throw new IllegalArgumentException("Semester tidak boleh kosong.");
            }
            // Grade bisa kosong atau "None"
            this.student1Nim = studentNim;
            this.student2Nim = courseCode; // Disimpan sebagai courseCode untuk enrollment
            this.academicYear = academicYear;
            this.semester = semester;
            this.grade = grade;
        }

        // Getter methods
        public String getStudent1Nim() { return student1Nim; }
        public String getStudent2Nim() { return student2Nim; } // Akan jadi getCourseCode()
        public String getAcademicYear() { return academicYear; }
        public String getSemester() { return semester; }
        public String getGrade() { return grade; }

        @Override
        public String toString() {
            return student1Nim + "|" + student2Nim + "|" + academicYear + "|" + semester + "|" + grade;
        }
}