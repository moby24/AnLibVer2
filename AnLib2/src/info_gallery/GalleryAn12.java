package info_gallery;
//������� � ���������� ��� ��-12
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

public class GalleryAn12 extends Activity {
	private ImageView bigimage;
	public Integer[] imgid = { R.drawable.image1_12, R.drawable.image2_12,
			R.drawable.image3_12 };

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

		// ������������ ������ �� �������� �������
		gallery.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				bigimage.setImageResource(imgid[position]);
				int pos = position + 1;
				label.setText(" ����������� � " + pos);
			}
		});
	}
//��������� ����� ��� �������� ���������� �� strings.xml
	public static class AnInfoRyslan {
		final String ATTR_GROUP_NAME = "groupName";
		final String ATTR_PHONE_NAME = "phoneName";

		String[] groups = new String[] { "��������", "�����������",
				"����������", "��� (��-12)", "������", "������",
				"���������� �����" };

		String[] Name = MainActivity.a.getResources().getStringArray(
				R.array.Main_info_an12);
		String[] Construction = MainActivity.a.getResources().getStringArray(
				R.array.Construction_an12);
		String[] Uses = MainActivity.a.getResources().getStringArray(
				R.array.Use_an12);
		String[] LTX = MainActivity.a.getResources().getStringArray(
				R.array.LTX_an12);
		String[] Tech = MainActivity.a.getResources().getStringArray(
				R.array.Techview_an12);
		String[] Deheat = MainActivity.a.getResources().getStringArray(
				R.array.Deheat_an12);
		String[] InterestingFact = MainActivity.a.getResources()
				.getStringArray(R.array.InterestingFact_an12);

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

			// ��������� ��������� ����� �� ������� � ���������� �����
			groupData = new ArrayList<Map<String, String>>();
			for (String group : groups) {
				// ��������� ������ ���������� ��� ������ ������
				m = new HashMap<String, String>();
				m.put(ATTR_GROUP_NAME, group); // ��� �������
				groupData.add(m);
			}

			// ������ ���������� ����� ��� ������
			String groupFrom[] = new String[] { ATTR_GROUP_NAME };
			// ������ ID view-���������, � ������� ����� �������� ���������
			// �����
			int groupTo[] = new int[] { android.R.id.text1 };

			// ������� ��������� ��� ��������� ���������
			childData = new ArrayList<ArrayList<Map<String, String>>>();

			// ������� ��������� ��������� ��� ������ ������
			childDataItem = new ArrayList<Map<String, String>>();
			// ��������� ������ ���������� ��� ������� ��������

			for (String phone : Name) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone); // �������� ��������
				childDataItem.add(m);
			}
			// ��������� � ��������� ���������
			childData.add(childDataItem);

			// ������� ��������� ��������� ��� ������� ������
			childDataItem = new ArrayList<Map<String, String>>();
			for (String phone : Construction) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone);
				childDataItem.add(m);
			}
			childData.add(childDataItem);

			childDataItem = new ArrayList<Map<String, String>>();
			for (String phone : Uses) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone);
				childDataItem.add(m);
			}
			childData.add(childDataItem);

			childDataItem = new ArrayList<Map<String, String>>();
			for (String phone : LTX) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone);
				childDataItem.add(m);
			}
			childData.add(childDataItem);

			childDataItem = new ArrayList<Map<String, String>>();
			for (String phone : Tech) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone);
				childDataItem.add(m);
			}
			childData.add(childDataItem);
			
			childDataItem = new ArrayList<Map<String, String>>();
			for (String phone : Deheat) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone);
				childDataItem.add(m);
			}
			childData.add(childDataItem);

			childDataItem = new ArrayList<Map<String, String>>();
			for (String phone : InterestingFact) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone);
				childDataItem.add(m);
			}
			childData.add(childDataItem);

			// ������ ���������� ��������� ��� ������
			String childFrom[] = new String[] { ATTR_PHONE_NAME };
			// ������ ID view-���������, � ������� ����� �������� ���������
			// ���������
			int childTo[] = new int[] { android.R.id.text1 };

			adapter = new SimpleExpandableListAdapter(ctx, groupData,
					android.R.layout.simple_expandable_list_item_1, groupFrom,
					groupTo, childData, android.R.layout.simple_list_item_1,
					childFrom, childTo);

			return adapter;
		}
	}
//��������� ����� �������
	public class ImageAdapter extends BaseAdapter {
		private int mGalleryItemBackground;
		private Context mContext;
		private final Integer[] mImage = { R.drawable.image1_12,
				R.drawable.image2_12, R.drawable.image3_12 };

		public ImageAdapter(Context �ontext) {

			mContext = �ontext;
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
			// ��������� ����� ������� �����������
			return mImage[position];
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// ��������� ���������� ������� 
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
