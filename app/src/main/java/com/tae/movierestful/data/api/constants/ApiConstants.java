package com.tae.movierestful.data.api.constants;

/**
 * Created by Eduardo on 18/05/2016.
 */
public class ApiConstants {

    private static final String API_KEY = "0a08e38b874d0aa2d426ffc04357069d";
    public static final String BASE_URL = "http://api.themoviedb.org";
    public static final String BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w185/";

    public static final String MOVIES_POPULAR = "/3/movie/popular?api_key=" + API_KEY;
    public static final String SERIES_POPULAR = "/3/tv/popular?api_key=" + API_KEY;
    public static final String CELEBRITIES_POPULAR = "/3/person/popular?api_key=" + API_KEY;

    public static final String ID = "id";
    public static final String MOVIE_BY_ID = "/3/movie/{" + ID + "}?api_key=" + API_KEY;
    public static final String SERIE_BY_ID = "/3/tv/{" + ID + "}?api_key=" + API_KEY;
    public static final String CELEBRITY_BY_ID = "/3/person/{" + ID + "}?api_key=" + API_KEY;
    public static final String RESULTS = "results";
    public static final String TITLE = "title";
    public static final String NAME = "name";
    public static final String OVERVIEW = "overview";
    public static final String VOTE_AVERAGE = "vote_average";
    public static final String RELEASE_DATE = "release_date";
    public static final String POSTER_PATH = "poster_path";
    public static final String FIRST_AIR_DATE = "first_air_date";
    public static final String PROFILE_PATH = "profile_path";
    public static final String BUDGET = "budget";
    public static final String PRODUCTION_COMPANIES = "production_companies";
    public static final String RUNTIME = "runtime";
    public static final String GENRES = "genres";
    public static final String NUMBER_OF_EPISODES = "number_of_episodes";
    public static final String LAST_AIR_DATE = "last_air_date";
    public static final String NETWORKS = "networks";
    public static final String SEASONS = "seasons";
    public static final String AIR_DATE = "air_date";
    public static final String EPISODE_COUNT = "episode_count";
    public static final String SEASON_NUMBER = "season_number";
    public static final String NUMBER_OF_SEASONS = "number_of_seasons";
    public static final String BIOGRAPHY = "biography";
    public static final String BIRTHDAY = "birthday";
    public static final String DEATHDAY = "deathday";
    public static final String PLACE_OF_BIRTH = "place_of_birth";
    public static final String POPULARITY = "popularity";
    public static final String GENDER = "gender";
}
