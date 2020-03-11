package com.example.retrofitbooks.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitbooks.R;
import com.example.retrofitbooks.model.BooksResponse;

public class BooksAdapter
        extends RecyclerView.Adapter<BooksViewHolder> {
    private BooksResponse dataSet;
    private BookItemListener listener;

    public BooksAdapter(BookItemListener listener) {
        this.listener = listener;
    }

    public void setDataSet(BooksResponse dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BooksViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.books_layout,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        holder.onBind(
                dataSet.items.get(position),
                listener
        );
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.items.size() : 0;
    }
}
