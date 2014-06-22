package an_lib;
//Класс отвечающий за передачу информации по нажатии на фрагмент самолета
import info_gallery.GalleryAn12;
import info_gallery.GalleryAn124;
import info_gallery.GalleryAn140;
import info_gallery.GalleryAn148;
import info_gallery.GalleryAn158;
import info_gallery.GalleryAn2;
import info_gallery.GalleryAn22;
import info_gallery.GalleryAn225;
import info_gallery.GalleryAn2B;
import info_gallery.GalleryAn3;
import info_gallery.GalleryAn32;
import info_gallery.GalleryAn32P;
import info_gallery.GalleryAn38;
import info_gallery.GalleryAn6;
import info_gallery.GalleryAn70;
import info_gallery.GalleryAn74;
import info_gallery.GalleryAn74MP;
import info_gallery.GalleryAn74TK300;
import android.app.Activity;

import com.moby.anlib.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

public class AnInfo extends Activity {
	SimpleExpandableListAdapter adapter;

	GalleryAn225.AnInfoMriya ah;
	GalleryAn124.AnInfoRyslan ar;
	GalleryAn70.AnInfoRyslan an70;
	GalleryAn32.AnInfoRyslan an32;
	GalleryAn22.AnInfoRyslan an22;
	GalleryAn12.AnInfoRyslan an12;

	GalleryAn158.AnInfoRyslan an158;
	GalleryAn148.AnInfoRyslan an148;
	GalleryAn140.AnInfoRyslan an140;
	GalleryAn74.AnInfoRyslan an74;
	GalleryAn74TK300.AnInfoRyslan an74tk300;
	GalleryAn38.AnInfoRyslan an38;

	GalleryAn2.AnInfoRyslan an2;
	GalleryAn3.AnInfoRyslan an3;
	GalleryAn2B.AnInfoRyslan an2b;
	GalleryAn6.AnInfoRyslan an6;
	GalleryAn32P.AnInfoRyslan an32p;
	GalleryAn74MP.AnInfoRyslan an74mp;

	ExpandableListView elvMain;
	Intent intent;
	int swi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.an_info);
		TextView tv = (TextView) findViewById(R.id.imageInfo);

		elvMain = (ExpandableListView) findViewById(R.id.elvMain);

		intent = getIntent();

		tv.setText("Галерея фотографий");

		swi = intent.getIntExtra("list", 0);
//		имеем свитч на информацию о самолете которая заносится адаптером через класси самолетов
		switch (swi) {

		case 1:
			ah = new GalleryAn225.AnInfoMriya(this);
			adapter = ah.getAdapter();
			break;
		case 2:
			ar = new GalleryAn124.AnInfoRyslan(this);
			adapter = ar.getAdapter();
			break;
		case 3:
			an70 = new GalleryAn70.AnInfoRyslan(this);
			adapter = an70.getAdapter();
			break;
		case 4:
			an32 = new GalleryAn32.AnInfoRyslan(this);
			adapter = an32.getAdapter();
			break;
		case 5:
			an22 = new GalleryAn22.AnInfoRyslan(this);
			adapter = an22.getAdapter();
			break;
		case 6:
			an12 = new GalleryAn12.AnInfoRyslan(this);
			adapter = an12.getAdapter();
			break;
		case 7:
			an158 = new GalleryAn158.AnInfoRyslan(this);
			adapter = an158.getAdapter();
			break;
		case 8:
			an148 = new GalleryAn148.AnInfoRyslan(this);
			adapter = an148.getAdapter();
			break;
		case 9:
			an140 = new GalleryAn140.AnInfoRyslan(this);
			adapter = an140.getAdapter();
			break;
		case 10:
			an74 = new GalleryAn74.AnInfoRyslan(this);
			adapter = an74.getAdapter();
			break;
		case 11:
			an74tk300 = new GalleryAn74TK300.AnInfoRyslan(this);
			adapter = an74tk300.getAdapter();
			break;
		case 12:
			an38 = new GalleryAn38.AnInfoRyslan(this);
			adapter = an38.getAdapter();
			break;
		case 13:
			an2 = new GalleryAn2.AnInfoRyslan(this);
			adapter = an2.getAdapter();
			break;
		case 14:
			an3 = new GalleryAn3.AnInfoRyslan(this);
			adapter = an3.getAdapter();
			break;
		case 15:
			an2b = new GalleryAn2B.AnInfoRyslan(this);
			adapter = an2b.getAdapter();
			break;
		case 16:
			an6 = new GalleryAn6.AnInfoRyslan(this);
			adapter = an6.getAdapter();
			break;
		case 17:
			an32p = new GalleryAn32P.AnInfoRyslan(this);
			adapter = an32p.getAdapter();
			break;
		case 18:
			an74mp = new GalleryAn74MP.AnInfoRyslan(this);
			adapter = an74mp.getAdapter();
			break;
		}
		elvMain.setAdapter(adapter);
	}

	public void onClick(View v) {
//		свитч на включение галереи по каждому из самолетов
		switch (swi) {

		case 1:
			Intent intent2 = new Intent(this, GalleryAn225.class);
			startActivity(intent2);
			break;
		case 2:
			Intent intent3 = new Intent(this, GalleryAn124.class);
			startActivity(intent3);
			break;
		case 3:
			Intent intent4 = new Intent(this, GalleryAn70.class);
			startActivity(intent4);
			break;
		case 4:
			Intent intent5 = new Intent(this, GalleryAn32.class);
			startActivity(intent5);
			break;
		case 5:
			Intent intent6 = new Intent(this, GalleryAn22.class);
			startActivity(intent6);
			break;
		case 6:
			Intent intent7 = new Intent(this, GalleryAn12.class);
			startActivity(intent7);
			break;
		case 7:
			Intent intent8 = new Intent(this, GalleryAn158.class);
			startActivity(intent8);
			break;
		case 8:
			Intent intent9 = new Intent(this, GalleryAn148.class);
			startActivity(intent9);
			break;
		case 9:
			Intent intent10 = new Intent(this, GalleryAn140.class);
			startActivity(intent10);
			break;
		case 10:
			Intent intent11 = new Intent(this, GalleryAn74.class);
			startActivity(intent11);
			break;
		case 11:
			Intent intent12 = new Intent(this, GalleryAn74TK300.class);
			startActivity(intent12);
			break;
		case 12:
			Intent intent13 = new Intent(this, GalleryAn38.class);
			startActivity(intent13);
			break;
		case 13:
			Intent intent14 = new Intent(this, GalleryAn2.class);
			startActivity(intent14);
			break;
		case 14:
			Intent intent15 = new Intent(this, GalleryAn3.class);
			startActivity(intent15);
			break;
		case 15:
			Intent intent16 = new Intent(this, GalleryAn2B.class);
			startActivity(intent16);
			break;
		case 16:
			Intent intent17 = new Intent(this, GalleryAn6.class);
			startActivity(intent17);
			break;
		case 17:
			Intent intent18 = new Intent(this, GalleryAn32P.class);
			startActivity(intent18);
			break;
		case 18:
			Intent intent19 = new Intent(this, GalleryAn74MP.class);
			startActivity(intent19);
			break;
		}

	}
}
