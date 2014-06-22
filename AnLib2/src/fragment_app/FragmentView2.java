package fragment_app;

import com.moby.anlib.R;

import an_lib.AnInfo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
//2Фрагмент одного из 6-ти самолетов
public class FragmentView2 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View myView = inflater.inflate(R.layout.fragment2, container, false);

		ImageView iv2 = (ImageView) myView.findViewById(R.id.imageView2);
		Intent intent = getActivity().getIntent();
		int pic = intent.getIntExtra("plane2", 0);
		iv2.setImageResource(pic);
		int swi = intent.getIntExtra("switch", 0);
		final int res = 2 + swi;
		iv2.setOnClickListener(new OnClickListener() {

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
