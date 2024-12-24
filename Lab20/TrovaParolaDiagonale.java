public class TrovaParolaDiagonale 
{

  public static boolean trovaParolaDiagonale(char[][] matrix, char[] word) 
  {
    if (matrix == null || word == null) 
      return false;
    if (word.length <= 0) 
      return true;
    
    int n_rows = matrix.length;
    int n_cols = matrix[0].length;

    if (n_rows <= 0 || n_cols <= 0) 
      return false;

    int longest_diagonal = Math.min(n_rows, n_cols);
    if (word.length > longest_diagonal) 
      return false;

    for (int x = 0; x < n_cols; x++) 
    {
      for (int y = 0; y < n_rows; y++) 
      {
        if (check_diagonal(matrix, word, x, y, n_rows, n_cols, (byte)(RIGHT | DOWN), 0) ||
            check_diagonal(matrix, word, x, y, n_rows, n_cols, (byte)(LEFT  | DOWN), 0)  ||
            check_diagonal(matrix, word, x, y, n_rows, n_cols, (byte)(RIGHT | UP), 0)   ||
            check_diagonal(matrix, word, x, y, n_rows, n_cols, (byte)(LEFT  | UP), 0))
          return true;
      }
    }
    return false;
  }

  private static boolean check_diagonal(char[][] matrix, char[] word, int x, int y, int n_rows, int n_cols, byte direction, int index)
  {
    if (index >= word.length)
      return true;
    
    int remaining = word.length - index;
    int steps_x = (direction & RIGHT) != 0 ? (n_cols - x) : (x + 1);
    int steps_y = (direction & DOWN)  != 0 ? (n_rows - y) : (y + 1);
    int diagonal_length = Math.min(steps_x, steps_y);

    if (remaining > diagonal_length)
      return false;
    if (x < 0 || x >= n_cols || y < 0 || y >= n_rows)
      return false;
    if (word[index] != matrix[y][x])
      return false;
      
    int dx = (direction & RIGHT) != 0 ? 1 : -1;
    int dy = (direction & DOWN)  != 0 ? 1 : -1;

    return check_diagonal(matrix, word, x + dx, y + dy, n_rows, n_cols, direction, index + 1);
  }

  private static final byte RIGHT = 0b0001;
  private static final byte LEFT  = 0b0010;
  private static final byte DOWN  = 0b0100;
  private static final byte UP    = 0b1000;

}