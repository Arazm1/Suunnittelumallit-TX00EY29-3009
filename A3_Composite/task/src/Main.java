package A3_Composite;

public class Main {
    public static void main(String[] args){

        Organization organization1 = new Organization("Amazon");

        Component department1 = new Department("Amazon Delivery");
        Component department2 = new Department("Amazon Warehouse");

        Component employee1 = new Employee("Jim Milton", 100);
        Component employee2 = new Employee("Roger Milton", 100);
        Component employee3 = new Employee("James Smith", 150);

        //System.out.println(employee1.toXML(""));

        //department1.printData();
        department1.add(employee1);
        department1.add(employee2);
        System.out.println(department1.name + "'s total salary: " + department1.getSalary());

        department2.add(employee3);
        System.out.println(department2.name + "'s total salary: " + department2.getSalary());
        
        System.out.println(department1.toXML(""));

        organization1.add(department1);
        organization1.add(department2);
        System.out.println(organization1.name + "'s total salary: " + organization1.getSalary());

        System.out.println(organization1.toXML(""));
        



        

    }
    
}
