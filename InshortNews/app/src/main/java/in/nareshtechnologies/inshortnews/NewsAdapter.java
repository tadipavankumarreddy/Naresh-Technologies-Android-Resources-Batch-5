package in.nareshtechnologies.inshortnews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context context;
    List<Datum> news_articles;

    public NewsAdapter(Context context, List<Datum> news_articles) {
        this.context = context;
        this.news_articles = news_articles;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.one_news_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        //TODO : Display image from the internet
        Glide.with(context).load(news_articles.get(position).getImageUrl()).into(holder.news_image);
        // TODO: populate news title on the textview
        holder.news_title.setText(news_articles.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return news_articles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView news_image;
        TextView news_title;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            news_image = itemView.findViewById(R.id.news_image);
            news_title = itemView.findViewById(R.id.news_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); //Will return the position of the item that is clicked
            Datum datum = news_articles.get(position);
            Intent intent = new Intent(context,ScrollingActivity.class);
            intent.putExtra("KEY",datum);
            context.startActivity(intent);
        }
    }
}
