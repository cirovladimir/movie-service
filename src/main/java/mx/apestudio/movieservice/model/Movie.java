package mx.apestudio.movieservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Movie {
    @JsonProperty("Title")
    String title;
    @JsonProperty("Year")
    Integer year;
    @JsonProperty("Runtime")
    String runtime;
    @JsonProperty("Genre")
    String genre;

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) &&
                Objects.equals(year, movie.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
