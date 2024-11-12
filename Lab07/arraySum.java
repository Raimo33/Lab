//iterativa
int[] arraySum(int a[], int b[])
{
  if (a == null || b == null || a.length != b.length)
    return null;

  int[] sum = new int[a.length];
  for (int i = 0; i < a.length; i++)
    sum[i] = a[i] + b[i];
  return sum;
}
//ricorsiva (depth parte da 0)
int[] arraySum(int a[], int b[], int depth)
{
  if (a == null || b == null || a.length != b.length)
    return null;

  if (depth == a.length)
    return new int[a.length];
  int[] sum = arraySum(a, b, depth + 1);
  sum[depth] = a[depth] + b[depth];
  return sum;
}