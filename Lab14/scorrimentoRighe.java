int[][] scorrimentoRighe(int[][] matrix)
{
  if (matrix == null || matrix[0] == null)
    return matrix;

  for (int i = 0; i < matrix[0].length; i++)
  {
    if (i % 2 == 0)
      shift_right(matrix[i]);
    else
      shift_left(matrix[i]);
  }
  return matrix;
}

void shift_right(int[] array)
{
  int n = array.length;
  int tmp;
  int prev = array[0];

  for (int i = 0; i < n; i++)
  {
    tmp = array[(i + 1) % n];
    array[(i + 1) % n] = prev;
    prev = tmp;
  }
}

void shift_left(int[] array)
{
  int n = array.length;
  int tmp;
  int prev = array[n - 1];

  for (int i = n - 1; i >= 0; i--)
  {
    tmp = array[(i - 1 + n) % n];
    array[(i - 1 + n) % n] = prev;
    prev = tmp;
  }
}
