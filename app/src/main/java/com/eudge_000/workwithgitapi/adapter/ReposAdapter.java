package com.eudge_000.workwithgitapi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eudge_000.workwithgitapi.R;
import com.eudge_000.workwithgitapi.model.Repo;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.AdapterViewHolder>{

    private List<Repo> mDataSource = null;

    public void setDataSource(List<Repo> list) {
        mDataSource = list;
        notifyDataSetChanged();
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.view_item, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        final Repo repo = mDataSource.get(position);
        holder.bind(repo);
    }

    @Override
    public int getItemCount() {
        return mDataSource == null ? 0 : mDataSource.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.primary_text_view);
        }

        public void bind(Repo repo) {
            mTextView.setText(repo.getName());

        }
    }
}
