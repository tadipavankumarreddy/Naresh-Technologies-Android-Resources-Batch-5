package in.nareshtechnologies.favoritemovies;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * What is the responsibility of an Adapter class of RecyclerView?
 * 1. It has to create an item that holds the data
 * 2. Populate this item on the Recyclerview
 * 3. Update and reuse the resources
 * */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    // TODO : get the data that has to be populated.
    private Context context;
    private int movies_posters[];
    private String movies_names[];

    public MoviesAdapter(Context context, int[] movies_posters, String[] movies_names) {
        this.context = context;
        this.movies_posters = movies_posters;
        this.movies_names = movies_names;
    }

    /*onCreateViewHolder(..) is responsible for creating the layout item and displaying it on the recyclerview*/
    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_row_design,parent,false);
        return new MoviesViewHolder(v);
    }

    /*onBindViewHolder() is responsible of populating the data on the Recyclerview items based on the position*/
    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        holder.p.setImageResource(movies_posters[position]);
        holder.t.setText(movies_names[position]);
    }

    /*getItemCount() returns the count of total items that are going to be displayed on the Recyclerview*/
    @Override
    public int getItemCount() {
        return movies_posters.length;
    }

    /*Here we establish the connections*/
    public class MoviesViewHolder extends RecyclerView.ViewHolder {

        ImageView p;
        TextView t;
        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            p = itemView.findViewById(R.id.imageView);
            t = itemView.findViewById(R.id.movie_name_tv);
        }
    }
}
