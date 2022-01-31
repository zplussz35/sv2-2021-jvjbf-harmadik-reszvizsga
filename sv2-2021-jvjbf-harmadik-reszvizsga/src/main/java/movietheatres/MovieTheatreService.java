package movietheatres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.*;

public class MovieTheatreService {

    private Map<String, List<Movie>> shows = new LinkedHashMap<>();

    public void readFromFile(Path path) {
        List<String> lines = read(path);

        for (String l : lines) {
            String[] parts = l.split(";");
            String[] parts2 = parts[0].split("-");
            String theatre = parts2[0];
            String title = parts2[1];
            LocalTime time = LocalTime.parse(parts[1]);
            if (!shows.containsKey(theatre)) {
                shows.put(theatre, new ArrayList<>());
            }
            Movie movie = new Movie(title, time);
            shows.get(theatre).add(movie);
        }
        shows.values().stream()
                .forEach(l -> l.sort(Comparator.comparing(Movie::getStartTime)));

    }

    private List<String> read(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public Map<String, List<Movie>> getShows() {
        return shows;
    }

    public List<String> findMovie(String title) {
        List<String> movies = new ArrayList<>();
        for (Map.Entry<String, List<Movie>> actual : shows.entrySet()) {
            if (actual.getValue().contains(new Movie(title, LocalTime.of(0, 0)))) {
                movies.add(actual.getKey());
            }
        }
        return movies;
    }

    public LocalTime findLatestShow(String title) {
        LocalTime latestTime = LocalTime.MIN;
        for (Map.Entry<String, List<Movie>> actual : shows.entrySet()) {
            for (Movie m : actual.getValue()) {
                if (m.getTitle().equals(title) && m.getStartTime().isAfter(latestTime)) {
                    latestTime = m.getStartTime();
                }
            }
        }
        if (latestTime.equals(LocalTime.MIN)) {
            throw new IllegalArgumentException("Dont have this movie!");
        }
        return latestTime;
    }

    public static void main(String[] args) {
        MovieTheatreService m = new MovieTheatreService();
        m.readFromFile(Paths.get("src/main/resources/moviesintheaters.txt"));
        System.out.println(m.getShows());
    }
}
