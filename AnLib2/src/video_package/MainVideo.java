package video_package;

//активность видеолиста
import java.util.ArrayList;
import java.util.List;

import com.moby.anlib.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainVideo extends Activity {
	private List<Plane> myPlane = new ArrayList<Plane>();
	Context context;
	Intent intent;
	Intent intent2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_activity);
		context = this;
		videoPlane();
		videoListView();
		registerClickCallback();
	}

	// Создаем обьекты которыми заполняем список
	private void videoPlane() {
		myPlane.add(new Plane(R.drawable.anmriya, "Антонов Ан 225 Мрия"));
		myPlane.add(new Plane(R.drawable.an140100, "Airliner An-140-100"));
		myPlane.add(new Plane(R.drawable.an148vid, "Презентация Ан-148"));
		myPlane.add(new Plane(R.drawable.an148evid, " Самолёт АН-148- Е"));
		myPlane.add(new Plane(R.drawable.anmodelvid, "Модели самолетов Ан"));
		myPlane.add(new Plane(R.drawable.allan, "Самолёты ОКБ Антонова"));
		myPlane.add(new Plane(R.drawable.an70vid, "Антонов Ан-70 МАКС 2013"));
		myPlane.add(new Plane(R.drawable.an72vid, "ВВС Россия Антонов Ан-72"));
		myPlane.add(new Plane(R.drawable.anryslan, "Самолет Ан 124 «Руслан»"));
		myPlane.add(new Plane(R.drawable.anlading, "Мрия заходит на посадку"));

	}

	private void videoListView() {
		ArrayAdapter<Plane> adapter = new MyListAdapter();
		ListView list = (ListView) findViewById(R.id.planesListView);
		// подключаем адаптер списка с видео
		list.setAdapter(adapter);
	}

	private void registerClickCallback() {
		ListView list = (ListView) findViewById(R.id.planesListView);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View viewClicked,
					int position, long id) {
				// через номер позиции передаем ссылку на видео интентом
				switch (position) {
				case 0:
					intent = new Intent(context, StaticVideo.class);
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(context, Video.class);
					intent.putExtra(
							"addres",
							"http://r6---sn-aigeznes.googlevideo.com/videoplayback?sver=3&ip=213.175.179.122&ipbits=0&fexp=931945%2C901441%2C909717%2C932295%2C936912%2C936910%2C923305%2C936913%2C907231%2C907240&itag=18&ms=au&source=youtube&ratebypass=yes&mv=m&id=eb1ac62c5a4cb589&mt=1386885913&key=yt5&upn=oiyFDCm0kfA&expire=1386911468&sparams=id%2Cip%2Cipbits%2Citag%2Cratebypass%2Csource%2Cupn%2Cexpire&signature=19A5F9408094A566DB233CEA4D0BE98B2D5A07E3.7B6797CF32C637826C7807F6B5652A14A49D403A&title=Airliner+Antonov+An-140-100+-+%D0%92%D0%BE%D0%B5%D0%BD%D0%BD%D0%BE+%D1%82%D1%80%D0%B0%D0%BD%D1%81%D0%BF%D0%BE%D1%80%D1%82%D0%BD%D1%8B%D0%B9+%D1%81%D0%B0%D0%BC%D0%BE%D0%BB%D0%B5%D1%82+%D0%90%D0%BD-140-100");
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(context, Video.class);
					intent.putExtra(
							"addres",
							"http://r12---sn-h5q7dn7z.googlevideo.com/videoplayback?fexp=907050%2C914504%2C916807%2C916624%2C909717%2C932295%2C936912%2C936910%2C923305%2C936913%2C907231%2C907240&key=yt5&source=youtube&upn=CD36u089B1I&mv=m&sparams=id%2Cip%2Cipbits%2Citag%2Cratebypass%2Csource%2Cupn%2Cexpire&ip=213.181.73.145&itag=18&ms=au&ratebypass=yes&expire=1386910385&id=48a29bc294d71560&mt=1386885980&sver=3&ipbits=0&signature=8FC29294481ACBC8979D3126A9CDADAE7F1CB4B4.F7E7AB3827A7BE44F419C8E53ED01237BB2A594C&title=An-148.+The+Presentation+of+the+plane.+%D0%90%D0%BD-148.+%D0%9F%D1%80%D0%B5%D0%B7%D0%B5%D0%BD%D1%82%D0%B0%D1%86%D0%B8%D1%8F+%D1%81%D0%B0%D0%BC%D0%BE%D0%BB%D0%B5%D1%82%D0%B0.");
					startActivity(intent);
					break;
				case 3:
					intent = new Intent(context, Video.class);
					intent.putExtra(
							"addres",
							"http://r1---sn-25auxa-1qhe.googlevideo.com/videoplayback?source=youtube&ratebypass=yes&expire=1386912128&upn=81WhNf--_7c&key=yt5&id=2595e598d72ee497&mv=m&ms=au&ipbits=0&fexp=923438%2C935203%2C932206%2C914054%2C916625%2C909717%2C932295%2C936912%2C936910%2C923305%2C936913%2C907231%2C907240&sparams=id%2Cip%2Cipbits%2Citag%2Cratebypass%2Csource%2Cupn%2Cexpire&itag=18&ip=213.244.89.98&mt=1386885980&sver=3&signature=E38EC6A528548ECDCC3FF06F6BC9D50DBE571A15.A84F4A885A31A3276940F9EDE73344E2E9CD35D9&title=%D0%90%D0%9D-148-+%D0%95++%D0%91%D0%BB%D0%B8%D0%B6%D0%BD%D0%B5%D0%BC%D0%B0%D0%B3%D0%B8%D1%81%D1%82%D1%80%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B9+%D0%BF%D0%B0%D1%81%D1%81%D0%B0%D0%B6%D0%B8%D1%80%D1%81%D0%BA%D0%B8%D0%B9+%D1%81%D0%B0%D0%BC%D0%BE%D0%BB%D1%91%D1%82");
					startActivity(intent);
					break;
				case 4:
					intent = new Intent(context, Video.class);
					intent.putExtra(
							"addres",
							"http://r3---sn-25auxa-1qhe.googlevideo.com/videoplayback?itag=18&ms=au&upn=noklXPbA7lc&fexp=941262%2C901440%2C909717%2C932295%2C936912%2C936910%2C923305%2C936913%2C907231%2C907240&sparams=id%2Cip%2Cipbits%2Citag%2Cratebypass%2Csource%2Cupn%2Cexpire&ip=213.244.89.98&sver=3&ipbits=0&key=yt5&source=youtube&ratebypass=yes&expire=1386910600&id=ac0a13639ca0aa63&mt=1386886052&mv=m&signature=777672DC2B70CF86E31AACDE5635E60986A4D4C5.9CDE8D3C42B6748EEB6DB7513C95D13D9AC28AD5&title=%D0%9C%D0%BE%D0%B4%D0%B5%D0%BB%D0%B8+%D1%81%D0%B0%D0%BC%D0%BE%D0%BB%D0%B5%D1%82%D0%BE%D0%B2+%D0%90%D0%BD%D1%82%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0.");
					startActivity(intent);
					break;
				case 5:
					intent = new Intent(context, Video.class);
					intent.putExtra(
							"addres",
							"http://r3---sn-25auxa-1qhe.googlevideo.com/videoplayback?ip=213.244.89.98&key=yt5&ipbits=0&expire=1386909808&itag=18&sparams=id%2Cip%2Cipbits%2Citag%2Cratebypass%2Csource%2Cupn%2Cexpire&sver=3&ratebypass=yes&mt=1386886052&id=8ced806dcb582a6e&fexp=932206%2C916611%2C909717%2C932295%2C936912%2C936910%2C923305%2C936913%2C907231%2C907240&source=youtube&mv=m&upn=ShOKtc9k1X4&ms=au&signature=209AC0D665D08EF6F7FEB40A44AA26346D665115.F7EA4C9D028416486D1E9C47FC372DB9B8032439&title=%D0%A1%D0%B0%D0%BC%D0%BE%D0%BB%D1%91%D1%82%D1%8B+%D0%9E%D0%9A%D0%91+%D0%90%D0%BD%D1%82%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0");
					startActivity(intent);
					break;
				case 6:
					intent = new Intent(context, Video.class);
					intent.putExtra(
							"addres",
							"http://r5---sn-nav853-cune.googlevideo.com/videoplayback?ipbits=0&id=860875109f8f43d9&sver=3&ratebypass=yes&expire=1386910283&itag=18&ms=au&ip=213.81.197.226&mt=1386886052&source=youtube&upn=F-MJF3bxKtg&mv=m&sparams=id%2Cip%2Cipbits%2Citag%2Cratebypass%2Csource%2Cupn%2Cexpire&fexp=913571%2C916621%2C909717%2C932295%2C936912%2C936910%2C923305%2C936913%2C907231%2C907240&key=yt5&signature=A4C3C70EEA22B0C28654818F08E21DAF540DA242.5391F693DF01B941928F5C22C7C997C0AE077CDA&title=%D0%90%D0%BD%D1%82%D0%BE%D0%BD%D0%BE%D0%B2+%D0%90%D0%BD-70+%D0%9C%D0%90%D0%9A%D0%A1+2013+Antonov+An-70+MAKS+2013");
					startActivity(intent);
					break;
				case 7:
					intent = new Intent(context, Video.class);
					intent.putExtra(
							"addres",
							"http://r3---sn-nav853-cune.googlevideo.com/videoplayback?sver=3&expire=1386909409&sparams=id%2Cip%2Cipbits%2Citag%2Cratebypass%2Csource%2Cupn%2Cexpire&ip=213.81.197.226&upn=ofgeCYVXCs0&itag=18&ms=au&mv=m&source=youtube&key=yt5&id=54a1ce09178b7e14&fexp=914005%2C909717%2C932295%2C936912%2C936910%2C923305%2C936913%2C907231%2C907240&mt=1386886125&ipbits=0&ratebypass=yes&signature=F58CBCE89832F4E68FDEF9C2F12DCCD097157CF6.23CEC8B886FA5A4E6DC84540444F1C7E240E005F&title=%D0%92%D0%92%D0%A1+%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D1%8F+Antonov+%D0%90%D0%BD%D1%82%D0%BE%D0%BD%D0%BE%D0%B2+%D0%90%D0%BD-72+Coaler+%D0%A3%D0%A2%D0%9F+training+flights+CKL+-+UUMU");
					startActivity(intent);
					break;
				case 8:
					intent = new Intent(context, Video.class);
					intent.putExtra(
							"addres",
							"http://r13---sn-2gb7ln76.c.youtube.com/videoplayback?mt=1386886105&key=yt5&ip=213.81.197.226&upn=MvpwKqzIrBs&ratebypass=yes&itag=18&sparams=id%2Cip%2Cipbits%2Citag%2Cratebypass%2Csource%2Cupn%2Cexpire&source=youtube&mv=m&ipbits=0&ms=nxu&sver=3&fexp=935615%2C909716%2C938604%2C916807%2C939914%2C916623%2C919118%2C942423%2C909717%2C932295%2C936912%2C936910%2C923305%2C936913%2C907231%2C907240&id=866cb2e7c6102adb&expire=1386910831&signature=5593B776C417022B29DAC8B181103D1F246C3126.01E825E4D6DD1111EE1D2EE486AB4E3D2F9E85C0&title=%D0%A1%D0%B0%D0%BC%D0%BE%D0%BB%D0%B5%D1%82+%D0%90%D0%BD+124+%C2%AB%D0%A0%D1%83%D1%81%D0%BB%D0%B0%D0%BD%C2%BB");
					startActivity(intent);
					break;
				case 9:
					intent = new Intent(context, Video.class);
					intent.putExtra(
							"addres",
							"http://r2---sn-p5qlsu76.googlevideo.com/videoplayback?fexp=927867%2C906008%2C937417%2C937416%2C913434%2C936910%2C936913%2C902907&sver=3&ip=176.194.189.56&ipbits=0&key=yt5&id=1fd6e89f0a404a91&sparams=id%2Cip%2Cipbits%2Citag%2Cratebypass%2Csource%2Cupn%2Cexpire&expire=1393561681&upn=TBHKHXrByF8&itag=18&ratebypass=yes&source=youtube&signature=68F32745FD67DFD4C6C3ACB270A8AE398B78A27F.BA91969CDB555E54E84B17AE58A3B537CC82C0FC&title=%D0%90%D0%BD%D1%82%D0%BE%D0%BD%D0%BE%D0%B2+%D0%90%D0%BD+225+%D0%9C%D1%80%D0%B8%D1%8F+(PixDay.ru)&redirect_counter=2&cms_redirect=yes&ms=tsu&mt=1393536687&mv=m");
					startActivity(intent);
					break;

				}
			}
		});
	}

	// класс адаптера
	private class MyListAdapter extends ArrayAdapter<Plane> {
		public MyListAdapter() {
			super(MainVideo.this, R.layout.item_view, myPlane);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// считуем инфу
			View itemView = convertView;
			if (itemView == null) {
				itemView = getLayoutInflater().inflate(R.layout.item_view,
						parent, false);
			}

			// передаем позициию пункта.
			Plane currentPlane = myPlane.get(position);

			// наполням view
			ImageView imageView = (ImageView) itemView
					.findViewById(R.id.item_icon);
			imageView.setImageResource(currentPlane.getIconID());

			// название
			TextView condionText = (TextView) itemView
					.findViewById(R.id.item_txtCondition);
			condionText.setText(currentPlane.getCondition());

			return itemView;
		}
	}
}
