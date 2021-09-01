package org.techtown.mysolelife.contentsList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.techtown.mysolelife.R

class ContentRVAdapter(val context: Context, val item : ArrayList<ContentModel>) : RecyclerView.Adapter<ContentRVAdapter.Viewholder>() {
    //item click event
    interface ItemClick {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder {
        //inflate
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return Viewholder(v)
    }

    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int) {
        holder.itemView.setOnClickListener { v->
            itemClick?.onClick(v, position)
        }
        //hold하고 있는 거에 매치
        holder.bindItems(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }


    inner class Viewholder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : ContentModel) {
            //itemView : content_rv_item
            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            //item : list 하나하나
            contentTitle.text = item.title

            val contentImage = itemView.findViewById<ImageView>(R.id.imageArea)
            Glide.with(context)
                .load(item.imageUrl)
                .into(contentImage)

        }


    }
}