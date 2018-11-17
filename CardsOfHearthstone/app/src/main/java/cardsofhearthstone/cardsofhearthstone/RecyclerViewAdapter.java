package cardsofhearthstone.cardsofhearthstone;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewViewHolder> {
    private Context mContext;
    private ArrayList<Datas> mDataList;

    public RecyclerViewAdapter(Context Context, ArrayList<Datas> DataList) {
        mContext = Context;
        mDataList=DataList;
    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_list_item,viewGroup,false);
        return new RecyclerViewViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder recyclerViewViewHolder, int i) {
        Datas clickedData=mDataList.get(i);
        recyclerViewViewHolder.setData(clickedData,i);

    }

    @Override
    public int getItemCount() {
        return Datas.getData().size();
    }
}
class RecyclerViewViewHolder extends RecyclerView.ViewHolder{
    public ImageView image;

    public RecyclerViewViewHolder(@NonNull View itemView) {
        super(itemView);
        image=itemView.findViewById(R.id.imageView);


    }
    public void setData(Datas clickedData, int i) {
        this.image.setImageResource(clickedData.getImageId());
    }
}
