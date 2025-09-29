import java.util.Scanner;
public class HealthKiosk {
    public static void main(String[] args) {
        String service = "";
        String category = " ";
        double bmi = 0;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");

        System.out.println("Enter service code (P/L/T/C): ");
        char serviceCode = scanner.next().charAt(0);
        char lowerCaseCode = Character.toLowerCase(serviceCode);
        
        //reading user
        switch (lowerCaseCode) {
            case 'p':
            service = "Pharmacy Desk";
            System.out.println("Pharmacy Desk"); 
            break;
            case 'l':
            service = "Lab Desk";
            System.out.println("Lab Desk");
            break;
            case 't':
            service = "Triage Desk";
            System.out.println("Triage Desk");
            break;
            case 'c':
            service = "Counseling Desk";
            System.out.println("Counseling Desk");
            break;
            default:
            System.out.println("Invalid service code");
        }
            System.out.println("Go to: " + service);


            //metrics for Triage 
        if (service == "Triage Desk") {
            System.out.println("Enter health metric: ");
            System.out.println("1:BMI, 2:Dosage round-up, 3:Simple trig helper");
            int option = scanner.nextInt();
            
            if (option == 1) { 
                System.out.println("Enter your weight(in kg): ");
                double weight = scanner.nextDouble();

                System.out.println("Enter your height(in meters): ");
                double height = scanner.nextDouble();
                bmi = weight/Math.pow(height, 2);
                System.out.println(Math.round(bmi*10));

                if (bmi>18.5) {
                    category = "Underweight";
                } else if (bmi <= 24.9) {
                    category = "Normal ";
                } else if (bmi<=29.9) {
                    category = "Overweight";
                } else if (bmi>=30) {
                    category="Obese";
                }
                System.out.println("BMI: " + bmi);
                System.out.println("You are in category: " + category);

            } else if (option == 2) {
                System.out.println("Enter the required dosage (mg): ");
                double dosage = scanner.nextDouble();
                
                int weightOfTablets = 250;
                double roundUp = Math.ceil(dosage/weightOfTablets);
                System.out.print("Number of tablets: " + Math.round(roundUp));

            } else if (option == 3) { 
                System.out.println("Enter an angle in degrees: ");
                double angle = scanner.nextDouble();

                double sinInRadians = Math.toRadians(angle);
                double cosInRadians = Math.toRadians(angle);

                double usingSin = Math.sin(sinInRadians);
                double usingCos = Math.cos(cosInRadians);

                double roundedSin = Math.round((usingSin*1000)/1000);
                double roundedCos = Math.round((usingCos*1000)/1000);

                System.out.println("The sin of the angle in radians is: " + usingSin);
                System.out.println("The cos of the angle in radians is: " + usingCos);

                System.out.println("The sin of the angle is: " + roundedSin);
                System.out.println("The cos of the angle is: " + roundedCos);
            }
        } 

        //TASK 3
        char randomAlpha = (char) ('A' + (int)(Math.random() * 26));
        System.out.println(randomAlpha);

        String randomNum = String.valueOf((int)(Math.random() * 10));
        String randomNum2 = String.valueOf((int)(Math.random() * 10));
        String randomNum3 = String.valueOf((int)(Math.random() * 10));
        String randomNum4 = String.valueOf((int)(Math.random() * 10));
        

        System.out.println("Student ID: " + randomAlpha + randomNum + randomNum2 +randomNum3 + randomNum4); 
        String studentID = randomAlpha + randomNum + randomNum2 +randomNum3 + randomNum4;

        int idLength = studentID.length(); 

        if (idLength == 5 && Character.isLetter(studentID.charAt(0))) {
            boolean digitsOk = true;
        
            // check if characters 1–4 (the rest) are digits
            for (int i = 1; i < 5; i++) {
                if (!Character.isDigit(studentID.charAt(i))) {
                    digitsOk = false;
                    break;
                }
            }
        
            if (digitsOk) {
                System.out.println("ID OK");
            } else {
                System.out.println("Invalid ID: last 4 must be digits");
            }
        } else {
            System.out.println("Invalid ID: must start with a letter and be 5 characters long");
        }
        
        
        //Task 4
        System.out.println("Enter your name: ");
        String name = scanner.next();

        char firstLetter = name.charAt(0);
        System.out.println("First letter of name: " + firstLetter);
        // char firstLetter = scanner.nextLine();
        char baseCode = (char)('A' + (firstLetter - 'A' + 2) % 26);
        System.out.println("Base code: " + baseCode);

        char Last1 =  studentID.charAt(3);
        char Last2 =  studentID.charAt(4);
        System.out.println("Last 2 digits of ID: " + Last1 + Last2);
        String lastDigits = String.valueOf(Last2) + String.valueOf(Last1);

        String displayCode = firstLetter + lastDigits + Math.round(bmi);
        System.out.println("Display code: " + displayCode);

        //summary 
        if (service == "Triage Desk") {
            System.out.println("Summary " + service + "| ID = " + studentID  + "|BMI = " + Math.round(bmi) + "| Code = " + displayCode);
        } else {
            System.out.println("Summary " + service + "| ID = " + studentID  + "| Code = " + displayCode);
        }
        scanner.close();
    }
}