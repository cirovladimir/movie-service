package mx.apestudio.movieservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class OmdbResponse {
    @JsonProperty("Title")
    String title;
    @JsonProperty("Year")
    Integer year;
    @JsonProperty("Runtime")
    String runtime;
    @JsonProperty("Genre")
    String genre;
    @JsonProperty("Plot")
    String plot;

    public OmdbResponse() {
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

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OmdbResponse omdbResponse = (OmdbResponse) o;
        return Objects.equals(title, omdbResponse.title) &&
                Objects.equals(year, omdbResponse.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }

    @Override
    public String toString() {
        return "OmdbResponse{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", plot='" + plot + '\'' +
                '}';
    }
}
