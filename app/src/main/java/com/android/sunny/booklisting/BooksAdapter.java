package com.android.sunny.booklisting;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Sunny on 1/8/2017.
 */

public class BooksAdapter extends BaseAdapter {

    Context context;
    ArrayList<Books> books;

    BooksAdapter(Context context, ArrayList<Books> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {

        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = convertView;
        ViewHolder viewHolder = null;

        if (rootView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootView = layoutInflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(rootView);
            rootView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) rootView.getTag();
        }

        Books book = books.get(position);
        viewHolder.textViewTitle.setText(book.getmBookTitle());
        viewHolder.textViewAuthor.setText(book.getmBookAuthor());

        String imageURL = book.getmBookPosterPath();
        if (imageURL != null) {

            Picasso.with(context)
                    .load(imageURL)
                    .into(viewHolder.imageView);
        } else {
            viewHolder.imageView.setImageResource(R.drawable.no_image_icon);
        }
        return rootView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewAuthor;

        ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.image_view);
            textViewTitle = (TextView) view.findViewById(R.id.book_title_text_view);
            textViewAuthor = (TextView) view.findViewById(R.id.book_author_text_view);
        }
    }
}
