package com.example.mkl_9.drawerapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;




public class ListRecylerAdapter extends RecyclerView.Adapter<ListRecylerViewHolder> {
    Context mContext;
    public ListRecylerAdapter(Context Context) {
        mContext = Context;

    }
    @NonNull
    @Override
    public ListRecylerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListRecylerViewHolder listRecylerViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
class ListRecylerViewHolder extends RecyclerView.ViewHolder {

    public ListRecylerViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
