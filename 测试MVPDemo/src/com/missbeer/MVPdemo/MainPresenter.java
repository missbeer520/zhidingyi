package com.missbeer.MVPdemo;

import android.content.Context;

import com.missbeer.MVPdemo.MainModel.MainModelSate;

/*
 * 声明Presenter控制层，可实现一些Model接口下的方法
 */
public class MainPresenter implements MainModelSate {
	private MainModel mainModel;
	private MainView mainView;

	public MainPresenter(MainView mainView) {
		super();
		this.mainView = mainView;
		mainModel = new MainUserModel(this);
	}

	public void mainUser(Context context, String id, String user, String pass) {
		mainModel.examComply(context, id, user, pass);
	}

	public void mainLoadUser(Context context) {
		mainModel.setLoadData(context);
	}

	@Override
	public void mainView(Context context, String id, String user, String pass) {
		mainView.showNextType(id, user, pass);
	}

	@Override
	public void mainToast() {
		mainView.showToast();
	}

}
