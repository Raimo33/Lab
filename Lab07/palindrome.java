//iterativa
boolean palindrome(char[] str)
{
  if (str == null)
    return false;

  int asc = 0;
  int desc = str.length;
  while (asc < desc)
    if (str[asc++] != str[--desc])
      return false;
  return true;
}

//ricovrsiva (asc parte da 0, desc parte da str.length)
boolean palindrome(char[] str, int asc, int desc)
{
  if (str == null)
    return false;

  if (asc >= desc)
    return true;
  if (str[asc] != str[desc - 1])
    return false;
  return palindrome(str, asc + 1, desc - 1);
}