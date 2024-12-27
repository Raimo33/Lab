//iterativa
boolean palindrome(char[] str)
{
  if (str == null)
    return false;

  int i = 0;
  int j = str.length;
  while (i < j)
    if (str[i++] != str[--j])
      return false;
  return true;
}

//ricovrsiva (i parte da 0, j parte da str.length)
boolean palindrome(char[] str, int i, int j)
{
  if (str == null)
    return false;

  if (i >= j)
    return true;
  if (str[i] != str[j - 1])
    return false;
  return palindrome(str, i + 1, j - 1);
}