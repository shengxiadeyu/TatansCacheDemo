package com.tatans.asimplecachedemo;



import net.tatans.coeus.network.tools.TatansCache;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @ClassName: SaveStringActivity
 * @Description: 缓存string
 * @Author Yuliang
 * @Date 2013-8-7 下午9:59:43
 * 
 */
public class SaveStringActivity extends Activity {

	private EditText mEt_string_input;
	private TextView mTv_string_res;

	private TatansCache mCache;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save_string);
		// 初始化控件
		initView();

		mCache = TatansCache.get(this);
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		mEt_string_input = (EditText) findViewById(R.id.et_string_input);
		mTv_string_res = (TextView) findViewById(R.id.tv_string_res);
	}

	/**
	 * 点击save事件
	 * 
	 * @param v
	 */
	public void save(View v) {
		if (mEt_string_input.getText().toString().trim().length() == 0) {
			Toast.makeText(
					this,
					"Cuz u input is a nullcharacter ... So , when u press \"read\" , if do not show any result , plz don't be surprise",
					Toast.LENGTH_SHORT).show();
		}
		mCache.put("testString", mEt_string_input.getText().toString());
	}

	/**
	 * 点击read事件
	 * 
	 * @param v
	 */
	public void read(View v) {
		String testString = mCache.getAsString("testString");
		if (testString == null) {
			Toast.makeText(this, "String cache is null ...", Toast.LENGTH_SHORT)
					.show();
			mTv_string_res.setText(null);
			return;
		}
		mTv_string_res.setText(testString);
	}

	/**
	 * 点击clear事件
	 * 
	 * @param v
	 */
	public void clear(View v) {
		mCache.remove("testString");
	}

}
