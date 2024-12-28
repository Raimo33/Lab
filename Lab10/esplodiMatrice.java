byte[][] esplodiMatrice(byte[][] T, int r, int c)
{
  if (T == null || T[0] == null)
    return T;

  int m = T.length;
  int n = T[0].length;

  if (m < 2 || n < 2)
    return T;
  if (r < 0 || r > m - 1)
    return T;
  if (c < 0 || c > n - 1)
    return T;

  int[] dr = { 1, 1, 1, 0, 0, -1, -1, -1 };
  int[] dc = { 1, 0, -1, 1, -1, 1, 0, -1 };
  reazioneACatena(T, r, c, dr, dc, m, n);
  return T;
}

void reazioneACatena(byte[][] T, int r, int c, int[] dr, int[] dc, int m, int n)
{
  if (T[r][c] == 0)
    return;
  T[r][c] = 0;

  int x;
  int y;
  int i;
  for (i = 0; i < 8; i++)
  {
    x = r + dr[i];
    y = c + dc[i];
    if (x < 0 || y < 0 || x >= m || y >= n)
      continue;
    if (T[x][y] == 1)
      break;
  }
  if (i == 8)
    return;
  reazioneACatena(T, x, y, dr, dc, m, n);
}

