int[][] azzeramentoAdiacenti(int[][] matrix, int r, int c)
{
  if (matrix == null || matrix[0] == null)
    return null;
  
  int n_cols = matrix[0].length;
  int n_rows = matrix.length;

  if (r >= n_rows || r < 0)
    return null;
  if (c >= n_cols || c < 0)
    return null;

  int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
  int[] dc = {-1, 0, 1, 1, 1, 1, 0, -1};
  int new_r;
  int new_c;
  for (int i = 0; i < dr.length; i++)
  {
    new_r = (r + dr[i] + n_rows) % n_rows;
    new_c = (c + dc[i] + n_cols) % n_cols;
    matrix[new_r][new_c] = 0;
  }

  return matrix;
}