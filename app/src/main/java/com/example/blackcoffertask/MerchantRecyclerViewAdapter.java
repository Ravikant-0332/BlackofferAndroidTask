package com.example.blackcoffertask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackcoffertask.databinding.RecyclerViewItemCard2Binding;
import com.example.blackcoffertask.databinding.RecyclerViewItemCard3Binding;

import java.util.ArrayList;

public class MerchantRecyclerViewAdapter extends RecyclerView.Adapter<MerchantRecyclerViewAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<MerchantData> merchantData;


    MerchantRecyclerViewAdapter(Context context, ArrayList<MerchantData> merchantData){
        this.context = context;
        this.merchantData = merchantData;
    }

    @NonNull
    @Override
    public MerchantRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_item_card3, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(merchantData.get(position).getImage()==-1){
            holder.binding.profileImage.setVisibility(View.INVISIBLE);
        }else{
            holder.binding.profileImage.setImageResource( merchantData.get(position).getImage());
        }

        holder.binding.imageText.setText(merchantData.get(position).getName().replaceAll("^\\s*([a-zA-Z]).*\\s+([a-zA-Z])\\S+$", "$1$2"));
        holder.binding.userName.setText(merchantData.get(position).getName());
        holder.binding.userLocation.setText(merchantData.get(position).getLocation());
        holder.binding.userStatus.setText(merchantData.get(position).getStatus());
        holder.binding.progressBar.setProgress(merchantData.get(position).getProgress());
    }

    @Override
    public int getItemCount() {
        return merchantData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerViewItemCard3Binding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RecyclerViewItemCard3Binding.bind(itemView);
        }
    }
}
