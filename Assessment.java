
enum Grade {
    HD, D, C, P, F
}

class Assessment {
    String name;
    int mark;
    int totalPossibleMarks;
    int fudgeMark;

    // Write an alternate constructor that initialises these attributes.
    Assessment(String name, int mark, int totalPossibleMarks, int fudgeMark) {
        this.name = name;
        this.mark = mark;
        this.totalPossibleMarks = totalPossibleMarks;
        this.fudgeMark = 0;
    }

    Grade computeGrade() {

        double markPercentage = (double) (this.mark + this.fudgeMark)
                / (double) (this.totalPossibleMarks + this.fudgeMark);

        if (markPercentage < 0.5) {
            return Grade.F;
        } else if (markPercentage < 0.65) {
            return Grade.P;
        } else if (markPercentage < 0.75) {
            return Grade.C;
        } else if (markPercentage < 0.85) {
            return Grade.D;
        } else {
            return Grade.HD;
        }
    }

    void penalise(int penalty) {
        this.fudgeMark = -penalty;
    }

    // test the computeGrade method
    class TestAssessment {
        public static void main(String[] args) {
            Assessment assessment = new Assessment("Final exam", 30, 60, 0);
            assessment.penalise(-30);
            System.out.println(assessment.computeGrade());
        }
    }
}
