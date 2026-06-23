// // these are the instructions for this whole program
// // Create a Grade enumeration, representing the possible grades you can
// attain for assessments and courses at UTS College.
// Create an Assessment class with attributes:
// A name of type String
// A mark of type int, which represents the actual mark the student obtained for
// the assessment.
// A totalPossibleMarks attribute of type int, representing the number of
// available marks for this assessment.
// A fudgeMark attribute of type int, representing a positive or negative change
// to the mark that is applied at the discretion of the College. For example, if
// a student obtained a mark of 60, and a fudge mark of -5 was applied, the
// final mark becomes 60 - 5 == 55.
// In addition
// Write an alternate constructor that initialises these attributes.
// Write a method Grade computeGrade() that computes and returns the grade of
// the assessment.
// Write a method void penalise(int penalty), which applies a penalty to the
// assessment's mark by setting the fudgeMark. Note: the penalty parameter must
// be positive. e.g. calling penalise(10) means a 10-mark penalty is applied,
// which means fudgeMark is set to -10.
// Write an overloaded method void penalise(Grade newGrade), which sets
// fudgeMark to the largest possible value such that the resulting grade of the
// assessment is equal to newGrade. For example, suppose an assessment's mark is
// 77 out of 100, for a grade of D. Calling penalise(Grade.CREDIT) should result
// in a fudgeMark of -3 (as it results in a mark of 74, which is the largest
// possible score to obtain a C grade).
// Implement the toString() method. Ensure that the grade is printed.
// Create a Student class containing:
// A single attribute ArrayList<Assessment> assessments.
// A void addAssessment(String name, int mark, int totalPossibleMarks) method.
// Before adding an Assessment instance, iterate through the assessments
// attribute to ensure that an assessment with the given name does not already
// exist. If such an assessment already exists, report an error.
// Add an overloaded method void addAssessment(String name, Grade grade).
// Test the code

package Assessment1.java;

import java.util.ArrayList;

public class Assessment {
    String name;
    int mark;
    int totalPossibleMarks;
    int fudgeMark;

    public Assessment(String name, int mark, int totalPossibleMarks) {
        this.name = name;
        this.mark = mark;
        this.totalPossibleMarks = totalPossibleMarks;
        this.fudgeMark = 0;
    }

    public void addAssessment(String name, int mark, int totalPossibleMarks) {
        if (this.name.equals(name)) {
            System.out.println("An assessment with the name " + name + " already exists.");
        } else {
            this.name = name;
            this.mark = mark;
            this.totalPossibleMarks = totalPossibleMarks;
            this.fudgeMark = 0;
        }
    }

    public void addAssessment(String name, Grade grade) {
        if (this.name.equals(name)) {
            System.out.println("An assessment with the name " + name + " already exists.");
        } else {
            this.name = name;
            this.mark = grade.ordinal() * 10;
            this.totalPossibleMarks = 100;
            this.fudgeMark = 0;
        }
    }
}
