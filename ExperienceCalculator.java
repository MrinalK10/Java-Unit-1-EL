import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class ExperienceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your date of joining (yyyy-mm-dd): ");
        String dateOfJoiningInput = scanner.nextLine();

        LocalDate dateOfJoining = LocalDate.parse(dateOfJoiningInput);
        LocalDate currentDate = LocalDate.now();
        
        Period period = Period.between(dateOfJoining, currentDate);

        System.out.println("Total experience: " + period.getYears() + " years, " +
                           period.getMonths() + " months, " + period.getDays() + " days.");

        scanner.close();
    }
}
