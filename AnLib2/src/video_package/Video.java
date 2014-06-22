package video_package;

//���������� �����
import com.moby.anlib.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends Activity {
	ProgressDialog pDialog;
	VideoView myVideoView;
	Intent intent;
	
	// ��������� URL
	
	String VideoURL;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		�������� URL ����� ������
		intent = getIntent();
		VideoURL=intent.getStringExtra("addres");
		// ��������� video.xml
		setContentView(R.layout.video);
		myVideoView = (VideoView)findViewById(R.id.videoView1);
	       myVideoView.setVideoURI(Uri.parse(VideoURL));
	       myVideoView.setMediaController(new MediaController(this));
	       myVideoView.requestFocus();
	       myVideoView.start();

	}
}
