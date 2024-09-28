package ontapgiuaki_1;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        PersonList personList = new PersonList();
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        boolean exit = false;
        while (!exit) {
            try {

                System.out.println("\n******Choice an option****"
                        + "\n1. Add new student"
                        + "\n2. Add new teacher"
                        + "\n3. Update person by id"
                        + "\n4. Delete person by id"
                        + "\n5. Display all students and teachers"
                        + "\n6. Find the student with the highest GPA"
                        + "\n7. find the teacher bt department"
                        + "\n8. exit"
                        + "\n----Enter number----");

                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        Student student = new Student();
                        student.addPerson();
                        personList.addStudent(student);
                        break;

                    case 2:
                        Teacher teacher = new Teacher();
                        teacher.addPerson();
                        personList.addTeacher(teacher);
                        break;

                    case 3:
                        System.out.print("Enter ID to update: ");
                        String id = sc.nextLine();
                        personList.updatePerson(id);
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        String iD = sc.nextLine();
                        personList.deletePersonbyID(iD);
                        break;

                    case 5:
                        System.out.println("-----Display all Students and teachers-------");
                        personList.displayEveryone();
                        break;

                    case 6:
                        System.out.println("Find student with the hihgest GPA");
                        Student student1 = personList.findTopStudent();
                        if (student1 != null) {
                            student1.displayInfor();
                        } else {
                            System.out.println("Not found student");
                        }
                        break;

                    case 7:
                        System.out.print("Enter department to find");
                        String de = sc.nextLine();
                        Teacher teacher1 = personList.findTeacherByDepartment(de);

                        if (de != null) {
                            teacher1.displayInfor();
                        } else {
                            System.out.println("Not found teacher");
                        }
                        break;

                    case 8:
                        exit = true;
                        break;

                    default:
                        System.out.println("The end programming!!!");
                }

            } catch (Exception e) {
                System.out.println("Invalid!!!");
            }
        }
        sc.close();
    }

}
