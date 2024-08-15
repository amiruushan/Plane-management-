import java.io.*;
public class Ticket {

    private String row;
    private int seat;
    private double price;
    private Person Person;


    Ticket(String row, int seat, double price, Person Person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.Person = Person;
    }
    // all getters and setters
    public String getRow() {
        return row;
    }
    public void setRow(String row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return Person;
    }
    public void setPerson(Person Person) {
        this.Person = Person;
    }

    // method for printing ticket information
    public void TicketInfo(){
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " + price);
        Person.PersonInfo();
    }

    public void save(){
        String FileName = row + String.valueOf(seat)+".txt";

        try{
            FileWriter myWritter = new FileWriter(FileName);

            myWritter.write("TICKET INFORMATION\n\n");

            myWritter.write("Row: " + getRow() + "\n");
            myWritter.write("Seat: " + getSeat() + "\n");
            myWritter.write("Price: " + getPrice() + "\n");
            myWritter.write("Name: " + Person.getName() + "\n");
            myWritter.write("Surname: " + Person.getSurname() + "\n");
            myWritter.write("Email: " + Person.getEmail() + "\n");

            myWritter.close();

        } catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

