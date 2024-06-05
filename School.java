import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;
    private Scanner scanner;

    public School() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Add methods
    public void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Grade: ");
        int grade = scanner.nextInt();
        students.add(new Student(id, name, grade));
        System.out.println("Student added successfully.");
    }

    public void addTeacher() {
        System.out.print("Enter Teacher ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Teacher Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Teacher Subject: ");
        String subject = scanner.nextLine();
        teachers.add(new Teacher(id, name, subject));
        System.out.println("Teacher added successfully.");
    }

    public void addCourse() {
        System.out.print("Enter Course ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();
        courses.add(new Course(id, name));
        System.out.println("Course added successfully.");
    }

    public void assignTeacherToCourse() {
        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();
        System.out.print("Enter Teacher ID: ");
        int teacherId = scanner.nextInt();

        Course course = findCourseById(courseId);
        Teacher teacher = findTeacherById(teacherId);

        if (course != null && teacher != null) {
            course.setTeacher(teacher);
            System.out.println("Teacher assigned to course successfully.");
        } else {
            System.out.println("Course or Teacher not found.");
        }
    }

    public void addStudentToCourse() {
        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();

        Course course = findCourseById(courseId);
        Student student = findStudentById(studentId);

        if (course != null && student != null) {
            course.addStudent(student);
            System.out.println("Student added to course successfully.");
        } else {
            System.out.println("Course or Student not found.");
        }
    }

    // Find methods
    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private Teacher findTeacherById(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    private Course findCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    // Display methods
    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void displayTeachers() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public void displayCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    // Main method with menu
    public static void main(String[] args) {
        School school = new School();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSchool Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Add Course");
            System.out.println("4. Assign Teacher to Course");
            System.out.println("5. Add Student to Course");
            System.out.println("6. Display Students");
            System.out.println("7. Display Teachers");
            System.out.println("8. Display Courses");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    school.addStudent();
                    break;
                case 2:
                    school.addTeacher();
                    break;
                case 3:
                    school.addCourse();
                    break;
                case 4:
                    school.assignTeacherToCourse();
                    break;
                case 5:
                    school.addStudentToCourse();
                    break;
                case 6:
                    school.displayStudents();
                    break;
                case 7:
                    school.displayTeachers();
                    break;
                case 8:
                    school.displayCourses();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
