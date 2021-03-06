package com.company.maze;

import java.util.Arrays;
import java.util.Collections;

public class Maze {
    public static final int WALL = 1;
    public static final int PASSAGE = 0;
    public static final int[][] DIRECTIONS = new int[][]{
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0},
    };

    private int size;
    private int[][] grid;

    public Maze(int size) {
        this.size = size;

        this.grid = new int[size][size];

        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                this.grid[i][j] = WALL;
            }
        }

        this.generateMaze(new int[]{0, 0});
    }

    public int[][] generateMaze(int[] point) {
        int[][] dirs = DIRECTIONS;

        Collections.shuffle(Arrays.asList(dirs));

        for (int[] dir : dirs) {
            int[] newPoint = new int[]{point[0] + dir[0], point[1] + dir[1]};

            if (isGoodPath(this.grid, newPoint)) {
                this.grid[newPoint[0]][newPoint[1]] = PASSAGE;
                generateMaze(newPoint);
            }
        }

        return grid;


    }

    public boolean isGoodPath(int[][] grid, int[] point) {
//
        if (!isPointInsideMaze(grid, point)){
            return false;

        }

        int[][] dirs = DIRECTIONS;

        int countPath = 0;
        for (int[] dir : dirs) {
            int[] newPoint = new int[]{point[0] + dir[0], point[1] + dir[1]};
            if (isPointInsideMaze(grid, newPoint)
                    && grid[newPoint[0]][newPoint[1]] == PASSAGE
                    ) {
                countPath++;
            }

        }

        if (countPath > 1) {
            return false;
        }
        return true;

    }

    public boolean isPointInsideMaze(int[][] grid, int[] point) {
        if (point[0] > 0 && point[0] < grid.length &&
                point[1] > 0 && point[1] < grid[0].length){
            return true;
        }
        return false;

    }

    public void print2d() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                //ternary operator
                System.out.print((this.grid[i][j] == WALL ? "#" : ".") + " ");
            }
            System.out.println();
        }
    }

}

