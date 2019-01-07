import java.io.File;
import java.util.Scanner;

public class Game {
    private int lives = 10;
    char[] movieGuess = new char[100];
    char  wrongLetter =' ';
    String wrongLetters="";
    Game() { }

    private void playAgain() throws Exception {
        Game playAgain= new Game();
        System.out.println("Play again? y/n");
        Scanner play =new Scanner(System.in);
        String playOne= play.nextLine();
        if (playOne.equals("y")) {
            playAgain.Start();
        }
        if (playOne.equals("n"))
        {
            lives = 0;
            System.out.println("Thank you for playing!");
        }
    }

    void Start() throws Exception {
        System.out.println("This is a Movie Guessing game.");
        System.out.println("You have 10 tries to guess the movie.Good luck! ");
        System.out.println("Please put a letter:");
        RandomMovie movie = new RandomMovie();
        String chosenMovie = movie.ChooseRandomMovie();
        char[] movieNameChar = chosenMovie.toCharArray();
        for (int i = 0; i < chosenMovie.length(); i++) {
            if (movieNameChar[i] == ' ')
                movieGuess[i] = ' ';
            else {
                movieGuess[i] = '-';
            }
        }
        System.out.println(movieGuess);
        Scanner read = new Scanner(System.in);
        while (lives != 0) {
            String letter = read.nextLine();
            for (int j = 0; j < chosenMovie.length(); j++) {
                if (letter.charAt(0) == movieNameChar[j]) {
                    movieGuess[j] = letter.charAt(0);
                }
            }
            System.out.println(movieGuess);
            int countMovie = 0;
            for (int i = 0; i < chosenMovie.length(); i++) {
                if (letter.charAt(0) != movieNameChar[i]) {
                    countMovie++;
                }
                if (countMovie == chosenMovie.length()) {
                    lives--;
                    wrongLetter=letter.charAt(0);
                    wrongLetters+=wrongLetter+" ";
                    System.out.println();
                    System.out.println("Letter " + letter.charAt(0) + " is wrong");
                    System.out.println("Lives:" + lives);
                    System.out.println("Wrong Letters:" + wrongLetters);
                    System.out.println();

                }
            }
            int count = 0;
            for (int j = 0; j < chosenMovie.length(); j++) {
                if (movieGuess[j] != '-') {
                    count++;
                    if (count == chosenMovie.length()) {
                        System.out.println("You Win!");
                        playAgain();
                    }
                    if (count != chosenMovie.length() && lives == 0) {
                        System.out.println("You lose");
                        playAgain();
                        break;
                    }
                }
            }
        }
    }
}
