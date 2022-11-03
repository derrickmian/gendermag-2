import java.io.*;
import java.util.*;

public class movie {

    static Integer movieID;
    static Integer numberOfViewers;
    static Integer releaseYear;
    static Double rating;
    static String movieName;

    public static void main(String[] args) throws IOException {

        // Array List to Store Strings
        List<String> listOfString2 = new ArrayList<String>();

        // Read movielist.txt file
        BufferedReader br = new BufferedReader(new FileReader("movielist.txt"));

        // Reads line by line
        String str;
        while ((str = br.readLine()) != null) {
            // Print the string
            listOfString2.add(str);
        }

        // Convert any arrayList to array
        String[] array = listOfString2.toArray(new String[0]);

        // Movie Selection by ID
        System.out.println("Input Movie ID from 1-100");
        Scanner input = new Scanner(System.in);
        int selection = input.nextInt();
        String testString = array[selection];

        String[] arrOfStr = testString.split(" ", 5);

        // Populating Variables
        movieID = Integer.parseInt(arrOfStr[0]);
        System.out.println(movieID);

        numberOfViewers = Integer.parseInt(arrOfStr[1]);
        System.out.println(numberOfViewers);

        rating = Double.parseDouble(arrOfStr[2]);
        System.out.println(rating);

        releaseYear = Integer.parseInt(arrOfStr[3]);
        System.out.println(releaseYear);

        movieName = arrOfStr[4];
        System.out.println(movieName);

        input.close();
        br.close();

    }

    @Override
    public String toString() {
        return "Movie Information:\nMovie: " + movieName + "\nRating: " + rating + "\nRelease Year: " + releaseYear
                + "\nNumber of Viewing: " + numberOfViewers + "\nMovie ID:  " + movieID;
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public Integer getNumberOfViewers() {
        return numberOfViewers;
    }

    public void setNumberOfViewers(Integer numberOfViewers) {
        this.numberOfViewers = numberOfViewers;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String movieName() {
        return movieName;
    }

    public void settMovieName(String movieName) {
        this.movieName = movieName;
    }

    movie() {
    }

    public movie(int movieID, int numberOfViewers, int releaseYear, double rating, String movieName) {
        this.movieID = movieID;
        this.numberOfViewers = numberOfViewers;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.movieName = movieName;
    }

}
