package com.codestomp.androidfbshimmerloader

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.codestomp.androidfbshimmerloader.databinding.RowMainPostsBinding
import java.util.*

class MainPostsAdapter(
    private val mainCatsList: ArrayList<Post>
) :
    RecyclerView.Adapter<MainPostsAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = RowMainPostsBinding.bind(itemView)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_main_posts, viewGroup, false)
        return ItemViewHolder(v)
    }

    override fun getItemCount(): Int {
        Log.e("Size->", mainCatsList.size.toString())
        return mainCatsList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = mainCatsList[position]

        holder.binding.tvPostTitle.text = currentItem.title
        holder.binding.tvPostDesc.text = currentItem.desc

    }


}