//iterativa
long decimal(byte[] a)
{
  if (a == null)
    return -1;

  long  ret = 0;
  int   i = 0;
  int   j = a.length;

  while (j > 0)
    ret += (1 << i++) * a[--j];
  return ret;
}

//ricorsiva (i parte da 0, j parte da a.length)
long decimal(byte[] a, int i, int j)
{
  if (a == null)
    return -1;
  if (j <= 0)
    return 0;
  return (1 << i) * a[j - 1] + decimal(a, i + 1, j - 1);
}