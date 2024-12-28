boolean testBilanciamento(int[] array)
{
  if (array == null)
    return false;
  if (array.length == 0)
    return false;
  if (array.length % 2 == 1)
    return false;

  int j = array.length - 1;
  return start_recursion(array, 1, j - 1, array[0] + array[j]);
}

boolean start_recursion(int[] array, int i, int j, int sum)
{
  if (i > j)
    return true;
  if (array[i] + array[j] != sum)
    return false;

  return start_recursion(array, i + 1, j - 1, sum);
}