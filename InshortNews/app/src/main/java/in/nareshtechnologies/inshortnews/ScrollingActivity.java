package in.nareshtechnologies.inshortnews;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabsIntent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import in.nareshtechnologies.inshortnews.databinding.ActivityScrollingBinding;

public class ScrollingActivity extends AppCompatActivity {

    private ActivityScrollingBinding binding;
    ImageView imageView;
    Datum datum;
    TextView title,author,content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        imageView = findViewById(R.id.image_article_scor);
        title = findViewById(R.id.title_scorll);
        author = findViewById(R.id.news_author_scroll);
        content = findViewById(R.id.news_content_scroll);
        Intent intent = getIntent();
        datum = (Datum) intent.getSerializableExtra("KEY");

        Glide.with(this).load(datum.getImageUrl()).into(imageView);
        title.setText(datum.getTitle());
        author.setText(datum.getAuthor());
        content.setText(datum.getContent());

    }

    public void openNewsArticle(View view) {
        String url = datum.getUrl();
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }
}