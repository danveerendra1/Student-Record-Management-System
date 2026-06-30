import java.util.ArrayList;

public class StudentService
{
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) 
    {
        if(searchStudentById(student.getId()) != null) 
        {
            System.out.println("\nStudent with ID " + student.getId() + " already exists.");
            return;
        }
        students.add(student);
        System.out.println("\nStudent Added Successfully!");
    }

    // Display all students
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo student records found.");
            return;
        }

        System.out.println("\nTotal Students: " + students.size());
        System.out.println("\n==============================================");
        System.out.printf("%-10s %-20s %-10s%n", "ID", "Name", "Marks");
        System.out.println("==============================================");

        for (Student student : students) {

            System.out.printf("%-10d %-20s %-10.2f%n",
                student.getId(),
                student.getName(),
                student.getMarks());
        }

        System.out.println("==============================================");
    }

    public Student searchStudentById(int id) 
    {
        for (Student student : students) 
        {
            if (student.getId() == id) 
            {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(int id, String newName, double newMarks) 
    {
        Student student = searchStudentById(id);

        if(student!=null){
            student.setName(newName);
            student.setMarks(newMarks);
            System.out.println("\nStudent Updated Successfully!");
        }else{
            System.out.println("\nStudent not found.");
        }
    }

    public void deleteStudent(int id) 
    {
        Student student = searchStudentById(id);

        if(student!=null){
            students.remove(student);
            System.out.println("\nStudent Deleted Successfully!");
        }else{
            System.out.println("\nStudent not found.");
        }
    }

    public int getTotalStudents() 
    {
        return students.size();
    }
}



