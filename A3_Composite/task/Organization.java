package A3_Composite;

import java.util.ArrayList;
import java.util.List;

public class Organization extends Component{
    private List<Component> children = new ArrayList<>();

    public Organization(String name){
        super(name);
    }

    public void printData(){
        System.out.println(this.name);
    }

    @Override
    public void add(Component department){
        this.children.add(department);
    }

    @Override
    public void remove(Component department){
        this.children.remove(department);
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
    public String toXML(String space){
        String xml = space + "<organization name=\"" + this.name + "\">\n";
        for(Component c : children){
            xml += c.toXML(space + " ");
        }
        xml += space + "</organization>\n";
        return xml;
    }
}
