//iterativa
int[] arraySum(int[] a, int[] b)
{
  if (a == null || b == null || a.length != b.length)
    return null;

  int[] c = new int[a.length];
  for (int i = 0; i < a.length; i++)
    c[i] = a[i] + b[i];
  return c;
}
//ricorsiva (depth parte da 0)
int[] arraySum(int[] a, int[] b, int depth)
{
  if (a == null || b == null || a.length != b.length)
    return null;

  if (depth == a.length)
    return new int[a.length];
  int[] c = arraySum(a, b, depth + 1);
  c[depth] = a[depth] + b[depth];
  return c;
}