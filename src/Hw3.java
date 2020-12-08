import java.util.Random;
import java.util.Scanner;

public class Hw3 {
    public static void main(String[] args)
    {
        gameOfGuessTheWord();
    }

    public static void gameOfGuessTheWord()
    {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand=new Random();
        String hiddenWord=words[rand.nextInt(words.length-1)];
        String givenWord="###############";
        Scanner scan=new Scanner(System.in);
        boolean t = false;
        System.out.println("Угадайте слово");

        do
        {
            String answer= scan.nextLine();

            int i=0;
            if(hiddenWord.equals(answer))
            {
                t=false;
                System.out.println("Вы угадали");
                System.out.println("Загаданное слово:"+hiddenWord);
            }
            else
            {   t = true;
                while (i<answer.length())
                {
                    if (i>=hiddenWord.length()) {break;}
                    if (hiddenWord.charAt(i)==answer.charAt(i))
                    {
                        givenWord=replaceLetter(givenWord,i,answer.charAt(i));
                    }
                    i++;
                }
                System.out.println("Буквы которые вы угадали:");
                System.out.println(givenWord);;
            }

        } while (t);


    }
    public static String replaceLetter(String givenWord,int i,char newLetter)
    {
        String newWord="";
        for (int k=0;k<i;k++)
        {
            newWord+=givenWord.charAt(k);
        }
        newWord+=newLetter;
        for (int k=i+1;k<givenWord.length();k++)
        {
            newWord+=givenWord.charAt(k);
        }
        return (newWord);
    }


}
