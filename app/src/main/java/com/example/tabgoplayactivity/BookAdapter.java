package com.example.tabgoplayactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<BookModel> bookList;

    public BookAdapter(Context ctx, ArrayList<BookModel> bookList) {
        inflater = LayoutInflater.from(ctx);
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_books_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.iv.setImageResource(bookList.get(position).getImage());
        holder.name.setText(bookList.get(position).getName());
        holder.price.setText(bookList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,price;
        ImageView iv;

        public MyViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.tv_book_name);
            price = view.findViewById(R.id.tv_book_price);
            iv = view.findViewById(R.id.iv_book);

        }
    }
}
