package com.mrlove.navviewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {

    private SavedStateHandle handle;
    private String key = getApplication().getString(R.string.data_key);

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if (!handle.contains(key)) {
            handle.set(key, 0);
        }
    }

    public MutableLiveData<Integer> getNumber() {
        return handle.getLiveData(key);
    }

    public void add(int n) {
        handle.set(key, getNumber().getValue() + n);
    }
}
