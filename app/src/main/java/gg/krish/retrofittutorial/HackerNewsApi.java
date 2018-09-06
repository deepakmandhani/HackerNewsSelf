package gg.krish.retrofittutorial;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Class that details the request(s) that we will call
 */

public interface HackerNewsApi {
    @GET("search?query=event")
    Call<NewsResponse> loadNews(
            @Path("event") String news
    );

    @GET("search?query=event")
    Call<NewsResponse> loadHackerNews(
            @Query(value ="event") String news

    );



    @GET("search")
    Call<NewsResponse> getNews(@Query("query") String query);





    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://hn.algolia.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
