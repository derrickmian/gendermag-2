import java.io.*;
import java.util.*;

public class movie<A, B, C, D, E> {

    public A movieID;
    public B numberOfViewers;
    public C rating;
    public D releaseYear;
    public E movieName;

    public static void main(String[] args) throws IOException {

        // Read movielist.txt file
        BufferedReader br = new BufferedReader(new FileReader("movielist.txt"));

        // Array List to Store Strings
        List<String> movieListString = new ArrayList<>();

        // Transform file into ArrayList of Strings
        String str;
        while ((str = br.readLine()) != null) {
            movieListString.add(str);
        }

        // Creates and Populates List of Movie
        List<movie> movieList = new ArrayList<>();
        readData(movieList, movieListString);

        // Test readData method on list
        System.out.println("List of Movies:");
        printData(movieList);

        // Creates and Populates Array of Movies
        String[] movieArray = new String[101];
        readData(movieArray, movieListString);

        // Test readData method on array
        System.out.println("\nArray of Movies:");
        printData(movieArray);

        // Test search method on list
        System.out.println();
        System.out.println("Search List Test");
        if (findUsing(1995, 8.6, movieList) != null) {
            System.out.println("Movie released in 1995 with a rating of 8.6 is: "
                    + findUsing(1995, 8.6, movieList).getMovieName());
        } else
            System.out.println("Movie not in List");

        // Test search method on array
        System.out.println();
        System.out.println("Search Array Test");
        if (findUsing("8.8", movieArray) != null) {
            System.out.println("Movie released with 8.8 rating is: " + findUsing("8.8", movieArray));
        } else
            System.out.println("No Movie with that rating");

        System.out.println("\nEND");

        br.close();

    }

    // Return List of Movies
    public static List<movie> readData(List<movie> list, List<String> movieList) {

        List<String> movieListString = movieList;

        // Convert any arrayList to array
        String[] array = movieListString.toArray(new String[0]);

        for (int i = 1; i <= 100; i++) {

            String spring = array[i];
            String[] arrOfStr1 = spring.split(" ", 5);

            // Populating Variables
            int movieID = Integer.parseInt(arrOfStr1[0]);

            int numberOfViewers = Integer.parseInt(arrOfStr1[1]);

            double rating = Double.parseDouble(arrOfStr1[2]);

            int releaseYear = Integer.parseInt(arrOfStr1[3]);

            String movieName = arrOfStr1[4];

            movie<Integer, Integer, Double, Integer, String> tempMovie = new movie<>(movieID, numberOfViewers, rating,
                    releaseYear, movieName);

            list.add(tempMovie);
        }
        return list;
    }

    // Return Array of Movies
    public static String[] readData(String[] array, List<String> movieList) {
        List<String> movieListString = movieList;

        // Convert any arrayList to array
        String[] tempArray = movieListString.toArray(new String[0]);

        for (int i = 0; i <= 100; i++) {
            array[i] = tempArray[i];
        }
        return array;
    }

    // Search List of Movies
    public static movie findUsing(int year, double rating, List<movie> movie) {
        for (movie element : movie) {
            if (element.getReleaseYear().equals(year) && element.getRating().equals(rating)) {
                return element;
            }
        }
        return null;
    }

    // Search Array of Movies
    public static String findUsing(String rating, String[] array) {
        for (int i = 0; i <= array.length; i++) {

            String spring = array[i];
            String[] arrOfStr = spring.split(" ", 5);

            if (rating.equals(arrOfStr[2])) {
                return array[i];
            }
        }
        return null;
    }

    // Print Array of Movies
    public static void printData(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    // Print List of movies
    public static <T> void printData(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

    @Override
    public String toString() {
        return "[Movie Information] Movie: " + movieName + " Rating: " + rating + " Release Year: " + releaseYear
                + " Number of Viewing: " + numberOfViewers + " Movie ID:  " + movieID;
    }

    public A getMovieID() {
        return movieID;
    }

    public void setMovieID(A movieID) {
        this.movieID = movieID;
    }

    public B getNumberOfViewers() {
        return numberOfViewers;
    }

    public void setNumberOfViewers(B numberOfViewers) {
        this.numberOfViewers = numberOfViewers;
    }

    public C getRating() {
        return rating;
    }

    public void setRating(C rating) {
        this.rating = rating;
    }

    public D getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(D releaseYear) {
        this.releaseYear = releaseYear;
    }

    public E getMovieName() {
        return movieName;
    }

    public void setMovieName(E movieName) {
        this.movieName = movieName;
    }

    movie() {
    }

    public movie(A movieID, B numberOfViewers, C rating, D releaseYear, E movieName) {
        this.movieID = movieID;
        this.numberOfViewers = numberOfViewers;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.movieName = movieName;
    }

}
