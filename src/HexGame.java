import java.util.ArrayList;

public class HexGame {
    public String[] grid;
    private DisjointSet colorSet;
    private int size;
    private int topNum;
    private int bottomNum;
    private int leftNum;
    private int rightNum;

    public HexGame(int size){
        this.size = size;
        int boardNum = size*size;
        this.grid = new String[boardNum];
        for (int i = 0; i < boardNum; i++){
            this.grid[i] = "0";
        }
        this.colorSet = new DisjointSet(boardNum + 4);
        this.leftNum = size*size + 2;
        this.rightNum = size*size + 3;
        this.topNum = size*size;
        this.bottomNum = size*size + 1;

    }

    public int getSize(){
        return size;
    }

    public void playRed(int option, boolean displayNeighbors) {

        ArrayList<Integer> neighborCells = getAdjacentCells(option, "R");
        int adjOption = option - 1;

        if (grid[adjOption].equals("0")){
            grid[adjOption] = "R";
            for (int neighbor : neighborCells) {
                int adjNeighbor = neighbor - 1;
                if ((adjNeighbor == topNum) || (adjNeighbor == bottomNum)) {
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

    public boolean isWinner(){
        boolean isWinner;
        if (colorSet.find(bottomNum) == colorSet.find(topNum)) {
            isWinner = true;
        }
        else if (colorSet.find(rightNum) == colorSet.find(leftNum)) {
            isWinner = true;
        }
        else {
            isWinner = false;
        }


        return isWinner;
    }

    private ArrayList<Integer> getAdjacentCells(int position, String player) {
        ArrayList<Integer> adjacentCells = new ArrayList<>();
        if (player.equals("R")){
            if (position == 1) {
                adjacentCells.add(topNum + 1);
                adjacentCells.add(size + 1);
                adjacentCells.add(2);
            }
            else if (position == size) {
                adjacentCells.add(topNum + 1);
                adjacentCells.add(position + size);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + size - 1);
            }
            else if (position == (size*size - size + 1)) {
                adjacentCells.add(position - size);
                adjacentCells.add(position - size + 1);
                adjacentCells.add(position + 1);
                adjacentCells.add(bottomNum + 1);
            }
            else if (position == (size*size)) {
                adjacentCells.add(bottomNum + 1);
                adjacentCells.add(position - size);
                adjacentCells.add(position - 1);
            }
            else if ((position % size) == 0) {
                adjacentCells.add(position - size);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + size - 1);
                adjacentCells.add(position + size);
            }
            else if (position % size == 1) {
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
                adjacentCells.add(topNum + 1);
            }
            else if(((topNum - size + 1) < position) && (position <= topNum)) {
                adjacentCells.add(position - size);
                adjacentCells.add(position - size + 1);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + 1);
                adjacentCells.add(bottomNum + 1);
            }
            else {
                adjacentCells.add(position - size);
                adjacentCells.add(position - size + 1);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + 1);
                adjacentCells.add(position + size - 1);
                adjacentCells.add(position + size);
            }
        }

        if (player.equals("B")){
            if (position == 1) {
                adjacentCells.add(leftNum + 1);
                adjacentCells.add(size + 1);
                adjacentCells.add(2);
            }
            else if (position == size) {
                adjacentCells.add(rightNum + 1);
                adjacentCells.add(position + size);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + size - 1);
            }
            else if (position == (size*size - size + 1)) {
                adjacentCells.add(position - size);
                adjacentCells.add(position - size + 1);
                adjacentCells.add(position + 1);
                adjacentCells.add(leftNum + 1);
            }
            else if (position == (size*size)) {
                adjacentCells.add(rightNum + 1);
                adjacentCells.add(position - size);
                adjacentCells.add(position - 1);
            }
            else if ((position % size) == 0) {
                adjacentCells.add(position - size);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + size - 1);
                adjacentCells.add(position + size);
                adjacentCells.add(rightNum + 1);
            }
            else if (position % size == 1) {
                adjacentCells.add(leftNum + 1);
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
                adjacentCells.add(position - size);
                adjacentCells.add(position - size + 1);
                adjacentCells.add(position - 1);
                adjacentCells.add(position + 1);
                adjacentCells.add(position + size - 1);
                adjacentCells.add(position + size);
            }
        }

        return adjacentCells;
    }




}
