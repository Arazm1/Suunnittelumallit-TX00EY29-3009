package A3_Composite.task.src;

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

    @Override
    public String toXML(String space){
        //throw new UnsupportedOperationException("Not supported in leaf.");
        return space + "<employee name=\"" + name +
            "\" salary=\"" + salary + "\" />\n";
    }
}
