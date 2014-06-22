package info_gallery;


import info_gallery.GalleryAn225.ImageAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import an_lib.MainActivity;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.moby.anlib.R;

public class GalleryAn124 extends Activity {
	private ImageView bigimage;
	public Integer[] imgid = { R.drawable.image1_124, R.drawable.image2_124,
			R.drawable.image4_124, R.drawable.image5_124,
			R.drawable.image6_124, R.drawable.image7_124,
			R.drawable.image8_124, R.drawable.image9_124,
			R.drawable.image10_124 };

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

	public static class AnInfoRyslan {
		final String ATTR_GROUP_NAME = "groupName";
		final String ATTR_PHONE_NAME = "phoneName";

		String[] groups = new String[] { "������� ��������",
				"������� ����������� ������������", "�����������",
				"�����������", "��� (��-124-100)", "���������", "������",
				"���������� �����", "���������� �����" };

		String[] History = MainActivity.a.getResources().getStringArray(
				R.array.History_an124);
		String[] Series = MainActivity.a.getResources().getStringArray(
				R.array.Series_an124);
		String[] Construction = MainActivity.a.getResources().getStringArray(
				R.array.Construction_an124);
		String[] Modification = MainActivity.a.getResources().getStringArray(
				R.array.Modification_an124);
		String[] LTX = MainActivity.a.getResources().getStringArray(
				R.array.LTX_an124);
		String[] Statament = MainActivity.a.getResources().getStringArray(
				R.array.Statament_an124);
		// String[] Deheat = ArrA;
		String[] Incident = MainActivity.a.getResources().getStringArray(
				R.array.Incident_an124);
		String[] OnlyOneCargo = MainActivity.a.getResources().getStringArray(
				R.array.OnlioneCargo_an124);
		String[] InterestingFact = MainActivity.a.getResources()
				.getStringArray(R.array.IntrestingFact_an124);

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
				m.put(ATTR_GROUP_NAME, group); // ��� ��������
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

			for (String phone : History) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone); // �������� ��������
				childDataItem.add(m);
			}
			// ��������� � ��������� ���������
			childData.add(childDataItem);

			// ������� ��������� ��������� ��� ������ ������
			childDataItem = new ArrayList<Map<String, String>>();
			for (String phone : Series) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone);
				childDataItem.add(m);
			}
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
			for (String phone : Modification) {
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
			for (String phone : Statament) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone);
				childDataItem.add(m);
			}
			childData.add(childDataItem);

			childDataItem = new ArrayList<Map<String, String>>();
			for (String phone : Incident) {
				m = new HashMap<String, String>();
				m.put(ATTR_PHONE_NAME, phone);
				childDataItem.add(m);
			}
			childData.add(childDataItem);

			childDataItem = new ArrayList<Map<String, String>>();
			for (String phone : OnlyOneCargo) {
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

	public class ImageAdapter extends BaseAdapter {
		private int mGalleryItemBackground;
		private Context mContext;
		private final Integer[] mImage = { R.drawable.image1_124,
				R.drawable.image2_124, R.drawable.image4_124,
				R.drawable.image5_124, R.drawable.image6_124,
				R.drawable.image7_124, R.drawable.image8_124,
				R.drawable.image9_124, R.drawable.image10_124 };

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
