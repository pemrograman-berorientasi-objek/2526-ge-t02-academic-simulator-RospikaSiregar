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
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (credits <= 0) {
            throw new IllegalArgumentException();
        }

        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}