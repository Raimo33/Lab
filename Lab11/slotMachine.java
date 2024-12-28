byte[][] ruota(byte[][] S, int[] r)
{
  if (!is_slot_valid(S))
    return null;

  int m = S.length;
  int n = S[0].length;
  
  if (r == null || r.length != n)
    return null;
  
  int dx;
  byte tmp;
  for (int i = 0; i < r.length; i++)
  {
    dx = r[i] % m;
    if (dx < 0)
      return null;
    if (dx == 0)
      continue;
    tmp = S[m - 1][i];
    while (dx > 0)
    {
      S[dx][i] = S[dx - 1][i];
      dx--;
    }
    S[0][i] = tmp;
  }
  return S;
}

boolean controllaVincita(byte[][] S)
{
  if (!is_slot_valid(S))
    return false;
  
  int m = S.length;
  int n = S[0].length;

  byte[] riga_centrale = S[m / 2];
  for (int i = 0; i < n; i++)
    if (riga_centrale[i] == 0)
      return false;
  return true;
}

boolean partitaCompleta(byte[][] S, int[] r, int k)
{
  if (k <= 0)
    return controllaVincita(S);
  while (k-- > 0)
  {
    S = ruota(S, r);
    if (controllaVincita(S) == true)
      return true;
  }
  return false;
}

boolean is_slot_valid(byte[][] S)
{
  if (S == null)
    return false;
  int m = S.length;
  if (m < 3)
    return false;
  for (int i = 0; i < m; i++)
    if (S[i] == null)
      return false;
  int n = S[0].length;
  if (n < 1 || m % 2 == 0)
    return false;
  return true;
}