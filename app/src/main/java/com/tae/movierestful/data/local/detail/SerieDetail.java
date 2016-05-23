package com.tae.movierestful.data.local.detail;

import com.tae.movierestful.data.local.category.CategoryType;

import java.util.List;

/**
 * Created by Eduardo on 19/05/2016.
 */
public class SerieDetail implements CommonDetail{

    private String name;
    private String description;
    private String releaseDate;
    private String lastEpisodeDate;
    private String image;
    private int episodesTotal;
    private int seasonTotal;
    private double rating;
    private List<String> networks;
    private List<String> genres;
    private List<Season> seasons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLastEpisodeDate() {
        return lastEpisodeDate;
    }

    public void setLastEpisodeDate(String lastEpisodeDate) {
        this.lastEpisodeDate = lastEpisodeDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getNetworks() {
        return networks;
    }

    public void setNetworks(List<String> networks) {
        this.networks = networks;
    }

    public int getEpisodesTotal() {
        return episodesTotal;
    }

    public void setEpisodesTotal(int episodesTotal) {
        this.episodesTotal = episodesTotal;
    }

    public int getSeasonTotal() {
        return seasonTotal;
    }

    public void setSeasonTotal(int seasonTotal) {
        this.seasonTotal = seasonTotal;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    @Override
    public String getType() {
        return CategoryType.SERIE;
    }
}
