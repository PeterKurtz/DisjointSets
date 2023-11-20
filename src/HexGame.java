import java.util.ArrayList;

public class HexGame {
    public String[] grid;
    private DisjointSet colorSet;
    private int size;

    public HexGame(int size){
        this.size = size;
        int boardNum = size*size;
        this.grid = new String[boardNum];
        for (int i = 0; i < boardNum; i++){
            this.grid[i] = "0";
        }
        this.colorSet = new DisjointSet(boardNum + 4);
    }

    public int getSize(){
        return size;
    }

    public void playRed(int option, boolean displayNeighbors) {
        ArrayList<Integer> adjacentCells = getAdjacentCells(option, "R");

        if (displayNeighbors) {
            System.out.print("Cell " + option + ": [ ");
            for (int x = 0; x < adjacentCells.size(); x++){
                System.out.print(adjacentCells.get(x) + " ");
            }
            System.out.println("]");
        }

    }

    public void playBlue(int option, boolean displayNeighbors) {
        ArrayList<Integer> adjacentCells = getAdjacentCells(option, "B");

        if (displayNeighbors) {
            System.out.print("Cell " + option + ": [ ");
            for (int x = 0; x < adjacentCells.size(); x++){
                System.out.print(adjacentCells.get(x) + " ");
            }
            System.out.println("]");
        }

    }

    private ArrayList<Integer> getAdjacentCells(int position, String player) {
        ArrayList<Integer> adjacentCells = new ArrayList<Integer>();
        if (player.equals("R")){
            if (position == 1) {
                adjacentCells.add((size*size) + 1);
                adjacentCells.add(size + 1);
                adjacentCells.add(2);
            }
            else if (position == size) {
                adjacentCells.add((size * size) + 1);
                adjacentCells.add(position + size);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + size - 1);
            }
            else if (position == (size*size - size + 1)) {
                adjacentCells.add(position - size);
                adjacentCells.add(position - size + 1);
                adjacentCells.add(position + 1);
                adjacentCells.add((size*size) + 2);
            }
            else if (position == (size*size)) {
                adjacentCells.add((size*size) + 2);
                adjacentCells.add(position - size);
                adjacentCells.add(position - 1);
            }
            else if ((position % 11) == 0) {
                adjacentCells.add(position - size);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + size - 1);
                adjacentCells.add(position + size);
            }
            else if (position % 11 == 1) {
                adjacentCells.add(position - size);
                adjacentCells.add(position - size + 1);
                adjacentCells.add(position + 1);
                adjacentCells.add(position + size - 1);
            }
            else if(position <= size) {
                adjacentCells.add(position - 1);
                adjacentCells.add(position + 1);
                adjacentCells.add(position + size - 1);
                adjacentCells.add(position + size);
                adjacentCells.add((size*size) + 1);
            }
            else if((((size*size) - size + 1) < position) && (position <= (size*size))) {
                adjacentCells.add(position - size);
                adjacentCells.add(position - size + 1);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + 1);
                adjacentCells.add((size*size) + 2);
            }
            else {
                adjacentCells.add(position - 11);
                adjacentCells.add(position - 10);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + 1);
                adjacentCells.add(position + 10);
                adjacentCells.add(position + 11);
            }
        }

        if (player.equals("B")){
            if (position == 1) {
                adjacentCells.add((size*size) + 3);
                adjacentCells.add(size + 1);
                adjacentCells.add(2);
            }
            else if (position == size) {
                adjacentCells.add((size * size) + 4);
                adjacentCells.add(position + size);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + size - 1);
            }
            else if (position == (size*size - size + 1)) {
                adjacentCells.add(position - size);
                adjacentCells.add(position - size + 1);
                adjacentCells.add(position + 1);
                adjacentCells.add((size*size) + 3);
            }
            else if (position == (size*size)) {
                adjacentCells.add((size*size) + 4);
                adjacentCells.add(position - size);
                adjacentCells.add(position - 1);
            }
            else if ((position % 11) == 0) {
                adjacentCells.add(position - size);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + size - 1);
                adjacentCells.add(position + size);
                adjacentCells.add((size*size) +4);
            }
            else if (position % 11 == 1) {
                adjacentCells.add((size*size) + 3);
                adjacentCells.add(position - size);
                adjacentCells.add(position - size + 1);
                adjacentCells.add(position + 1);
                adjacentCells.add(position + size);
            }
            else if(position <= size) {
                adjacentCells.add(position - 1);
                adjacentCells.add(position + 1);
                adjacentCells.add(position + size - 1);
                adjacentCells.add(position + size);
            }
            else if((((size*size) - size + 1) < position) && (position <= (size*size))) {
                adjacentCells.add(position - size);
                adjacentCells.add(position - size + 1);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + 1);
            }
            else {
                adjacentCells.add(position - 11);
                adjacentCells.add(position - 10);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + 1);
                adjacentCells.add(position + 10);
                adjacentCells.add(position + 11);
            }
        }

        return adjacentCells;
    }




}
