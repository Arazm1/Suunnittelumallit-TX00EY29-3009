package A15_Adapter.task.src;

public class Main {
    public static void main(String[] args) {
        
        NewDateInterface newCalendar = new CalendarToNewDateAdapter();

        newCalendar.setDay(2);
        newCalendar.setMonth(4);
        newCalendar.setYear(2026);

        System.out.println("Original date:");
        System.out.println("Day: " + newCalendar.getDay());
        System.out.println("Month: " + newCalendar.getMonth());
        System.out.println("Year: " + newCalendar.getYear());

        System.out.println("Advancing by 2 Weeks.. \n");
        newCalendar.advanceDay(14);


        System.out.println("2 Weeks later..:");
        System.out.println("Day: " + newCalendar.getDay());
        System.out.println("Month: " + newCalendar.getMonth());
        System.out.println("Year: " + newCalendar.getYear());
   
    }    
}
