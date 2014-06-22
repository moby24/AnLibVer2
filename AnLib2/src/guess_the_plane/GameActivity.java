package guess_the_plane;

//Игровая активность
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import com.moby.anlib.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity implements OnClickListener {

	ImageView iv;

	Button variantA;
	Button variantB;
	Button variantC;
	Button variantD;
	TableRow tableRow1;
	TableRow tableRow2;
	int count;
	int myhiscore;
	int score;
	Random random;
	double random2;
	int r_foto;
	Context context;
	TextView myScore;
	TextView hiScore;
	// DataBase
	DatabaseHelper dbHelper;
	SQLiteDatabase sdb;
	// Массив имен изображенй из Assets
	String arr[] = { "An-2", "An-3", "An-6", "An-2b", "An-32p", "An-74mp",
			"An-158", "An-148", "An-140", "An-74", "An-74tk", "An-38",
			"An-225", "An-124", "An-70", "An-32", "An-22", "An-12" };
	// Массив имен для названий кнопок
	String arrNameButtons[] = { "An-2", "An-3", "An-6", "An-2b", "An-32p",
			"An-74mp", "An-158", "An-148", "An-140", "An-74", "An-74tk",
			"An-38", "An-225", "An-124", "An-70", "An-32", "An-22", "An-12" };
	private int r_name;
	private int r_name2;
	private int r_name3;
	private int r_name4;
	ContentValues newValues;
	private int record;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guess_activity);
		// Инициализация всех View
		iv = (ImageView) findViewById(R.id.imageView1);
		variantA = (Button) findViewById(R.id.button1);
		variantA.setOnClickListener(this);
		variantB = (Button) findViewById(R.id.button2);
		variantB.setOnClickListener(this);
		variantC = (Button) findViewById(R.id.button3);
		variantC.setOnClickListener(this);
		variantD = (Button) findViewById(R.id.button4);
		variantD.setOnClickListener(this);
		myScore = (TextView) findViewById(R.id.myScore);
		hiScore = (TextView) findViewById(R.id.hiScore);
		tableRow1 = (TableRow) findViewById(R.id.tableRow1);
		tableRow2 = (TableRow) findViewById(R.id.tableRow2);

		// обнуляем значение счета
		score = 0;
		myhiscore = 0;
		count = 0;
		context = this;

		// Загружаем на начальный экран картинку и значение кнопок
		loadImageFromAsset();
		nameBut();

		// DATAbase
		dbHelper = new DatabaseHelper(this, "mydatabase.db", null, 1);

		sdb = dbHelper.getWritableDatabase();

		Cursor cursor = sdb.query("game",
				new String[] { dbHelper.SCORE_NAME_COLUMN }, null, null, null,
				null, null);

		cursor.moveToLast();

		record = cursor.getInt((cursor
				.getColumnIndex(dbHelper.SCORE_NAME_COLUMN)));
		

		/*
		 * newValues = new ContentValues();
		 * newValues.put(dbHelper.SCORE_NAME_COLUMN, "" + 0); sdb.insert("game",
		 * null, newValues);
		 */

		hiScore.setText("Рекорд = " + record);

	}

	// Метод выводит ошибку на экран
	private void variantFalse() {
		AlertDialog.Builder result = new Builder(context);
		result.setTitle("ALERT!!!");
		result.setMessage("You lose :(").setPositiveButton("OK",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				});

		result.show();

		// Определение высшего результата и его занисение в TextView
		if (myhiscore <= score) {
			myhiscore = score;
			extracted();
		}

		if (record >= myhiscore) {
			hiScore.setText("Рекорд = " + record);
		} else if (record < myhiscore) {
			hiScore.setText("Рекорд = " + myhiscore);
		}

		// обнуление счета
		score = 0;

		myScore.setText("Ваш счет = " + score);

	}

	// Метод который заносит рандомно имена на кнопки
	private void nameBut() {
		random = new Random();
		// правильный вариант кнопки меняется произвольно
		int chouse = random.nextInt(4);
		switch (chouse) {
		case 0:
			variantA.setText(arr[r_foto]);
			r_name2 = random.nextInt(18);
			variantB.setText(arrNameButtons[r_name2]);
			r_name3 = random.nextInt(18);
			variantC.setText(arrNameButtons[r_name3]);
			r_name4 = random.nextInt(18);
			variantD.setText(arrNameButtons[r_name4]);
			break;
		case 1:
			variantB.setText(arr[r_foto]);
			r_name = random.nextInt(18);
			variantA.setText(arrNameButtons[r_name]);
			r_name3 = random.nextInt(18);
			variantC.setText(arrNameButtons[r_name3]);
			r_name4 = random.nextInt(18);
			variantD.setText(arrNameButtons[r_name4]);
			break;
		case 2:
			variantC.setText(arr[r_foto]);
			r_name = random.nextInt(18);
			variantA.setText(arrNameButtons[r_name]);
			r_name2 = random.nextInt(18);
			variantB.setText(arrNameButtons[r_name2]);
			r_name4 = random.nextInt(18);
			variantD.setText(arrNameButtons[r_name4]);
			break;
		case 3:
			variantD.setText(arr[r_foto]);
			r_name = random.nextInt(18);
			variantA.setText(arrNameButtons[r_name]);
			r_name2 = random.nextInt(18);
			variantB.setText(arrNameButtons[r_name2]);
			r_name3 = random.nextInt(18);
			variantC.setText(arrNameButtons[r_name3]);
			break;
		}
	}

	// Метод правильного ответа
	private void variantTrue() {
		Toast.makeText(context, "Correct!", 500).show();
		score = score + 10;
		myScore.setText("Ваш счет = " + score);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			if (arr[r_foto].equals(variantA.getText()) == true) {

				variantTrue();
			} else {
				variantFalse();
			}
			loadImageFromAsset();
			nameBut();
			break;
		case R.id.button2:
			if (arr[r_foto].equals(variantB.getText()) == true) {
				variantTrue();
			} else {
				variantFalse();
			}
			loadImageFromAsset();
			nameBut();
			break;
		case R.id.button3:
			if (arr[r_foto].equals(variantC.getText()) == true) {
				variantTrue();
			} else {
				variantFalse();
			}
			loadImageFromAsset();
			nameBut();
			break;
		case R.id.button4:
			if (arr[r_foto].equals(variantD.getText()) == true) {
				variantTrue();
			} else {
				variantFalse();
			}
			loadImageFromAsset();
			nameBut();
			break;
		}
	}

	public void loadImageFromAsset() {

		try {
			// массив изображений
			random2 = Math.random() * 18;
			r_foto = (int) random2;
			// получаем входной поток
			InputStream ims = getAssets().open(arr[r_foto]);
			// загружаем как Drawable
			Drawable d = Drawable.createFromStream(ims, null);
			// выводим картинку в ImageView
			iv.setImageDrawable(d);
			count++;
			// обнуляем счетчик
			if (count == 18) {
				count = 0;
			}
		} catch (IOException ex) {
			return;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// занесем активность правил
		menu.add("Правила");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(context, Rules.class);
		startActivity(intent);
		return true;
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub

		// Toast.makeText(context, "test", 500).show();

		super.onBackPressed();
	}

	private void extracted() {
		newValues = new ContentValues();
		// Задайте значения для каждой строки.
		if (record >= myhiscore) {
			newValues.put(dbHelper.SCORE_NAME_COLUMN, "" + record);
		} else if (record < myhiscore) {
			newValues.put(dbHelper.SCORE_NAME_COLUMN, "" + myhiscore);
		}
		// Вставляем данные в базу
		sdb.insert("game", null, newValues);
	}

}
