public class GenerateCodeCommand implements Command {
    private PixelGrid grid;

    public GenerateCodeCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        int[][] g = grid.getGrid();

        System.out.println("int[][] pixelArt = {");

        for (int i = 0; i < 8; i++) {
            System.out.print("    {");
            for (int j = 0; j < 8; j++) {
                System.out.print(g[i][j]);
                if (j < 7) System.out.print(", ");
            }
            System.out.println("}" + (i < 7 ? "," : ""));
        }

        System.out.println("};");
    }
}