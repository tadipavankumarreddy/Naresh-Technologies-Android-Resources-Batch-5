package in.nareshtechnologies.animallist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView mListView;
    String[] animals;
    int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listview);
        animals = new String[]{"Cow", "Goat","Buffalo","Horse","Donkey","Dog","Cat","Elephant","Deer","Giraffe","Monkey"};
        images = new int[]{R.drawable.cow, R.drawable.goat, R.drawable.buffalo,R.drawable.horse,R.drawable.donkey,
        R.drawable.dog,R.drawable.cat,R.drawable.elephant,R.drawable.deer,R.drawable.girafee,R.drawable.monkey};

        AnimalAdapter adapter = new AnimalAdapter();
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    class AnimalAdapter extends BaseAdapter{

        AnimalAdapter(){

        }

        @Override
        public int getCount() {
            return 11;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view = getLayoutInflater().inflate(R.layout.one_item_template,viewGroup,false);
            }
            ImageView animal_image = view.findViewById(R.id.animal_image);
            TextView animal_name = view.findViewById(R.id.animal_name);
            animal_image.setImageResource(images[i]);
            animal_name.setText(animals[i]);
            return view;
        }
    }
}