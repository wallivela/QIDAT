package com.example.qidat.Views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qidat.Models.books
import com.example.qidat.R
import com.squareup.picasso.Picasso


class BookAdapter(val context: Context):RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    var bookList= mutableListOf<books>()

    fun setListData(data:MutableList<books>){
        bookList= data
    }

    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {
        val v= LayoutInflater.from(ViewGroup.context).inflate(R.layout.card_view_book,
            ViewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val book= bookList[i]
        viewHolder.bin(book)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bin (book:books){

            Picasso.get().load(book.url).into(itemView.findViewById<ImageView>(R.id.bookImg))
            itemView.findViewById<TextView>(R.id.bookTitle).text= book.title
            itemView.findViewById<TextView>(R.id.bookAuthor).text= book.author
            itemView.findViewById<TextView>(R.id.bookPrice).text= book.price.toString()

        }
    }

}