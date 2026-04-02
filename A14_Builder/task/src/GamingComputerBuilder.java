package A14_Builder.task.src;

public class GamingComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public GamingComputerBuilder(){
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor(){
        computer.addPart(new Part("Intel Core i7-14700F"));

    }

    @Override
    public void buildRAM(){
        computer.addPart(new Part("32 GB"));
    }

    @Override
    public void buildHardDrive(){
        computer.addPart(new Part("1TB SSD"));
    }

    @Override
    public void buildGraphicsCard(){
        computer.addPart(new Part("RTX 5060"));
    }

    @Override
    public void buildOperatingSystem(){
        computer.addPart(new Part("Windows 11 Home"));
    }

    public Computer getComputer(){
        return this.computer;
    }
}


/*

Processor (CPU): Intel Core i7-14700F or AMD Ryzen 7 7800X3D
RAM size: 16–32 GB
Hard drive: 1 TB SSD (NVMe)
Graphics card: NVIDIA GeForce RTX 4060 / RTX 5060
Operating system: Windows 11 Home*/
