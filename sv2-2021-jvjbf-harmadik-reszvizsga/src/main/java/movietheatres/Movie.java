package movietheatres;

import java.time.LocalTime;

public class Movie implements Comparable<Movie>{
    private String movieTitle;
    private LocalTime time;

    public Movie(String movieTitle, LocalTime time) {
        this.movieTitle = movieTitle;
        this.time = time;
    }

    public String getTitle() {
        return movieTitle;
    }

    public LocalTime getStartTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        return movieTitle.equals(movie.movieTitle);
    }

    @Override
    public int hashCode() {
        return movieTitle.hashCode();
    }

    @Override
    public String toString() {
        return "{" +
                 movieTitle  +
                "," + time +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        return time.compareTo(o.getStartTime());
    }
}
