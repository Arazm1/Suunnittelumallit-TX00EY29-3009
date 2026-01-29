package A3_Composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends Component{
    private List<Component> children = new ArrayList<>();

    public Department(String name){
        super(name);
    }

    public void printData(){
        System.out.println(this.name);
    }

    @Override
    public void add(Component employee){
        this.children.add(employee);
    }

    @Override
    public void remove(Component employee){
        this.children.remove(employee);
    }

    @Override
    public Component getChild(int index){
        return this.children.get(index);
    }

    @Override
    public double getSalary(){
        double total = 0;
        for(Component c : children){
            total += c.getSalary();
        }

        return total;
    }

    @Override
    public String toXML(String space) {
        String xml = space + "<department name=\"" + name + "\">\n";

        for (Component c : children) {
            xml += c.toXML(space + "    ");
        }

        xml += space + "</department>\n";
        return xml;
    }
    
}
