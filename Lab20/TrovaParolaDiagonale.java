byte DX    = 0b0001;
byte DOWN  = 0b0100;
byte SX    = 0b0010;
byte UP    = 0b1000;

boolean trovaParolaDiagonale(char[][] M, char[] parola) 
{
  if (M == null || parola == null) 
    return false;
  if (parola.length <= 0) 
    return false;
  
  int m = M.length;
  int n = M[0].length;

  if (m <= 0 || n <= 0) 
    return false;

  int diag_max = Math.min(m, n);
  if (parola.length > diag_max) 
    return false;

  for (int x = 0; x < n; x++) 
  {
    for (int y = 0; y < m; y++) 
    {
      if (controlla_diagonale(M, parola, x, y, m, n, (byte)(DX | DOWN), 0, 0, 0) ||
          controlla_diagonale(M, parola, x, y, m, n, (byte)(SX | DOWN), 0, 0, 0) ||
          controlla_diagonale(M, parola, x, y, m, n, (byte)(DX | UP), 0, 0, 0)   ||
          controlla_diagonale(M, parola, x, y, m, n, (byte)(SX | UP), 0, 0, 0))
        return true;
    }
  }
  return false;
}

boolean controlla_diagonale(char[][] M, char[] parola, int x, int y, int m, int n, byte direzione, int i, int dx, int dy)
{
  if (i == parola.length)
    return true;
  
  if (i == 0)
  {
    int remaining = parola.length - i;
    int passi_x = (direzione & DX)   != 0 ? (n - x) : (x + 1);
    int passi_y = (direzione & DOWN) != 0 ? (m - y) : (y + 1);
    int diag_max = Math.min(passi_x, passi_y);

    if (remaining > diag_max)
      return false;
    
    dx = (direzione & DX)   != 0 ? 1 : -1;
    dy = (direzione & DOWN) != 0 ? 1 : -1;
  }
  if (x < 0 || x >= n || y < 0 || y >= m)
    return false;
  if (parola[i] != M[y][x])
    return false;
    
  return controlla_diagonale(M, parola, x + dx, y + dy, m, n, direzione, i + 1, dx, dy);
}