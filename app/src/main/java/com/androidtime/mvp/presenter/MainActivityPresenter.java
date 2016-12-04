package com.androidtime.mvp.presenter;

import java.util.HashMap;

import com.androidtime.mvp.interfaces.MainActivityView;
import com.androidtime.mvp.interfaces.OnRequestComplete;
import com.androidtime.mvp.model.InvokeApi;


public class MainActivityPresenter {
    MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    public void getIpInformation() {
        view.startLoading();
        new InvokeApi(view.getAppContext(), new OnRequestComplete() {
            @Override
            public void onRequestComplete(Object infoData) {
                view.stopLoading();
                view.showIpInfo((HashMap) infoData);
            }
        });
    }


}
