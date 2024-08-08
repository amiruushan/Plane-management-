import java.util.*;
public class PlaneManagement {
    // 2D array for store seating plan
    public static int[][] seat_management = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };

    public static Ticket[] ticket_array = new Ticket[52]; // array to store ticket objects

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWELCOME TO THE PLANE MANAGEMENT APPLICATION\n");

        boolean quit = false;

        // creating a variable to controll the loop (index of the ticket array) to add all the ticket elements to the array
        int a = 0;
        while (!quit) { // while true loop to run program until quit

            int option = menuOptions();

            switch (option) {
                case 1:
                    buy_seat(a);
                    a++; // incrementing the index
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plan();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_ticket();
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("\nInvalid option, please try again.\n");
                    break;
            }
        }
        sc.close();
    }

    // method for booking
    public static void buy_seat(int a) {
        String row_letter = rowLetter();
        int seat_number = seatNumber(String .valueOf(row_letter));

        // asking person information
        System.out.print("\nEnter your name: ");
        String person_name = sc.nextLine();
        System.out.print("Enter your surname: ");
        String person_surname = sc.nextLine();
        System.out.print("Enter your email: ");
        String person_email = sc.nextLine();

        // calculate the seat price
        double seat_price = 0;
        if(seat_number <= 5){
            seat_price = 200;
        }else if(seat_number <= 9){
            seat_price = 150;
        }else if(seat_number <= 14){
            seat_price = 180;
        }
}

    