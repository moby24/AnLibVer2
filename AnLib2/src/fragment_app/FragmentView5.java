package fragment_app;
//5Фрагмент одного из 6-ти самолетов
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

public class FragmentView5 extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View myView = inflater.inflate(R.layout.fragment5, container, false);

		ImageView iv5 = (ImageView) myView.findViewById(R.id.imageView5);
		Intent intent = getActivity().getIntent();
		int pic = intent.getIntExtra("plane5", 0);
		iv5.setImageResource(pic);
		int swi = intent.getIntExtra("switch", 0);
		final int res = 5 + swi;
		iv5.setOnClickListener(new OnClickListener() {

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
