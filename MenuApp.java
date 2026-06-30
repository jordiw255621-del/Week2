public class MenuApp {
    public static void main(String[] args) {

        Student student = new Student();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("Add Assessment (mark)");
            System.out.println("Add Assessment (grade)");
            System.out.println("View Assessments");
            System.out.println("Modify Assessment Grade");
            System.out.println("Exit");
            System.out.print("Choose option: ");

            String choice = In.nextLine().trim().toLowerCase();

            switch (choice) {

                case "add assessment (mark)":
                    System.out.print("Assessment name: ");
                    String name1 = In.nextLine();

                    System.out.print("Mark: ");
                    int mark = In.nextInt();

                    System.out.print("Total possible marks: ");
                    int total = In.nextInt();

                    student.addAssessment(name1, mark, total);
                    break;

                case "add assessment (grade)":
                    System.out.print("Assessment name: ");
                    String name2 = In.nextLine();

                    System.out.print("Grade (HD, D, C, P, F): ");
                    Grade g = Grade.valueOf(In.nextLine().toUpperCase());

                    student.addAssessment(name2, g);
                    break;

                case "view assessments":
                    student.viewAssessments();
                    break;

                case "modify assessment grade":
                    System.out.print("Assessment name: ");
                    String modName = In.nextLine();

                    Assessment a = student.findAssessment(modName);
                    if (a == null) {
                        System.out.println("Assessment not found.");
                        break;
                    }

                    System.out.print("New grade (HD, D, C, P, F): ");
                    Grade newG = Grade.valueOf(In.nextLine().toUpperCase());

                    a.penalise(newG);
                    System.out.println("Updated: " + a);
                    break;

                case "exit":
                    System.out.println("Goodbye");
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
