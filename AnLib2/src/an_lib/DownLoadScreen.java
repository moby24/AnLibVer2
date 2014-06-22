package an_lib;

//Класс имитации начальной загрузки
import com.moby.anlib.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class DownLoadScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		try {
			Thread.sleep(2000);
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			finish();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
