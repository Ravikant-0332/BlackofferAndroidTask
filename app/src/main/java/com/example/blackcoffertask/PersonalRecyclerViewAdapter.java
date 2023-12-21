package com.example.blackcoffertask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackcoffertask.databinding.RecyclerViewItemCardBinding;

import java.util.ArrayList;

public class PersonalRecyclerViewAdapter extends RecyclerView.Adapter<PersonalRecyclerViewAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<UserData> userData;


    PersonalRecyclerViewAdapter(Context context, ArrayList<UserData> userData){
        this.context = context;
        this.userData = userData;
    }

    @NonNull
    @Override
    public PersonalRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_item_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(userData.get(position).getImage()==-1){
            holder.binding.profileImage.setVisibility(View.INVISIBLE);
        }else{
            holder.binding.profileImage.setImageResource( userData.get(position).getImage());
        }

        holder.binding.imageText.setText(userData.get(position).getName().replaceAll("^\\s*([a-zA-Z]).*\\s+([a-zA-Z])\\S+$", "$1$2"));
        holder.binding.userName.setText(userData.get(position).getName());
        holder.binding.userLocation.setText(userData.get(position).getLocation());
        holder.binding.userDistance.setText(userData.get(position).getDistance());
        holder.binding.userInterest.setText(userData.get(position).getInterest());
        holder.binding.userStatus.setText(userData.get(position).getStatus());
        holder.binding.progressBar.setProgress(userData.get(position).getProgress());

        String inviteStatus = userData.get(position).getInviteStatus();
        if(inviteStatus.equals("PENDING")){
            holder.binding.inviteBtn.setTextColor(context.getColor(R.color.base_light));
        }
        holder.binding.inviteBtn.setText(inviteStatus);
        holder.binding.inviteBtn.setEnabled(false);
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerViewItemCardBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RecyclerViewItemCardBinding.bind(itemView);
        }
    }
}
