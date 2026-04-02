package A14_Builder.task.src;

public interface ComputerBuilder {
    void buildProcessor();
    void buildRAM();
    void buildHardDrive();
    void buildGraphicsCard();
    void buildOperatingSystem();
    Computer getComputer();   
}
