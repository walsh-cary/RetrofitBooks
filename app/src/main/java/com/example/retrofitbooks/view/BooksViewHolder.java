package com.example.retrofitbooks.view;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitbooks.R;
import com.example.retrofitbooks.model.BookItem;

public class BooksViewHolder extends RecyclerView.ViewHolder {

    ImageView ivBookCover;

    public BooksViewHolder(@NonNull View itemView) {
        super(itemView);
        ivBookCover = itemView.findViewById(R.id.iv_cover_book);
    }

    public void onBind(BookItem item,
                       BookItemListener listener) {
        //todo Picasso
        Glide.with(itemView).load(
                item.volumeInfo.imageLinks
        ).into(ivBookCover);
        itemView.setOnClickListener(view -> {
            listener.showBookInfo(item);
        });
    }
}
