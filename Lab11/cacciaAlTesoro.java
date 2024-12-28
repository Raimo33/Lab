boolean cacciaAlTesoro(char[][] matrix)
{
  if (matrix == null || matrix[0] == null)
    return false;
  int n = matrix.length;
  int m = matrix[0].length;
  if (n == 0 || m == 0)
    return false;
  if (matrix[m-1][n-1] != 'X')
    return false;
  
  return incamminati(matrix, 0, 0, m, n);
}

boolean incamminati(char[][] matrix, int x, int y, int m, int n)
{
  x = (x + m) % m;
  y = (y + n) % n;
  switch (matrix[x][y])
  {
    case 'X':
      return true;
    case 'A':
      return incamminati(matrix, x - 1, y, m, n);
    case 'B':
      return incamminati(matrix, x + 1, y, m, n);
    case 'S':
      return incamminati(matrix, x, y - 1, m, n);
    case 'D':
      return incamminati(matrix, x, y + 1, m, n);
    case '?':
      return (incamminati(matrix, x - 1, y, m, n) || incamminati(matrix, x + 1, y, m, n) || incamminati(matrix, x, y - 1, m, n) || incamminati(matrix, x, y + 1, m, n));
    case 'T':
    default:
      return false;
  }
}