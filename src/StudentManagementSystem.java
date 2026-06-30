import java.util.Scanner;

public class StudentManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static StudentService service = new StudentService();

    public static void showMenu()
    {
        System.out.println("\n====================================================");
        System.out.println("\tSTUDENT RECORD MANAGEMENT SYSTEM");
        System.out.println("====================================================");
        System.out.println("\t\t---MAIN MENU---\n");
        System.out.println("\t\t1. Add Student");
        System.out.println("\t\t2. View All Student");
        System.out.println("\t\t3. Search Student");
        System.out.println("\t\t4. Update Student");
        System.out.println("\t\t5. Delete Student");
        System.out.println("\t\t6. Exit Student");
        System.out.println("====================================================");
        System.out.print("Enter Your Choice : ");

    }

    // Read integer safely
    public static int getInt(String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    // Read marks safely
    public static double getMarks(String message) {

        double marks;

        while (true) {

            System.out.print(message);
            marks = sc.nextDouble();

            if (marks >= 0 && marks <= 100) {
            return marks;
            } 
            System.out.println("❌ Marks should be between 0 and 100.");
        }
    }
    
    public static void main(String[] args) {

    int choice;

    while (true) {

        showMenu();

        choice = sc.nextInt();

        switch (choice) {

            case 1:
                int id = getInt("\nEnter Student ID: ");
                sc.nextLine(); // Consume newline
                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();
                double marks = getMarks("Enter Student Marks (0-100): ");
                Student student = new Student(id, name, marks);
                service.addStudent(student);
                break;

            case 2:
                service.viewStudents();
                break;

            case 3:
                int searchId = getInt("\nEnter Student ID to Search: ");
                Student foundStudent = service.searchStudentById(searchId);
                if (foundStudent != null) {
                    System.out.println("\nStudent Found:");
                    System.out.printf("ID: %d, Name: %s, Marks: %.2f%n",
                        foundStudent.getId(),
                        foundStudent.getName(),
                        foundStudent.getMarks());
                } else {
                    System.out.println("\nStudent with ID " + searchId + " not found.");
                }

                break;

            case 4:
                int updateId = getInt("\nEnter Student ID to Update: ");
                Student studentToUpdate = service.searchStudentById(updateId);
                if (studentToUpdate != null) {
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    double newMarks = getMarks("Enter New Marks (0-100): ");
                    service.updateStudent(updateId, newName, newMarks);
                } else {
                    System.out.println("\nStudent with ID " + updateId + " not found.");
                }
                break;

            case 5:
                int deleteId = getInt("\nEnter Student ID to Delete: ");
                service.deleteStudent(deleteId);
                break;

            case 6:
                System.out.println("====================================================");
                System.out.println("\tThank You For Using");
                System.out.println("\tSTUDENT RECORD MANAGEMENT SYSTEM");
                System.out.println("====================================================");
                sc.close();
                return;

            default:
                System.out.println("\nInvalid Choice!");
        }
    }
}
}
