package mx.apestudio.movieservice.model;

public class MovieResponse {

    String title;
    Integer year;
    String genre;
    String director;
    String actors;
    String plot;
    String posterUrl;
    String youtubeUrl;
    Float voteAverage;

    public MovieResponse(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieResponse title(String title){
        setTitle(title);
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public MovieResponse year(Integer year){
        setYear(year);
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public MovieResponse genre(String genre){
        setGenre(genre);
        return this;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public MovieResponse director(String director){
        setDirector(director);
        return this;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public MovieResponse plot(String plot){
        setPlot(plot);
        return this;
    }

    public MovieResponse actors(String actors){
        setActors(actors);
        return this;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public MovieResponse posterUrl(String posterUrl){
        setPosterUrl(posterUrl);
        return this;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public MovieResponse youtubeUrl(String youtubeUrl){
        setYoutubeUrl(youtubeUrl);
        return this;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public MovieResponse voteAverage(Float voteAverage){
        setVoteAverage(voteAverage);
        return this;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", youtubeUrl='" + youtubeUrl + '\'' +
                ", voteAverage=" + voteAverage +
                '}';
    }
}
