package com.example.ecobambonifrontend.ui.containers;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecobambonifrontend.EmployeeActivity;
import com.example.ecobambonifrontend.R;
import com.example.ecobambonifrontend.data.model.Container;
import com.example.ecobambonifrontend.ui.DialogInfoFragment;

import java.util.List;

public class RVContainersAdapterEmployee extends RecyclerView.Adapter<RVContainersAdapterEmployee.ContainerView> {

    EmployeeActivity activity;
    @NonNull
    @Override
    public RVContainersAdapterEmployee.ContainerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.employee_container_card, parent, false);
        RVContainersAdapterEmployee.ContainerView cv = new RVContainersAdapterEmployee.ContainerView(v);
        return cv;
    }

    @Override
    public void onBindViewHolder(@NonNull RVContainersAdapterEmployee.ContainerView holder, int position) {
        //holder.ID.
        Container container = containerList.get(position);
        holder.ID.setText(Integer.toString(container.getID()));
        holder.icon.setImageResource(R.drawable.container1);
        holder.status.setText(container.getIsFull() == 1? R.string.full : R.string.empty);

    }

    @Override
    public int getItemCount() {
        return containerList.size() ;
    }
    List<Container> containerList;
    LayoutInflater inflater;

    public RVContainersAdapterEmployee(Context context, List<Container> containers){
        this.containerList = containers;
        this.inflater = LayoutInflater.from(context);
        this.activity = (EmployeeActivity) context;

    }

    public RVContainersAdapterEmployee(Context context, List<Container> containers,int lol){
        this.containerList = containers;
        this.inflater = LayoutInflater.from(context);

    }

    public static class ContainerView extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView ID;
        TextView status;
        boolean isNull;
        ImageView icon;

        //ImageView isReady;

        public ContainerView(@NonNull View itemView){
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cv);
            status = (TextView)itemView.findViewById(R.id.container_status);
            icon = (ImageView)itemView.findViewById(R.id.container_icon);
            ID = (TextView)itemView.findViewById(R.id.container_id_employee);


        }

    }

}
