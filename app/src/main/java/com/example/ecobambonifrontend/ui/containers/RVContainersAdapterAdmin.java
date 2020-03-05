package com.example.ecobambonifrontend.ui.containers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecobambonifrontend.R;
import com.example.ecobambonifrontend.data.model.Container;

import java.util.List;

public class RVContainersAdapterAdmin extends RecyclerView.Adapter<RVContainersAdapterAdmin.ContainerView> {


    @NonNull
    @Override
    public RVContainersAdapterAdmin.ContainerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.admin_container_card, parent, false);
        ContainerView cv = new ContainerView(v);
        return cv;
    }

    @Override
    public void onBindViewHolder(@NonNull ContainerView holder, int position) {
        //holder.ID.
        Container container = containerList.get(position);
        holder.ID.setText(Integer.toString(container.getID()));
        holder.icon.setImageResource(R.drawable.container1);
        holder.location.setText(container.getLocation());
        holder.isReady.setImageResource(container.getIsFull() == 1? R.drawable.check_no_a : R.drawable.check_yes_a);
    }

    @Override
    public int getItemCount() {
        return containerList.size() ;
    }
    List<Container> containerList;
    LayoutInflater inflater;

    public RVContainersAdapterAdmin(Context context, List<Container> containers){
        this.containerList = containers;
        this.inflater = LayoutInflater.from(context);

    }

    public static class ContainerView extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView ID;
        TextView location;
        boolean isNull;
        ImageView icon;
        ImageView isReady;

        public ContainerView(@NonNull View itemView){
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.containers_view);
            location = (TextView)itemView.findViewById(R.id.container_status);
            icon = (ImageView)itemView.findViewById(R.id.container_icon);
            isReady = (ImageView)itemView.findViewById(R.id.container_marker);
            ID = (TextView)itemView.findViewById(R.id.container_id_employee);



        }

    }

}
