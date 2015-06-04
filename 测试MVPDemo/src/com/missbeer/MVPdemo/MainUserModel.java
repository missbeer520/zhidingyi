package com.missbeer.MVPdemo;

import android.content.Context;
import android.content.SharedPreferences;

/*
 * 声明功能模块Model模式，实现Model模式里的方法，在這里寫功能模塊業務邏輯
 * 
 * */
public class MainUserModel implements MainModel {
	public String id;
	public String userName;
	public String passWord;
	public MainModelSate mainModelSate;

	public MainUserModel(MainModelSate mainModelSate) {
		this.mainModelSate = mainModelSate;
	}

	@Override
	public void examComply(Context context, String id, String user, String pass) {
		SharedPreferences sharedPreferences = context.getSharedPreferences("userPass", 0);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString("id", id);
		editor.putString("user", user);
		editor.putString("pass", pass);
		editor.commit();
		mainModelSate.mainToast();
	}

	@Override
	public void setLoadData(Context context) {
		SharedPreferences sharedPreferences = context.getSharedPreferences("userPass", 0);
		id = sharedPreferences.getString("id", "");
		userName = sharedPreferences.getString("user", "");
		passWord = sharedPreferences.getString("pass", "");
		mainModelSate.mainView(context, id, userName, passWord);
	}

}
