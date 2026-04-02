package A14_Builder.task.src;

public class OfficeComputerBuilder implements ComputerBuilder{


    private Computer computer;

    public OfficeComputerBuilder(){
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor(){
        computer.addPart(new Part("AMD Ryzen 5"));

    }

    @Override
    public void buildRAM(){
        computer.addPart(new Part("8 GB"));
    }

    @Override
    public void buildHardDrive(){
        computer.addPart(new Part("256GB"));
    }

    @Override
    public void buildGraphicsCard(){
        computer.addPart(new Part("Intel UHD"));
    }

    @Override
    public void buildOperatingSystem(){
        computer.addPart(new Part("Windows 11 Pro"));
    }

    public Computer getComputer(){
        return this.computer;
    }
}


/*
Processor (CPU): Intel Core i5 (12th–14th gen) or AMD Ryzen 5
RAM size: 8–16 GB
Hard drive: 512 GB SSD
Graphics card: Integrated graphics (Intel UHD / AMD Radeon iGPU)
Operating system: Windows 11 Pro
*/