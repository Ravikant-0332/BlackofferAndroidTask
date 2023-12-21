package com.example.blackcoffertask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackcoffertask.databinding.RecyclerViewItemCard2Binding;
import com.example.blackcoffertask.databinding.RecyclerViewItemCardBinding;

import java.util.ArrayList;

public class BusinessRecyclerViewAdapter extends RecyclerView.Adapter<BusinessRecyclerViewAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<BusinessData> businessData;


    BusinessRecyclerViewAdapter(Context context, ArrayList<BusinessData> businessData){
        this.context = context;
        this.businessData = businessData;
    }

    @NonNull
    @Override
    public BusinessRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_item_card2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(businessData.get(position).getImage()==-1){
            holder.binding.profileImage.setVisibility(View.INVISIBLE);
        }else{
            holder.binding.profileImage.setImageResource( businessData.get(position).getImage());
        }

        holder.binding.imageText.setText(businessData.get(position).getName().replaceAll("^\\s*([a-zA-Z]).*\\s+([a-zA-Z])\\S+$", "$1$2"));
        holder.binding.userName.setText(businessData.get(position).getName());
        holder.binding.userLocation.setText(businessData.get(position).getLocation());
        holder.binding.userExperience .setText(businessData.get(position).getExperience());
        holder.binding.userStatus.setText(businessData.get(position).getStatus());
        holder.binding.progressBar.setProgress(businessData.get(position).getProgress());

        String inviteStatus = businessData.get(position).getInviteStatus();
        if(inviteStatus.equals("PENDING")){
            holder.binding.inviteBtn.setTextColor(context.getColor(R.color.base_light));
        }
        holder.binding.inviteBtn.setText(inviteStatus);
        holder.binding.inviteBtn.setEnabled(false);
    }

    @Override
    public int getItemCount() {
        return businessData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerViewItemCard2Binding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RecyclerViewItemCard2Binding.bind(itemView);
        }
    }
}
