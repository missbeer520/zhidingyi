package com.missbeer.MVPdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
 * 入口主界面
 * 
 * MVC模式流程：Activity调用控制层方法，再通過控制层调用功能模块Model里的业务逻辑方法获取数据或其它操作
 * 然后执行完Model层后调用控制层其它方法，再得到的数据传回View(Activity)显示。
 * */
public class MainActivity extends Activity implements MainView {
	private EditText mID, mUserName, mPassword;
	private TextView mTextView;
	private MainPresenter mainPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mID = (EditText) findViewById(R.id.id_Edit);
		mUserName = (EditText) findViewById(R.id.user_Edit);
		mPassword = (EditText) findViewById(R.id.pass_Edit);
		mTextView = (TextView) findViewById(R.id.textView);
		mainPresenter = new MainPresenter(this);
	}

	public void saveButton(View v) {
		String id = mID.getText().toString();
		String user = mUserName.getText().toString();
		String pass = mPassword.getText().toString();
		mainPresenter.mainUser(this, id, user, pass);
	}

	public void loadButton(View v) {
		mainPresenter.mainLoadUser(this);
	}

	@Override
	public void showNextType(String id, String user, String pass) {
		mTextView.setText("ID：" + id + "\n" + "名字：" + user + "\n" + "密码：" + pass);
	}

	@Override
	public void showToast() {
		Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
	}
}
