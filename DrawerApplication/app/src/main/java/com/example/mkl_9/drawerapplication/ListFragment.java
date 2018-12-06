package com.example.mkl_9.drawerapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result= inflater.inflate(R.layout.fragment_list,container,false);
        ListRecylerAdapter adapter=new ListRecylerAdapter(getActivity());
        RecyclerView recyclerView=container.findViewById(R.id.list_recyler);
        return result;
    }
}
