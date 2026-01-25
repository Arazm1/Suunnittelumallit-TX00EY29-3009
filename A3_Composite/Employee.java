package A3_Composite;

public class Employee extends Component{

    private double salary;

    public Employee(String name, double salary){
        super(name);
        this.salary = salary;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public double getSalary(){
        return this.salary;
    }

    public String toXML(String data){
        throw new UnsupportedOperationException("Not supported in leaf.");
    }
}
