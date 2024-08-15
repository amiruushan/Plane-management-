import java.util.*;
public class w2053788_PlaneManagement {
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

        // person object
        Person person = new Person(person_name, person_surname, person_email);
        // ticket object
        Ticket ticket1 = new Ticket(row_letter, seat_number, seat_price, person);

        boolean seatBookedOrNot = false; // to avoid saving informations again if seat is already booked

        if(row_letter.equals("A") && seat_number <= seat_management[0].length){
            if (seat_management[0][seat_number-1] == 0){
                seat_management[0][seat_number-1] = 1;
                System.out.println("\nSeat booked successfully\n");
                seatBookedOrNot = true;
            }else{
                System.out.println("\nSeat already booked\n");
            }
        }else if(row_letter.equals("B") && seat_number <= seat_management[1].length){
            if (seat_management[1][seat_number-1] == 0){
                seat_management[1][seat_number-1] = 1;
                System.out.println("\nSeat booked successfully\n");
                seatBookedOrNot = true;
            }else{
                System.out.println("\nSeat already booked\n");
            }
        }else if(row_letter.equals("C") && seat_number <= seat_management[2].length){
            if (seat_management[2][seat_number-1] == 0){
                seat_management[2][seat_number-1] = 1;
                System.out.println("\nSeat booked successfully\n");
                seatBookedOrNot = true;
            }else{
                System.out.println("\nSeat already booked\n");
            }
        }else if(row_letter.equals("D") && seat_number <= seat_management[3].length){
            if (seat_management[3][seat_number-1] == 0){
                seat_management[3][seat_number-1] = 1;
                System.out.println("\nSeat booked successfully\n");
                seatBookedOrNot = true;
            }else{
                System.out.println("\nSeat already booked\n");
            }
        }

        if (seatBookedOrNot){
            ticket_array[a] = ticket1; // adding ticket object to the 'a' index of the ticket array
            ticket1.save(); // saving the ticket information on the text file.
        }
    }


    // method for canceling
    public static void cancel_seat() {
        // Input for the row letter and seat number
        String row_letter = rowLetter();
        int seat_number = seatNumber(String .valueOf(row_letter));

        if(row_letter.equals("A") && seat_number <= seat_management[0].length){
            if(seat_management[0][seat_number - 1] == 1){
                seat_management[0][seat_number - 1] = 0;
                System.out.println("\nSeat cancelled successfully\n");
            }else{
                System.out.println("\nSeat not booked yet\n");
            }
        }else if(row_letter.equals("B") && seat_number <= seat_management[1].length){
            if(seat_management[1][seat_number - 1] == 1){
                seat_management[1][seat_number - 1] = 0;
                System.out.println("\nSeat cancelled successfully\n");
            }else{
                System.out.println("\nSeat not booked yet");
            }
        }else if(row_letter.equals("C") && seat_number <= seat_management[2].length){
            if(seat_management[2][seat_number - 1] == 1){
                seat_management[2][seat_number - 1] = 0;
                System.out.println("\nSeat cancelled successfully\n");
            }else{
                System.out.println("\nSeat not booked yet\n");
            }
        }else if(row_letter.equals("D") && seat_number <= seat_management[3].length){
            if(seat_management[3][seat_number - 1] == 1){
                seat_management[3][seat_number - 1] = 0;
                System.out.println("\nSeat cancelled successfully\n");
            }else{
                System.out.println("\nSeat not booked yet\n");
            }
        }

        // remove ticket from array
        for(int i = 0; i < ticket_array.length; i++){
            if(ticket_array[i] != null && ticket_array[i].getRow().equals(row_letter) && ticket_array[i].getSeat() == seat_number){
                ticket_array[i] = null;
            }
        }

    }


    // method for find first available seat
    public static void find_first_available(){
        int i = 0;
        int j = 0;
        boolean not_found = true;
        while (not_found == true){
            for(i = 0; i < seat_management.length; i++){
                for(j = 0; j < seat_management[i].length; j++){
                    if(seat_management[i][j] == 0){
                        not_found = false;
                        if(i == 0){
                            System.out.println("\nA" + (j + 1) + " is the first available seat\n");
                            break;
                        }else if(i == 1){
                            System.out.println("\nB" + (j + 1) + " is the first available seat\n");
                            break;
                        }else if(i == 2){
                            System.out.println("\nC" + (j + 1) + " is the first available seat\n");
                            break;
                        }else if(i == 3){
                            System.out.println("\nD" + (j + 1) + " is the first available seat\n");
                            break;
                        }
                    }
                }
                if(not_found == false){
                    break; // break from the inner loop if found
                }
            }
            break; // break from the outer loop if found
        }
        if(not_found == true){
            System.out.println("\nAll seats are booked\n");
        }
    }


    // method for show seating plan
    public static void show_seating_plan(){
        for (int i = 0; i < seat_management.length; i++){
            System.out.println();
            for (int j = 0; j < seat_management[i].length; j++){
                if(seat_management[i][j] == 0){
                    System.out.print("O ");
                }else{
                    System.out.print("X ");
                }
            }
        }
        System.out.println("\n");
    }


    // method for print ticket informations and total sales
    public static void print_tickets_info(){

        double total_sales = 0;

        for(int i = 0; i < ticket_array.length; i++){
            if(ticket_array[i] != null){ // check whether there is a ticket or not (available or cancelled)
                System.out.println("Ticket " + (i + 1) + ":");
                ticket_array[i].TicketInfo();
                System.out.println();
                total_sales += ticket_array[i].getPrice();
            }
        }
        System.out.println("\nTotal sales: £" + total_sales + "\n");
    }


    // method for search tickets
    public static void search_ticket(){
        System.out.print("Enter the row letter :");
        String row_letter = sc.nextLine().toUpperCase();
        System.out.print("Enter the seat number :");
        int seat_number = sc.nextInt();

        for(int i = 0; i < ticket_array.length; i++){
            if(ticket_array[i] != null){
                if(ticket_array[i].getRow().equals(row_letter) && ticket_array[i].getSeat() == seat_number){
                    System.out.println("\nSeat booked\n");
                    ticket_array[i].TicketInfo();
                    System.out.println("");
                }else{
                    System.out.println("\nSeat not booked yet\n");
                }
            }
        }
    }

    public static int menuOptions() {
        // menu options
        System.out.println("********************************************************\n\n*                    MENU OPTIONS                      *\n\n********************************************************");
        System.out.println("\n   1) Buy a Seat\n");
        System.out.println("   2) Cancel a Seat\n");
        System.out.println("   3) Find first available seat\n");
        System.out.println("   4) Show seating plan\n");
        System.out.println("   5) Print tickets information and total sales\n");
        System.out.println("   6) Search ticket\n");
        System.out.println("   0) Quit\n");
        System.out.println("********************************************************\n");

        int option = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                // asking for input
                System.out.print("Please select an option : ");
                option = sc.nextInt();
                sc.nextLine();
                if (option < 0 || option > 6) {
                    System.out.println("Invalid option, please try again.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.nextLine(); // consume the invalid input
            }
        }
        return option;
    }


    public static String rowLetter(){
        String row_letter = "";
        boolean inRange = false;

        while(!inRange){
            // Input for the row letter and seat number
            System.out.print("\nEnter the row letter: ");
            row_letter = sc.nextLine().toUpperCase();
            // check whether the row letter is valid
            if(row_letter.equals("A") || row_letter.equals("B") || row_letter.equals("C") || row_letter.equals("D")){
                inRange = true;
            }else{
                System.out.println("\nInvalid row letter\nPlease give a row letter between A and D\n");

            }
        }
        return row_letter;
    }

    public static int seatNumber(String row_letter){
        int seat_number = 0;
        boolean valueErr = false;
        int arrayIndex = 0;

        while(!valueErr){
            try{
                // Input for the row letter and seat number
                System.out.print("\nEnter the seat number: ");
                seat_number = sc.nextInt();
                sc.nextLine();
                if (row_letter.equals("A")){
                    arrayIndex = 0;
                }else if (row_letter.equals("B")){
                    arrayIndex = 1;
                }else if (row_letter.equals("C")){
                    arrayIndex = 2;
                }else if (row_letter.equals("D")){
                    arrayIndex = 3;
                }

                if (seat_number > 0 && seat_number <= seat_management[arrayIndex].length){
                    valueErr = true;
                }else{
                    System.out.println("\nInvalid seat number\nPlease give a seat number between 1 and " + seat_management[arrayIndex].length + "\n");
                }


            }catch (InputMismatchException ex){
                System.out.println("Invalid seat number\nPlease give a integer number\n");
                sc.nextLine();

            }
        }
        return seat_number;
    }
}