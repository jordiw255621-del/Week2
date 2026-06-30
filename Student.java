import java.util.ArrayList;

enum Grade {
    F, P, C, D, HD
}

public class Student {
    ArrayList<Assessment> assessments;

    void addAssessment(String name, int mark, int totalPossibleMarks) {
        Assessment a = new Assessment(name, mark, totalPossibleMarks);
        this.assessments.add(a);
    }

    void addAssessment(String name, Grade grade) {
        // Since this assessment has no 'marks', let's assume it is out of 100.
        int mark = 0;
        if (grade == Grade.F) {
            mark = 49;
        } else if (grade == Grade.P) {
            mark = 64;
        } else if (grade == Grade.C) {
            mark = 74;
        } else if (grade == Grade.D) {
            mark = 84;
        } else {
            mark = 100;
        }

        Assessment a = new Assessment(name, mark, 100);
        this.assessments.add(a);
    }
}

class Assessment {
    String name;
    int mark, totalPossibleMarks, fudgeMark;

    Assessment(String name, int mark, int totalPossibleMarks) {
        this.name = name;
        this.mark = mark;
        this.totalPossibleMarks = totalPossibleMarks;
        this.fudgeMark = 0;
    }

    Grade computeGrade() {
        double markOutOf100 = (double) this.mark / this.totalPossibleMarks;
        if (markOutOf100 < 0.5) {
            return Grade.F;
        } else if (markOutOf100 < 0.65) {
            return Grade.P;
        } else if (markOutOf100 < 0.75) {
            return Grade.C;
        } else if (markOutOf100 < 0.85) {
            return Grade.D;
        } else {
            return Grade.HD;
        }
    }

    void penalise(int penalty) {
        if (penalty > 0) {
            this.fudgeMark = -penalty;
        } else {
            System.out.println("Penalty must be positive!");
        }
    }

    void penalise(Grade newGrade) {
        int newMark = highestMarkForGrade(newGrade);
        this.fudgeMark = this.mark - newMark;
        System.out.println("new fudge: " + this.fudgeMark);
    }

    int highestMarkForGrade(Grade grade) {
        if (grade == Grade.F) {
            return (int) (0.4999999 * totalPossibleMarks);
        } else if (grade == Grade.P) {
            return (int) (0.649999999 * totalPossibleMarks);
        } else if (grade == Grade.C) {
            return (int) (0.749999999 * totalPossibleMarks);
        } else if (grade == Grade.D) {
            return (int) (0.849999999 * totalPossibleMarks);
        } else {
            return totalPossibleMarks;
        }
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", mark: " + this.mark + "/" + this.totalPossibleMarks + ", grade: "
                + this.computeGrade();
    }

    public static void main(String[] args) {
        Assessment a = new Assessment("aa", 50, 99);
        System.out.println(a);
        a.penalise(Grade.F);
    }
}