import java.io.*;
import java.util.*;

public class movie {

    public int movieID;
    public int numberOfViewers;
    public double rating;
    public int releaseYear;
    public String movieName;

    static File reader = new File("movielist.txt");

    public static void main(String[] args) throws FileNotFoundException {
        try {

            // Creates and Populates List of Movie
            List<movie> movieList = new ArrayList<>();
            readData(movieList);

            // Test readData method on list
            System.out.println("List of Movies:");
            printData(movieList);

            // Creates and Populates Array of Movies
            movie[] movieArray = new movie[100];
            readData(movieArray);

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
            if (findUsing(8.8, movieArray) != null) {
                System.out.println("Movie released with 8.8 rating is: " + findUsing(8.8, movieArray).getMovieName());
            } else
                System.out.println("No Movie with that rating");

            // Test List Comparator
            System.out.println();
            System.out.println("Comparing movies by Rating then Name:");
            movieComparator(movieList);

            // Test Array Comparator
            System.out.println();
            System.out.println("Comparing movies by Rating only:");
            movieComparator(movieArray);

            System.out.println("\nEND");

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

    }

    // Return List of Movies
    public static List<movie> readData(List<movie> list) throws FileNotFoundException {

        Scanner input = new Scanner(reader);

        while (input.hasNext()) {

            int movieID = input.nextInt();

            int numberOfViewers = input.nextInt();

            double rating = input.nextDouble();

            int releaseYear = input.nextInt();

            String movieName = input.nextLine();

            list.add(new movie(movieID, numberOfViewers, rating, releaseYear, movieName));
        }

        input.close();

        return list;
    }

    // Return Array of Movies
    public static movie[] readData(movie[] array) throws FileNotFoundException {

        Scanner read = new Scanner(reader);

        int i = 0;
        while (read.hasNext()) {

            int movieID = read.nextInt();

            int numberOfViewers = read.nextInt();

            double rating = read.nextDouble();

            int releaseYear = read.nextInt();

            String movieName = read.nextLine();

            array[i] = new movie(movieID, numberOfViewers, rating, releaseYear, movieName);

            i++;

        }

        read.close();

        return array;
    }

    // Search List of Movies
    public static movie findUsing(int year, double rating, List<movie> list) throws FileNotFoundException {
        for (movie element : list) {
            if (element.getReleaseYear() == year && element.getRating() == rating) {
                return element;
            }
        }
        return null;
    }

    // Search Array of Movies
    public static movie findUsing(double rating, movie[] array) throws FileNotFoundException {
        for (movie element : array) {
            if (element.getRating() == rating) {
                return element;
            }
        }
        return null;
    }

    // Print Array of Movies
    public static void printData(movie[] array) throws FileNotFoundException {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    // Print List of movies
    public static <T> void printData(List<T> list) throws FileNotFoundException {
        for (T element : list) {
            System.out.println(element);
        }
    }

    // Sort movies in a list by Rating then Name
    public static void movieComparator(List<movie> list) {
        list.sort(Comparator.comparing(movie::getRating).thenComparing(movie::getMovieName));
        list.forEach(System.out::println);
    }

    // Sort movies in an array by Rating
    public static void movieComparator(movie[] array) {
        Arrays.sort(array, Comparator.comparing(movie::getRating));
        for (movie element : array) {
            System.out.println(element);
        }
    }

    @Override
    public String toString() {
        return "[Movie Information] Movie: " + movieName + " Rating: " + rating + " Release Year: " + releaseYear
                + " Number of Viewing: " + numberOfViewers + " Movie ID:  " + movieID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getNumberOfViewers() {
        return numberOfViewers;
    }

    public void setNumberOfViewers(int numberOfViewers) {
        this.numberOfViewers = numberOfViewers;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    movie() {
    }

    public movie(int movieID, int numberOfViewers, double rating, int releaseYear, String movieName) {
        this.movieID = movieID;
        this.numberOfViewers = numberOfViewers;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.movieName = movieName;
    }

}
