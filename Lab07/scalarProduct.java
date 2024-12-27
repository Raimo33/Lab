//iterativa
int scalarProduct(int[] a, int[] b)
{
  if (a == null || b == null || a.length != b.length)
    return -1;
  
  int sum = 0;
  for (int i = 0; i < a.length; i++)
    sum += (a[i] * b[i]);
  return sum;
}
//ricorsiva (depth parte da 0)
int scalarProduct(int[] a, int[] b, int depth)
{
  if (a == null || b == null || a.length != b.length)
    return -1;

  if (depth == a.length)
    return 0;
  return a[depth] * b[depth] + scalarProduct(a, b, depth + 1);
}