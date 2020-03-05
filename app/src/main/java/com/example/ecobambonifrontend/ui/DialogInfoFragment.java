package com.example.ecobambonifrontend.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogInfoFragment extends DialogFragment {

    String ID;
    String location;


    public DialogInfoFragment(String ID, String location){
        this.ID = ID;
        this.location = location;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder.setTitle("Контейнер " + ID).setMessage(location).create();
    }
}
