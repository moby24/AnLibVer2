package video_package;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.moby.anlib.R;

public class StaticVideo extends Activity {
	VideoView vv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.video);
		vv = (VideoView) findViewById(R.id.videoView1);
		// путь к файлу на SD-карточке
		String viewSource = "/storage/emulated/0/myvideo.wmv";

		vv.setVideoPath(viewSource);

		vv.setMediaController(new MediaController(this));
		vv.requestFocus(0);
		vv.start(); // начинаем воспроизведение автоматически
	}
}
