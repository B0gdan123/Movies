package com.example.myproject.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.R
import com.example.myproject.data.DataMovie
import com.example.myproject.view.MoviesActivity
import com.squareup.picasso.Picasso

class CustomAdapter(
    private val mList: List<DataMovie?>,
    val mItemClickListener: MoviesActivity
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsModel = mList[position]
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + mList[position]?.poster_path)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {

        return mList.size

    }

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = this.itemView.findViewById(R.id.imageview)

        init {
            ItemView.setOnClickListener {
                mList.get(position)?.id.let { it ->
                    if (it != null) {
                        mItemClickListener.onItemClick(it)
                    }
                }
            }
        }
    }
}