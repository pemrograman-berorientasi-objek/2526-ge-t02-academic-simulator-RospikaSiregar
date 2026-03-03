package academic.model;

/**
* @author 12S24008 Rospika Sarah Yosefin Siregar
 */
public class Enrollment {
    private String courseCode;
    private String studentNim;
    private String academicYear;
    private String semester;
    private String grade;

       public Enrollment(String courseCode, String studentNim, String academicYear, String semester) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (studentNim == null || studentNim.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (academicYear == null || academicYear.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (semester == null || semester.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.courseCode = courseCode;
        this.studentNim = studentNim;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None";
    }

    @Override
    public String toString() {
        return courseCode + "|" + studentNim + "|" + academicYear + "|" + semester + "|" + grade;
    }
}
