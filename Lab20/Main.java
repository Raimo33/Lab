public class Main 
{

  public static void main(String[] args) 
  {
    char[][] matrix = {
      {'A', 'B', 'C', 'J'},
      {'F', 'A', 'A', 'H'},
      {'I', 'V', 'V', 'L'},
      {'A', 'N', 'O', 'A'}
    };
    char[] word = {'J', 'A', 'V', 'A'};
    System.out.println(TrovaParolaDiagonale.trovaParolaDiagonale(matrix, word)); // true
  }
  
}