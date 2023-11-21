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

        ArrayList<Integer> neighborCells = getAdjacentCells(option, "R");
        int adjOption = option - 1;
        int topNum = size*size;//top is 121
        int botNum = size*size + 1;//bottom 123

        if (grid[adjOption].equals("0")){
            grid[adjOption] = "R";
            for (int neighbor : neighborCells) {
                int adjNeighbor = neighbor - 1;
                if ((adjNeighbor == topNum) || (adjNeighbor == botNum)) {
                    colorSet.union(adjOption, adjNeighbor);
                }
                else if (grid[adjNeighbor].equals("R")) {
                    colorSet.union(adjOption, adjNeighbor);
                }
            }
        }

        if (displayNeighbors) {
            System.out.print("Cell " + option + ": [ ");
            for (int x = 0; x < neighborCells.size(); x++){
                System.out.print(neighborCells.get(x) + " ");
            }
            System.out.println("]");
        }

    }

    public void playBlue(int option, boolean displayNeighbors) {
        ArrayList<Integer> neighborCells = getAdjacentCells(option, "B");
        int adjOption = option - 1;
        int leftNum = size*size + 2;//Left is 123
        int rightNum = size*size + 3;//bottom 123

        if (grid[adjOption].equals("0")){
            grid[adjOption] = "B";
            for (int neighbor : neighborCells) {
                int adjNeighbor = neighbor - 1;
                if ((adjNeighbor == leftNum) || (adjNeighbor == rightNum)) {
                    colorSet.union(adjOption, adjNeighbor);
                }
                else if (grid[adjNeighbor].equals("B")) {
                    colorSet.union(adjOption, adjNeighbor);
                }
            }
        }

        if (displayNeighbors) {
            System.out.print("Cell " + option + ": [ ");
            for (int x = 0; x < neighborCells.size(); x++){
                System.out.print(neighborCells.get(x) + " ");
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
                adjacentCells.add(position + size);
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
