package A3_Composite;

public class Main {
    public static void main(String[] args){

        Component department1 = new Department("Amazon");

        Component employee1 = new Employee("Jim Milton", 100);

        department1.add(employee1);
        department1.printData();
        department1.getSalary();


    }
    
}
