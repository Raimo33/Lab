boolean accoppiata(char[] str)
{
  if (str.length % 2 != 0)
    return false;

  int mid = str.length / 2;
  for (int i = 0; i < mid; i++)
  {
    if (str[i] != str[mid + i])
      return false;
  }
  return true;
}
