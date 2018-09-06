package gg.krish.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Activity in which the click of the button will result in a call to GitHub's API to get a list of
 * the followers of a user. Once this list has been retrieved, one of the follower's usernames,
 * chosen randomly, will be displayed in the TextView
 */
public class MainActivity extends AppCompatActivity {


    //Sets up Button and TextView for use in this class
    @Bind(gg.krish.retrofittutorial.R.id.text_view)
    EditText searchText;

    @Bind(gg.krish.retrofittutorial.R.id.button)
    Button searchButton;

    @Bind(gg.krish.retrofittutorial.R.id.recyclerView)
    RecyclerView recyclerView;

    List<Hits> hitsList = new ArrayList<>();

    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(gg.krish.retrofittutorial.R.layout.activity_main);
        ButterKnife.bind(this);

        //Starts Retrofit
        final HackerNewsApi hackerNewsApi = HackerNewsApi.retrofit.create(HackerNewsApi.class);


        configureLayout();
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //searchText.setText("Loading random follower...");

                String text = searchText.getText().toString();
                //Sets up up the API call
                Call<NewsResponse> call = hackerNewsApi.getNews(text);

                call.enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                        //Gets the list of news
                        NewsResponse newsResponse = response.body();
                        if(newsResponse != null){
                            List<Hits> hitsList = newsResponse.getHits();

                            int newCount = newsResponse.getHits().size();
                            if (hitsList != null && hitsList.size() > 0)
                                updateNews(hitsList);
                        }


                    }

                    @Override
                    //If the call failed
                    public void onFailure(Call<NewsResponse> call, Throwable t) {
                        Log.e("RequestCall", "Request failed");
                    }
                });
            }
        });
    }


    public void updateNews(List<Hits> hitsList) {
        newsAdapter.updateList(hitsList);

    }

    private void configureLayout() {
        //setSupportActionBar((Toolbar) ButterKnife.findById(this, R.id.toolbar));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        newsAdapter = new NewsAdapter(this, hitsList);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.addItemDecoration();


        recyclerView.setAdapter(newsAdapter);
    }
}
