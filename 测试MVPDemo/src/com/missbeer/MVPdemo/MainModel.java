package com.missbeer.MVPdemo;

import android.content.Context;

/*
 * 
 * 声明Model模式接口方法
 * 
 * */
public interface MainModel {
	void examComply(Context context, String id, String user, String pass);

	void setLoadData(Context context);

	public interface MainModelSate {
		void mainView(Context context, String id, String user, String pass);

		void mainToast();
	}
}
