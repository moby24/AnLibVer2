package fragment_app;
//Класс который складует фрагменты
import com.moby.anlib.R;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.Window;

public class AnActivity extends FragmentActivity {
	ViewPager pager;
	PagerAdapter pagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// работа на подобие Swipe
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_an);

		ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
		PagerTabStrip pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagerTabStrip);
		pagerTabStrip.setDrawFullUnderline(true);

		TitleAdapter titleAdapter = new TitleAdapter(
				getSupportFragmentManager());
		mViewPager.setAdapter(titleAdapter);
		mViewPager.setCurrentItem(0);
	}

	public class TitleAdapter extends FragmentPagerAdapter {
		Intent intent = getIntent();
		private String titles[] = intent.getStringArrayExtra("data");

		private final Fragment frags[] = new Fragment[titles.length];

		public TitleAdapter(FragmentManager fm) {
			super(fm);
			frags[0] = new FragmentView1();
			frags[1] = new FragmentView2();
			frags[2] = new FragmentView3();
			frags[3] = new FragmentView4();
			frags[4] = new FragmentView5();
			frags[5] = new FragmentView6();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position];
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			return frags[position];
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return frags.length;
		}
	}
}
