package in.example.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    //call tab view in activity//
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("toolbar");

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addfragment(new FirstFragment(),getTitle().toString());
        adapter.addfragment(new SecondFragment(),getTitle().toString());
        adapter.addfragment(new ThirdFragment(),getTitle().toString());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    //create a base adapter in activity with extents fragmentpageradapter//
    public class Adapter extends FragmentPagerAdapter {

        List<Fragment> list = new ArrayList<>();
        List<String> title = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addfragment(Fragment fragment, String tile) {
            list.add(fragment);
            title.add(tile);}

            @Override
            public Fragment getItem ( int position){
                return list.get(position);
            }

            @Override
            public int getCount () {
                return list.size();
            }
        }
    }

