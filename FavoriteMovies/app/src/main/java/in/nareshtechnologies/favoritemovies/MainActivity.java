package in.nareshtechnologies.favoritemovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int[] images; String[] movie_names;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        initData();

        MoviesAdapter adapter = new MoviesAdapter(this,images,movie_names);
        recyclerView.setAdapter(adapter);
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));*/
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        /*recyclerView.setLayoutManager(new GridLayoutManager(this,2,LinearLayoutManager.HORIZONTAL,false));*/
        /*recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));*/
    }

    private void initData() {
        images = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,
        R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};

        movie_names = new String[]{"Avatar","Bul bulaaya Baraati","Charlie","Don","Em Maya Chesave","Fukrey",
        "God Father","Harry Potter","Iron Man","James Bond 007"};
    }


    // Steps to implement Recyclerview
    // TODO 1: getting the data Ready
    // TODO 2: Add Recyclerview to the Project
    // TODO 3: Prepare the design for one row of the recyclerview (one_row_design.xml)
    // TODO 4: Create an Adapter that is responsible to populate the data on the RecyclerView.
    // TODO 5: set up a layoutmanager on the Recyclerview to arrange the items in the way you want it
    //      - LinearLayoutManager
    //      - GridLayoutManager
    //      - StaggeredGridLayoutManager
}