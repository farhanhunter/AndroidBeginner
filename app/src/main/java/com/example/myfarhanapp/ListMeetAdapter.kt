package com.example.myfarhanapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myfarhanapp.ListMeetAdapter.*

class ListMeetAdapter(private val listMeet: ArrayList<Meet>): RecyclerView.Adapter<ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.jadwal_meet, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val meet = listMeet[position]
        Glide.with(holder.itemView.context)
            .load(meet.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = meet.name
        holder.tvDetail.text = meet.detail

        holder.itemView.setOnClickListener{ onItemClickCallback.onItemClicked(position)}
    }

    override fun getItemCount(): Int {
        return listMeet.size
    }
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
    interface OnItemClickCallback {
        fun onItemClicked(position: Int)
    }
}