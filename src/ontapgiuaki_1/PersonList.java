package ontapgiuaki_1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonList {

    private ArrayList<Person> personList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public PersonList() {
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public void addStudent(Student student) {
        personList.add(student);
        System.out.println("----Add student sucessfully---");
        
    }

    public void addTeacher(Teacher teacher) {
        personList.add(teacher);
        System.out.println("---Add teacher suscessfully---");
    }

    public void updatePerson(String id) {
        try {
            Person updatePerson = null;
            for (Person person : personList) {
                if (person.getId().equals(id)) {
                    updatePerson = person;
                    break;
                }
            }
            if (updatePerson != null) {
                if (updatePerson instanceof Student) {

                    System.out.print("Enter new full name: ");
                    String fullName = sc.nextLine();
                    updatePerson.setFullName(fullName);

                    System.out.print("Enter new GPA: ");
                    float gpa = sc.nextFloat();
                    sc.nextLine();
                    ((Student) updatePerson).setGpa(gpa);

                    System.out.print("New major: ");
                    String major = sc.nextLine();
                    ((Student) updatePerson).setMajor(major);

                    System.out.print("Enter new date of birth(dd/MM/yyyy): ");
                    String newDate = sc.nextLine();
                    updatePerson.setDateOfBirth(sdf.parse(newDate));

                } else if (updatePerson instanceof Teacher) {

                    System.out.print("Enter new full name: ");
                    String newFullName = sc.nextLine();
                    updatePerson.setFullName(newFullName);

                    System.out.print("Enter new department: ");
                    String newDepartment = sc.nextLine();
                    ((Teacher) updatePerson).setDepartment(newDepartment);

                    System.out.print("Enter new date of birth(dd/MM/yyyy): ");
                    String date = sc.nextLine();
                    updatePerson.setDateOfBirth(sdf.parse(date));

                    System.out.print("Enter new teaching subject: ");
                    String teachingSubject = sc.nextLine();
                    ((Teacher) updatePerson).setTeachingSubject(teachingSubject);

                }

            }

        } catch (Exception e) {
            System.out.println("Invalid!!");
        }
    }

    public void deletePersonbyID(String id) {
        personList.removeIf(Person -> Person.getId().equals(id));
    }

    public Person findPersonByID(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public void displayEveryone() {
        if (personList.isEmpty()) {
            System.out.println("No student in list");
        } else {
            for (Person person : personList) {
                person.displayInfor();
                System.out.println();
            }
        }
    }
    
    

    public Student findTopStudent() {
        Student topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;

                }

            }
        }
        return topStudent;
    }

    public Teacher findTeacherByDepartment(String department) {
        for (Person person : personList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equals(department)) {
                    return teacher;
                }
            }

        }
        return null;

    }

}
