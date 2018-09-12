import java.util.*;

public class nqueens
{

  private static int board_size;
  private static int[] board;
  private static final int IMPOSSIBLE = -1;
  // private static int total = 0;

  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    // nqueens n = new nqueens();
    // System.out.printf("Getting board size... ");
    board_size = scan.nextInt();
    // System.out.println("Board size is " + board_size);
    board = new int[board_size];
    for(int i = 0; i < board_size; i++)
      board[i] = IMPOSSIBLE;
    // printBoard();
    // total = solutionCounter();
    if(backTrack(0))
      printBoard();
    else
      System.out.println("No solution found.");
    // System.out.println("The total number of solutions found is " + total);
    System.out.println(Arrays.toString(board));
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
        System.out.printf(" %c ", (board[j] != i) ? ' ' : 'Q');
        System.out.print("|");
      }
      System.out.println();
      printLine();
    }
  }

  // public static boolean isSafe(int ind)
  // {
  //   if(ind < 0 || ind >= board_size)
  //     return true;
  //   // test row and col
  //   for(int i = 0; i < board_size; i++) {
  //     if(board[i] != IMPOSSIBLE && i != ind && board[i] == board[ind])
  //       return false;
  //   // test backward diagonal
  //     if(board[i] != IMPOSSIBLE && i != ind && ((i - board[i]) == (ind - board[ind])))
  //       return false;
  //   // test forward diagonal
  //     if(board[i] != IMPOSSIBLE && i != ind && ((i + board[i]) == (ind + board[ind])))
  //       return false;
  //   }
  //   return true;
  // }

  private static boolean isSafe(int curCol)
  {
    if(curCol < 0 || curCol >= board_size)
      return true;
    for(int i = 0; i < board_size; i++)
    {
      if(board[i] != IMPOSSIBLE && i != curCol && board[i] == board[curCol])
        return false;
      if(board[i] != IMPOSSIBLE && i != curCol &&
        (((i + board[i]) == (curCol + board[curCol])) ||
        ((i - board[i]) == (curCol - board[curCol]))))
        return false;
      // if(i != IMPOSSIBLE && i != curCol && ((i - board[i]) == (curCol - board[curCol])))
      //   return false;
    }
    return true;
  }

  private static boolean backTrack(int col)
  {
    if(col == board_size)
      return true;
    for(int row = 0; row < board_size; row++)
    {
      board[col] = row;
      if(isSafe(col))
        if(backTrack(col+1))
          return true;

    }
    board[col] = IMPOSSIBLE;
    return false;
  }

  // public static int solutionCounter()
  // {
  //   int sum = 0;
  //   if(board_size <= 0)
  //     return 0;
  //   // for(int i = 0; i < board_size; i++)
  //     sum += backTrack();
  //   return sum;
  // }
}
