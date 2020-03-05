package com.example.ecobambonifrontend.ui.containers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecobambonifrontend.R;
import com.example.ecobambonifrontend.data.model.Container;

import java.util.ArrayList;
import java.util.List;

public class ContainerFragment extends Fragment {

    private  ContainerViewModel containerViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.admin_container_card, container, false);

        RecyclerView rv = (RecyclerView) root.findViewById(R.id.containers_view);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);

        List<Container> containers = new ArrayList<>();

        initializeData(containers);

        RVContainersAdapterAdmin rvContainersAdapterAdmin = new RVContainersAdapterAdmin(getContext(), containers);
        rv.setAdapter(rvContainersAdapterAdmin);

        return root;
    }

    private  void initializeData(List<Container> containersList){
        //containersList.add(new Container(1, "SBb", true,   ));
    }
}
