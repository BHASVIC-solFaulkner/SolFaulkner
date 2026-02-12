public class Grid {
    private String[][] grid;
    public Grid(int width, int height) {
        grid = new String[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = " ";
            }
        }
    }
    public void printGrid() {
        for (String[] strings : grid) {
            for (String string : strings) {
                System.out.print("|"+string);
            }
            System.out.println("|");
        }
        System.out.println();
    }
    public String[][] getGrid() {
        return grid;
    }
    public void setPosition(int x, int y, String s) {
        grid[y-1][x-1] = s;
    }
    public boolean full(){
        int count = 0;
        int max = grid.length*grid[0].length;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (!grid[y][x].equals(" ")) {
                    count++;
                }
            }
        }
        return count >= max;
    }
}
