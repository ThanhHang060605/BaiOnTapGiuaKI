
package ontapgiuaki_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Teacher extends Person{
    private String department;
    private String teachingSubject;
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Teacher() {
    }

    public Teacher(String department, String teachingSubject, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    @Override
    public void addPerson() {
        try {
            System.out.println("--Add teacher--");
            System.out.print("Enter ID: ");
            this.setId(sc.nextLine());
            
            System.out.print("Enter full name: ");
            this.setFullName(sc.nextLine());
            
            System.out.print("Enter department: ");
            this.setDepartment(sc.nextLine());
            
            System.out.print("Enter teaching subject: ");
            this.setTeachingSubject(sc.nextLine());
            
            System.out.print("Enter date of birth(dd/MM/yyyy): ");
            String date = sc.nextLine();
            this.setDateOfBirth(sdf.parse(date));
            
        } catch (Exception e) {
            System.out.println("Invalid!!!");
        }
    }

    @Override
    public void displayInfor() {
        try {
            String formattedDate = sdf.format(getDateOfBirth());
            System.out.println("---Display teacher---");
            
            System.out.println("ID: " + getId());
            System.out.println("Full name: " + getFullName());
            System.out.println("Department: " + department);
            System.out.println("Teaching Subjeact: " + teachingSubject);
            System.out.println("Date of birth: " + formattedDate);
            
        } catch (Exception e) {
            System.out.println("Invalidd!!!");
        }
    }
    
    
    @Override
    public void updatePerson(String id) {
    }

    
    

    
}
