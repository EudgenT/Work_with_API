package com.eudge_000.workwithgitapi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class Adapter extends RecyclerView.Adapter<Adapter.Adapter_View_Holder>{


    @Override
    public Adapter_View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Adapter_View_Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class Adapter_View_Holder extends RecyclerView.ViewHolder {

        public Adapter_View_Holder(View itemView) {
            super(itemView);
        }
    }
}
