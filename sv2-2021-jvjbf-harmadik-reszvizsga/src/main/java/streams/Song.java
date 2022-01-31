package streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Song {
    private String title;
    private int length;
    private List<String> performers;
    private LocalDate dateOfAppearance;

    public Song(String title, int length, List<String> performers, LocalDate dateOfAppearance) {
        this.title = title;
        this.length = length;
        this.performers = performers;
        this.dateOfAppearance = dateOfAppearance;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public List<String> getPerformers() {
        return performers;
    }

    public LocalDate getRelease() {
        return dateOfAppearance;
    }
}
