package academic.model;

/**
 * @author 12S24008 Rospika Sarah Yosefin Siregar
 */
public class Student {

    private String nim;
    private String name;
    private int year;
    private String studyProgram;

    public Student(String nim, String name, int year, String studyProgram) {
        if (nim == null || nim.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (year <= 0) {
            throw new IllegalArgumentException();
        }
        if (studyProgram == null || studyProgram.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.nim = nim;
        this.name = name;
        this.year = year;
        this.studyProgram = studyProgram;
    }

     @Override
    public String toString() {
        return nim + "|" + name + "|" + year + "|" + studyProgram;
    }
}