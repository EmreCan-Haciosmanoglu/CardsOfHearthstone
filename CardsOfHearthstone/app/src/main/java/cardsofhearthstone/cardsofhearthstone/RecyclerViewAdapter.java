package cardsofhearthstone.cardsofhearthstone;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewViewHolder> {
    private Context mContext;
    private ArrayList<MinionCard> mDataList;
    private ListItemClickListener mOnClickListener;

    public RecyclerViewAdapter(Context Context, ArrayList<MinionCard> DataList, ListItemClickListener listener) {
        mContext = Context;
        mDataList=DataList;
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_list_item,viewGroup,false);
        return new RecyclerViewViewHolder(view, mOnClickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder recyclerViewViewHolder, int i) {
        MinionCard clickedData=mDataList.get(i);
        recyclerViewViewHolder.setData(clickedData,i);

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
class RecyclerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView image;
    private  ListItemClickListener mListener;

    public RecyclerViewViewHolder(@NonNull View itemView, ListItemClickListener listener) {
        super(itemView);
        image=itemView.findViewById(R.id.imageView);
        mListener = listener;
        image.setOnClickListener(this);


    }
    public void setData(MinionCard clickedData, int i) {
        Picasso.get().load(clickedData.getImgURL()).into(image);
    }

    @Override
    public void onClick(View v) {
        int clickedPosition = getAdapterPosition();
        mListener.onListItemClick(clickedPosition);
    }
}
