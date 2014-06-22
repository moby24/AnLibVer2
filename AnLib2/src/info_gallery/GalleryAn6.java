package info_gallery;


import info_gallery.GalleryAn124.ImageAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.moby.anlib.R;

import an_lib.MainActivity;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class GalleryAn6 extends Activity {
	private ImageView bigimage;
	public Integer[] imgid = { R.drawable.image1_6, R.drawable.image2_6 };

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery);
		final Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		final TextView label = (TextView) findViewById(R.id.textView1);
		bigimage = (ImageView) findViewById(R.id.imageView1);

		bigimage.setImageResource(imgid[0]);
		// bigimage.setBackgroundColor(Color.WHITE);

		gallery.setAdapter(new ImageAdapter(this));

		// обрабатываем щелчок на элементе галереи
		gallery.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				bigimage.setImageResource(imgid[position]);
				int pos = position + 1;
				label.setText(" Изображение № " + pos);
			}
		});
	}

	public static class AnInfoRyslan {
		final String ATTR_GROUP_NAME = "groupName";
		final String ATTR_PHONE_NAME = "phoneName";

		String[] groups = new String[] { "Название", "История создания",
				"Интересные факты", "Характеристики" };

		String[] Name = MainActivity.a.getResources().getStringArray(
				R.array.Name_an6);
		String[] History = MainActivity.a.getResources().getStringArray(
				R.array.History_an6);
		String[] InterestingFact = MainActivity.a.getResources()
				.getStringArray(R.array.Interesting_an6);
		String[] Tech_view = MainActivity.a.getResources().getStringArray(
				R.array.Techview_an6);
		ArrayList<Map<String, String>> groupData;

		ArrayList<Map<String, String>> childDataItem;

		ArrayList<ArrayList<Map<String, String>>> childData;

		Map<String, String> m;

		Context ctx;

		public AnInfoRyslan(Context _ctx) {
			ctx = _ctx;

		}

		SimpleExpandableListAdapter adapter;

		public SimpleExpandableListAdapter getAdapter() {

			// заполняем коллекцию групп из массива с названиями групп
			groupData = new ArrayList<Map<String, String>>();
			for (String group : groups) {
				// заполняем список аттрибутов для каждой группы
				m = new HashMap<String, String>();
				m.put(ATTR_GROUP_NAME, group); // имя компании
				groupData.add(m);
			}

			// список аттрибутов групп для чтения
			String groupFrom[] = new String[] { ATTR_GROUP_NAME };
			// список ID view-элементов, в которые будет помещены аттрибуты
			// групп
			int groupTo[] = new int[] { android.R.id.text1 };

			// создаем коллекцию для коллекций элементов
			childData = new ArrayList<ArrayList<Map<String, String>>>();

			// создаем коллекцию элементов для первой группы
			childDataItem = new ArrayList<Map<String, String>>();
			// заполняем список аттрибутов для каждого элемента

			for (String phone : Name) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone); // название телефона
				childDataItem.add(m);
			}
			// добавляем в коллекцию коллекций
			childData.add(childDataItem);

			// создаем коллекцию элементов для второй группы
			childDataItem = new ArrayList<Map<String, String>>();
			for (String phone : History) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone);
				childDataItem.add(m);
			}
			childData.add(childDataItem);

			// создаем коллекцию элементов для третьей группы
			childDataItem = new ArrayList<Map<String, String>>();
			for (String phone : InterestingFact) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone);
				childDataItem.add(m);
			}
			childData.add(childDataItem);

			childDataItem = new ArrayList<Map<String, String>>();
			for (String phone : Tech_view) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone);
				childDataItem.add(m);
			}
			childData.add(childDataItem);

			// список аттрибутов элементов для чтения
			String childFrom[] = new String[] { ATTR_PHONE_NAME };
			// список ID view-элементов, в которые будет помещены аттрибуты
			// элементов
			int childTo[] = new int[] { android.R.id.text1 };

			adapter = new SimpleExpandableListAdapter(ctx, groupData,
					android.R.layout.simple_expandable_list_item_1, groupFrom,
					groupTo, childData, android.R.layout.simple_list_item_1,
					childFrom, childTo);

			return adapter;
		}
	}

	public class ImageAdapter extends BaseAdapter {
		private int mGalleryItemBackground;
		private Context mContext;
		private final Integer[] mImage = { R.drawable.image1_6,
				R.drawable.image2_6 };

		public ImageAdapter(Context сontext) {

			mContext = сontext;
			TypedArray attr = mContext
					.obtainStyledAttributes(R.styleable.MyGallery);
			mGalleryItemBackground = attr.getResourceId(
					R.styleable.MyGallery_android_galleryItemBackground, 0);
			attr.recycle();
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mImage.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return mImage[arg0];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return mImage[position];
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView view = new ImageView(mContext);
			view.setImageResource(mImage[position]);
			view.setPadding(20, 20, 20, 20);
			view.setLayoutParams(new Gallery.LayoutParams(250, 250));
			view.setScaleType(ImageView.ScaleType.FIT_XY);
			view.setBackgroundResource(mGalleryItemBackground);

			return view;
		}
	}
}
