int[] visitaSerpentina(int[][] matrix)
{
  if (matrix == null || matrix[0] == null)
    return null;
  
  int y = 0;
  byte dy = +1;
  int n_cols = matrix[0].length;
  int n_rows = matrix.length;
  int[] res = new int[n_cols];

  for (int i = 0; i < n_cols; i++)
  {
    res[i] = matrix[i][y];
    y += dy;
    if (y == 0 || y == n_rows - 1)
      dy *= -1;
  }
  
  return res;
}