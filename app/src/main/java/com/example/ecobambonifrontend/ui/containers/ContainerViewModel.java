package com.example.ecobambonifrontend.ui.containers;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContainerViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ContainerViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is notification fragment");
    }

    public MutableLiveData<String> getText() {
        return mText;
    }
}
