package ontapgiuaki_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person {

    private float gpa;
    private String major;
    Scanner sc = new Scanner(System.in);

    public Student() {
    }

    public Student(float gpa, String major, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void addPerson() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("--Add student--");
            System.out.print("Enter ID: ");
            this.setId(sc.nextLine());
            System.out.print("Enter full name: ");
            this.setFullName(sc.nextLine());
            System.out.print("Enter GPA: ");
            this.setGpa(sc.nextFloat());
            sc.nextLine();
            System.out.print("Enter date of birth(dd/MM/yyyy) : ");
            String date = sc.nextLine();
            this.setDateOfBirth(sdf.parse(date));
            System.out.print("Enter major: ");
            this.setMajor(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid!!!!");
        }

    }

    @Override
    public void displayInfor() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String forattedDate = sdf.format(getDateOfBirth());
            System.out.println("--Display student--");
            System.out.println("ID: " + getId());
            System.out.println("Full name: " + getFullName());
            System.out.println("GPA: " + gpa);
            System.out.println("Major: " + major);
            System.out.println("Date of birth: " + forattedDate);

        } catch (Exception e) {
            System.out.println("Invalid!!!");
        }
    }

    @Override
    public void updatePerson(String id) {
    }

}
