package an_lib;

import com.moby.anlib.R;

import fragment_app.AnActivity;
import guess_the_plane.GameActivity;
import video_package.MainVideo;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import com.eipetf.tdlnva180780.AdListener; //Add import statements
import com.eipetf.tdlnva180780.AdListener.AdType;
import com.eipetf.tdlnva180780.Prm;

public class MainActivity extends Activity {
	Intent intent;
	Button aboutB;

	Context context;
	public static Activity a;
	ImageView option_menu1, option_menu2, option_menu3, option_menu4,
			option_menu5;
	private Prm prm; // Declare here

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		if (prm == null)
			prm = new Prm(this, adCallbackListener, false);
		
		
		a = this;
		context = this;

		aboutB = (Button) findViewById(R.id.About);
		option_menu1 = (ImageView) findViewById(R.id.imageViewCargo);
		option_menu2 = (ImageView) findViewById(R.id.imageViewPass);
		option_menu3 = (ImageView) findViewById(R.id.imageViewSpec);
		option_menu4 = (ImageView) findViewById(R.id.imageViewVideo);
		option_menu5 = (ImageView) findViewById(R.id.imageViewGuess);
		option_menu1.setOnClickListener(new OnClickListener() {
			// вешаем onClick на каждый пункт меню
			// все данные передаются через intent
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// названия самолетов
				final String info[] = getResources().getStringArray(
						R.array.data);
				intent = new Intent(context, AnActivity.class);
				intent.putExtra("plane1", R.drawable.an225ru);
				intent.putExtra("plane2", R.drawable.an124ru);
				intent.putExtra("plane3", R.drawable.an70ru);
				intent.putExtra("plane4", R.drawable.an32ru);
				intent.putExtra("plane5", R.drawable.an22ru);
				intent.putExtra("plane6", R.drawable.an12ru);
				intent.putExtra("data", info);
				// свитч выступает переключателем массива самолетов
				intent.putExtra("switch", 0);
				startActivity(intent);
			}
		});
		option_menu2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// пассажирские самолеты
				final String info2[] = getResources().getStringArray(
						R.array.data2);
				intent = new Intent(context, AnActivity.class);
				intent.putExtra("plane1", R.drawable.an158ru);
				intent.putExtra("plane2", R.drawable.an148ru);
				intent.putExtra("plane3", R.drawable.an140ru);
				intent.putExtra("plane4", R.drawable.an74ru);
				intent.putExtra("plane5", R.drawable.an74tk300ru);
				intent.putExtra("plane6", R.drawable.an38ru);
				intent.putExtra("data", info2);
				intent.putExtra("switch", 6);
				startActivity(intent);
			}
		});
		option_menu3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// специальные и легкие самолеты
				final String info3[] = getResources().getStringArray(
						R.array.data3);
				intent = new Intent(context, AnActivity.class);
				intent.putExtra("plane1", R.drawable.an2ru);
				intent.putExtra("plane2", R.drawable.an3ru);
				intent.putExtra("plane3", R.drawable.an2vru);
				intent.putExtra("plane4", R.drawable.an6ru);
				intent.putExtra("plane5", R.drawable.an32pru);
				intent.putExtra("plane6", R.drawable.an74ru);
				intent.putExtra("data", info3);
				intent.putExtra("switch", 12);
				startActivity(intent);
			}
		});
		option_menu4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// активность видео
				Intent intent = new Intent(context, MainVideo.class);
				startActivity(intent);
			}
		});
		option_menu5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// активность игры
				Intent intent = new Intent(context, GameActivity.class);
				startActivity(intent);
			}
		});
	}

	public void onClickAbout(View v) {
		AlertDialog.Builder b = new AlertDialog.Builder(context);
		b.setTitle("О программе");
		b.setMessage("version: 1.0 \nСправочник по самолетам КБ Антонов \nАвтор программы -\nТовкес <<moby>> Максим \nmail: moby.89@i.ua");
		b.show();
	}

	@Override
	public void onBackPressed() {
		 try{
		     prm.runCachedAd(this, AdType.smartwall);   // for closing the activity call finish() method in onSmartWallClosed(). 
		   }catch (Exception e) {
		     // close the activity if ad is not available. 
		     //finish();
		   }
	}
	 AdListener adCallbackListener=new AdListener() {
         
	        @Override
	        public void onSDKIntegrationError(String message) {
	        //Here you will receive message from SDK if it detects any integration issue.
	        }

	        public void onSmartWallAdShowing() {
	        // This will be called by SDK when it’s showing any of the SmartWall ad.
	        }

	        @Override
	        public void onSmartWallAdClosed() {
	        // This will be called by SDK when the SmartWall ad is closed.
	        }

	        @Override
	        public void onAdError(String message) {
	        //This will get called if any error occurred during ad serving.
	        }
	        @Override
			public void onAdCached(AdType arg0) {
			//This will get called when an ad is cached. 
			
			}
			 @Override
			public void noAdAvailableListener() {
			//this will get called when ad is not available 
			
			}
	     };
}
