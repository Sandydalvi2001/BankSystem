package com.example.bankingsystem;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapterUserList extends RecyclerView.Adapter<ViewHolder> {


    SingleActivity UserList;
    List<Model> modelList;
    Context context;

    public CustomAdapterUserList(SingleActivity userList, List<Model> modelList) {
        this.UserList = userList;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                UserList.nextActivity(position);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mName.setText(modelList.get(position).getName());
        holder.mPhonenumber.setText(modelList.get(position).getPhone_no());
        holder.mBalance.setText(modelList.get(position).getBalance());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
///////////////////////////////////////

//    SingleActivity UserList;
//    List<Model> modelList;
//    Context context;
//
//    public CustomAdapterUserList(SingleActivity userList, List<Model> modelList) {
//        this.UserList = userList;
//        this.modelList = modelList;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user_list, parent, false);
//
//        ViewHolder viewHolder = new ViewHolder(itemView);
//        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                UserList.nextActivity(position);
//            }
//        });
//
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.mName.setText(modelList.get(position).getName());
//        holder.mPhonenumber.setText(modelList.get(position).getPhone_no());
//        holder.mBalance.setText(modelList.get(position).getBalance());
//    }
//
//    @Override
//    public int getItemCount() {
//        return modelList.size();
//    }
//}


//    SingleActivity usersList;
//    List<Model> modelList;
//    Context context;
//
//    public CustomAdapterUserList(SingleActivity usersList, List<Model> modelList) {
//        this.usersList=usersList;
//        this.modelList = modelList;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user_list,parent,false);
//
//        ViewHolder viewHolder=new ViewHolder(itemView);
//        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.P)
//            @Override
//            public void onItemClick(View view, int position) {
//                usersList.nextActivity(position);
//            }
//        });
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.mName.setText(modelList.get(position).getName());
//        holder.mPhoneNumber.setText(modelList.get(position).getPhone_no());
//        holder.mBalance.setText(modelList.get(position).getBalance());
//
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return modelList.size();
//    }
//}
