
//iterativa
long decimal(byte[] a)
{
  if (a == null)
    return -1;

  long  ret = 0;
  int   asc = 0;
  int   desc = a.length;

  while (desc > 0)
    ret += (asc++ << 1) * a[--desc];
  return ret;
}

//ricorsiva (asc parte da 0, desc parte da a.length)
long decimal(byte[] a, int asc, int desc)
{
  if (a == null)
    return -1;
  if (asc >= a.length || desc <= 0)
    return 0;
  return (asc << 1) * a[desc - 1] + calculateD(a, asc + 1, desc - 1);
}