import java.util.Scanner;

class Appointment {
    private String patientName, patientId, doctorName, appointmentType, appointmentStatus = "Confirmed";
    private double consultationFee;

    public Appointment(String pName, String pId, String dName, double fee) {
        this.patientName = pName; this.patientId = pId; this.doctorName = dName;
        this.appointmentType = "General"; setFee(fee);
    }

    public Appointment(String pName, String pId, String dName, String type, double fee) {
        this.patientName = pName; this.patientId = pId; this.doctorName = dName;
        this.appointmentType = type; setFee(fee);
    }

    public void setFee(double fee) {
        this.consultationFee = (fee < 0) ? 500.0 : fee;
    }

    public String getPatientName() { return patientName; }
    public double getConsultationFee() { return consultationFee; }

    public void displayAppointment() {
        System.out.printf("Patient Name       : %s\n", patientName.toUpperCase());
        System.out.printf("Patient ID         : %s\n", patientId);
        System.out.printf("Doctor Name        : %s\n", doctorName.toUpperCase());
        System.out.printf("Appointment Type   : %s\n", appointmentType.toUpperCase());
        System.out.printf("Consultation Fee   : Rs. %.2f\n", consultationFee);
        System.out.printf("Appointment Status : %s\n\n", appointmentStatus);
    }

    public void displayAppointment(String msg) {
        System.out.println("--- " + msg + " ---");
        displayAppointment();
    }

    public boolean comparePatientName(String name) {
        return this.patientName.equalsIgnoreCase(name.trim());
    }
}

public class ClinicManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Enter Details for Patient 1 ---");
        System.out.print("Patient Name: "); String name1 = sc.nextLine();
        System.out.print("Patient ID: "); String id1 = sc.nextLine();
        System.out.print("Doctor Name: "); String doc1 = sc.nextLine();
        System.out.print("Consultation Fee: "); double fee1 = sc.nextDouble(); sc.nextLine();

        Appointment a1 = new Appointment(name1, id1, doc1, fee1);

        System.out.println("\n--- Enter Details for Patient 2 ---");
        System.out.print("Patient Name: "); String name2 = sc.nextLine();
        System.out.print("Patient ID: "); String id2 = sc.nextLine();
        System.out.print("Doctor Name: "); String doc2 = sc.nextLine();
        System.out.print("Appointment Type (e.g., Specialist): "); String type2 = sc.nextLine();
        System.out.print("Consultation Fee: "); double fee2 = sc.nextDouble(); sc.nextLine();

        Appointment a2 = new Appointment(name2, id2, doc2, type2, fee2);

        System.out.print("\nEnter a name to verify against Patient 1: ");
        String verifyName = sc.nextLine();
        String verificationResult = a1.comparePatientName(verifyName) ? "Names Match" : "Names Do Not Match";

        System.out.println("\n========== CLINIC APPOINTMENT SYSTEM ==========\n");
        a1.displayAppointment();
        a2.displayAppointment();

        double totalConsultation = a1.getConsultationFee() + a2.getConsultationFee();

        System.out.println("---------- APPOINTMENT SUMMARY ----------");
        System.out.println("Total Appointments : 2");
        System.out.printf("Total Consultation : Rs. %.2f\n\n", totalConsultation);
        System.out.println("Patient Verification: " + verificationResult);
        System.out.println("=============================================");
        sc.close();
    }
}
