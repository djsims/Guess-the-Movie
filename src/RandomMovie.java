import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomMovie {

    RandomMovie() { }

    String ChooseRandomMovie() throws FileNotFoundException {
        File file = new File("movies.txt");
        ArrayList<String> moviesList = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            moviesList.add(scanner.nextLine());
        }
        return moviesList.get((int)(Math.random()*moviesList.size()));
    }
}
