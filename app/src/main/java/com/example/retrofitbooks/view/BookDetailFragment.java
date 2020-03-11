package com.example.retrofitbooks.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.retrofitbooks.R;
import com.example.retrofitbooks.model.BookItem;

public class BookDetailFragment extends Fragment {
    public static final String DATA_ITEM =
            BookDetailFragment.class.getSimpleName() + "DATA_ITEM";

    TextView tvBookTitle;
    TextView tvBookRating;
    TextView tvBookPreview;
    TextView tvBookAuthors;

    public static BookDetailFragment getInstance(
            BookItem item
    ) {
        BookDetailFragment fragment =
                new BookDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(DATA_ITEM, item);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(
                R.layout.book_detail_fragment,
                container,
                false
        );
        tvBookTitle = view.findViewById(R.id.tv_book_detail_title);
        tvBookRating = view.findViewById(R.id.tv_book_detail_average_rating);
        tvBookPreview = view.findViewById(R.id.tv_book_detail_preview_link);
        tvBookAuthors = view.findViewById(R.id.tv_book_detail_authors);
        return view;
    }

    public void setData() {
        Bundle bundle = getArguments();
        BookItem item = bundle.getParcelable(DATA_ITEM);
        tvBookTitle.setText(item.volumeInfo.title);
        tvBookRating.setText(item.volumeInfo.averageRatingToString());
        tvBookPreview.setText(item.volumeInfo.previewLink);
//        tvBookAuthors.setText(item.volumeInfo.authorsToString());
    }
}
