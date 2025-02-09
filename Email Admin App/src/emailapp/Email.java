package emailapp;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    //Constructor for first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        //Call method for dept - return dept
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //Call method to gen random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + lastName.toLowerCase() + '@' + department + '.' + companySuffix;
        System.out.println("Your email is: " + email);
    }

    //Ask for department
    private String setDepartment() {
        System.out.println("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none \nEnter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales";}
        else if (depChoice == 2) {return "dev";}
        else if (depChoice == 3) {return "acct";}
        else {return "";}
    }

    //Generate random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
            //System.out.println(password);
        }
        return new String(password);
    }

    //Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set alt email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Change password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {return mailboxCapacity;}
    public String getAlertnameEmail() {return alternateEmail;}
    public String getPassword() {return password;}

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + "" + lastName + "\n" +
                "COMPANY EMAIL: " + email + "\n" +
                "MAILBOX CAPACITY: " + mailboxCapacity + "mb";


    }
}
