package in.nareshtechnologies.tabsfornavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    // View pager is used to create swipe gesture on the fragments
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablyout1);
        viewPager.setAdapter(new VPAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    // We need an adapter to populate more data on single view

    class VPAdapter extends FragmentStatePagerAdapter{

        public VPAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new RedFragment();
                case 1: return new GreenFragment();
                case 2: return new BlueFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "RED";
                case 1: return "GREEN";
                case 2: return "BLUE";
            }
            return super.getPageTitle(position);
        }
    }
}