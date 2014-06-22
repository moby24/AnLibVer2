package fragment_app;
//3Фрагмент одного из 6-ти самолетов
import com.moby.anlib.R;

import an_lib.AnInfo;
import android.widget.ImageView;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class FragmentView3 extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View myView = inflater.inflate(R.layout.fragment3, container, false);

		ImageView iv3 = (ImageView) myView.findViewById(R.id.imageView3);
		Intent intent = getActivity().getIntent();
		int pic = intent.getIntExtra("plane3", 0);
		iv3.setImageResource(pic);
		int swi = intent.getIntExtra("switch", 0);
		final int res = 3 + swi;
		iv3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), AnInfo.class);
				intent.putExtra("list", res);
				startActivity(intent);
			}
		});

		return myView;

	}

}
