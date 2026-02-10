package A5_Singleton.Task.src;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setFilename("new_log.txt");
        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");
        logger.close();
    }
}
