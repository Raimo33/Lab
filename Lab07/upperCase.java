//iterativa
char[] upperCase(char[] str)
{
  for (int i = 0; i < str.length; i++)
    if (str[i] >= 'a' && str[i] <= 'z')
      str[i] -= 32;
  return str;
}

//ricortriva (depth parte da 0)
char[] upperCase(char[] str, int depth)
{
  if (str == null)
    return null;

  if (depth == str.length)
    return str;
  if (str[depth] >= 'a' && str[depth] <= 'z')
    str[depth] -= 32;
  return upperCase(str, depth + 1);
}
