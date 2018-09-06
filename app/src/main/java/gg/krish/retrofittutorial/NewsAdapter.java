package gg.krish.retrofittutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.List;


import android.support.v7.widget.RecyclerView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

/**
 * Created by deepak.mandhani on 18/01/18.
 */


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private WeakReference<Context> context;
    private List<Hits> hitsList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(gg.krish.retrofittutorial.R.id.newsTitle)
        TextView newsTitle;
/*        @Bind(R.id.authorTextView) TextView authorTextView;
        @Bind(R.id.publishedTextView) TextView publishedTextView;
        @Bind(R.id.pagesTextView) TextView pagesTextView;
        @Bind(gg.krish.retrofittutorial.R.id.imageView)
        ImageView imageView;*/

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

    }

    public NewsAdapter(Context context, List<Hits> books) {
        this.context = new WeakReference<>(context);
        this.hitsList = books;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(gg.krish.retrofittutorial.R.layout.news_adapter_row_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Timber.d("Element " + position + " set.");

        Hits news = hitsList.get(position);

        viewHolder.newsTitle.setText(news.getTitle());

        viewHolder.newsTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(true) {
                    

                }
            }
        });

        //viewHolder.authorTextView.setText(book.getAuthor());

/*        Context contextLocal = context.get();
        if (contextLocal != null) {
            viewHolder.publishedTextView.setText(book.getDisplayDate());
            viewHolder.pagesTextView.setText(
                    String.format(contextLocal.getString(R.string.pages_label), book.getNumberOfPages()));*/

/*            Picasso.with(contextLocal)
                    .load(book.getImageUrl())
                    .resize(80, 108)
                    .centerInside()
                    .into(viewHolder.imageView);*/

    }

    public  void updateList(List<Hits> hitsList) {
        this.hitsList = hitsList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return hitsList.size();
    }
}
