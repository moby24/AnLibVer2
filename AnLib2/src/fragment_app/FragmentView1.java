package fragment_app;

//1Фрагмент одного из 6-ти самолетов
import com.moby.anlib.R;

import an_lib.AnInfo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentView1 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View myView = inflater.inflate(R.layout.fragment1, container, false);

		ImageView iv1 = (ImageView) myView.findViewById(R.id.imageView1);
		Intent intent = getActivity().getIntent();
//		передаем картинку и свитч через extra
		int pic = intent.getIntExtra("plane1", 0);
		int swi = intent.getIntExtra("switch", 0);
		final int res = 1 + swi;
		iv1.setImageResource(pic);
		iv1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), AnInfo.class);
				intent.putExtra("list", res);
				startActivity(intent);
			}
		});

		return myView;
	}
}
