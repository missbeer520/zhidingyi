package com.missbeer.MVPdemo;

/*
 * 声明显示层View接口，在Activity里实现显示
 * */

public interface MainView {
	void showNextType(String id, String user, String pass);

	void showToast();
}
