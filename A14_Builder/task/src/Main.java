package A14_Builder.task.src;


public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingPCBuilder = new GamingComputerBuilder();
        ComputerDirector director1 = new ComputerDirector(gamingPCBuilder);
        director1.constructComputer();
        Computer computer1 = gamingPCBuilder.getComputer();
        System.out.println(computer1);

        ComputerBuilder offComputerBuilder = new OfficeComputerBuilder();
        ComputerDirector director2 = new ComputerDirector(offComputerBuilder);
        director2.constructComputer();
        Computer computer2 = offComputerBuilder.getComputer();
        System.out.println(computer2);



    }
    
}