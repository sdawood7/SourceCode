import java.util.*;
import java.io.*;

public class sudoku
{

  public static final int board_size = 9;
  public static final int IMPOSSIBLE = 0;
  public static int[][] board = new int[9][9];

  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter a sudoku board to solve");
    for(int i = 0; i < board_size; i++)
      for(int j = 0; j < board_size; j++)
        board[i][j] = scan.nextInt();
    if(solve(0,0))
    {
      printBoard();
    }
    else
      fail();
  }

  public static void printLine()
  {
    for(int i = 0; i < board_size; i++)
      System.out.printf("+---");
    System.out.printf("+\n");
  }

  public static void printBoard()
  {
    printLine();
    for(int i = 0; i < board_size; i++)
    {
      System.out.print("|");
      for(int j = 0; j < board_size; j++)
      {
        System.out.printf(" %d ", board[i][j]);
        System.out.print("|");
      }
      System.out.println();
      printLine();
    }
  }

  public static void fail()
  {
    System.out.println("Failed to solve the board, check input.");
    System.exit(1);
  }

  public static boolean checkCol(int col)
  {
    boolean[] possibleDigits = new boolean[board_size];
    for(int i = 0; i < board_size; i++)
    {
      if(board[i][col] != IMPOSSIBLE)
        if(!possibleDigits[board[i][col]-1])
          possibleDigits[board[i][col]-1] = true;
        else
          return false;
    }
    return true;
  }

  public static boolean checkRow(int row)
  {
    boolean[] possibleDigits = new boolean[board_size];
    for(int i = 0; i < board_size; i++)
    {
      if(board[row][i] != IMPOSSIBLE)
        if(!possibleDigits[board[row][i]-1])
          possibleDigits[board[row][i]-1] = true;
        else
          return false;
    }
    return true;
  }

  public static boolean checkNonet(int row, int col)
  {
    int NonRow = row/3;
    int NonCol = col/3;
    boolean[] possibleDigits = new boolean[board_size];
    for(int i = 0; i < board_size/3; i++)
    {
      for(int j = 0; j < board_size/3; j++)
      {
        if(board[(NonRow * 3) + i][(NonCol * 3) + j] != IMPOSSIBLE)
          if(!possibleDigits[board[(NonRow * 3) + i][(NonCol * 3) + j] -1])
            possibleDigits[board[(NonRow * 3) + i][(NonCol * 3) + j] -1] = true;
          else
            return false;
      }
    }
    return true;

  }

  public static boolean valid(int row, int col)
  {
    if(checkNonet(row, col) && checkRow(row) &&
      checkCol(col))
      return true;
    return false;
  }

  public static boolean solve(int row, int col)
  {
    if(row == board_size)
      return true;
    if(col == board_size)
      return solve(row+1, 0);
    if(board[row][col] != IMPOSSIBLE)
      return solve(row, col+1);
    for(int i = 1; i <= board_size; i++)
    {
      board[row][col] = i;
      if(valid(row, col))
        if(solve(row, col+1))
          return true;
    }
    board[row][col] = IMPOSSIBLE;
    return false;
  }

}

/*

0 0 0 8 0 0 0 0 0
0 0 8 3 7 5 0 1 0
0 3 0 9 0 0 2 0 0
3 0 6 0 0 0 0 4 1
0 0 0 0 0 0 0 0 0
7 2 0 0 0 0 6 0 9
0 0 1 0 0 7 0 8 0
0 6 0 5 4 8 1 0 0
0 0 0 0 0 9 0 0 0


9 0 0 0 4 0 0 0 3
0 3 0 0 0 2 0 0 1
4 0 2 1 0 8 0 7 0
0 0 0 0 2 7 0 0 0
0 0 3 0 0 0 7 0 0
0 0 0 6 9 0 0 0 0
0 9 0 3 0 6 1 0 2
3 0 0 2 0 0 0 5 0
1 0 0 0 5 0 0 0 6


0 5 0 0 0 0 4 3 0
1 0 7 0 0 0 0 0 0
0 0 3 0 0 5 0 0 2
0 1 5 9 4 2 0 0 0
0 0 9 0 0 0 2 0 0
0 0 0 8 1 3 9 6 0
2 0 0 1 0 0 8 0 0
0 0 0 0 0 0 5 0 1
0 7 1 0 0 0 0 2 0


*/
