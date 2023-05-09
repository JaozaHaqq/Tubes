package com.example.tubes_pbb

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.List

class adapter_grid(private val context: Context, private val dataList: List<DataModel>, val listener: (DataModel) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.grid, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int){ val myHolder = holder as MyViewHolder
        myHolder.bindView(dataList[position], listener) }

    override fun getItemCount(): Int {
        return dataList.size }

    inner class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val cardView1 = itemView.findViewById<CardView>(R.id.card_view1)
        val fotomhs1 = itemView.findViewById<ImageView>(R.id.image1)
        val title1 = itemView.findViewById<TextView>(R.id.title1)
        val desc1 = itemView.findViewById<TextView>(R.id.desc1)
        fun bindView(mhs: DataModel, listener: (DataModel) -> Unit) {
            cardView1.setOnClickListener {
                listener(mhs)
                val intent = Intent(context, Deskripsi::class.java)
                intent.putExtra("nama_mahasiswa", mhs.title)
                intent.putExtra("nim_mahasiswa", mhs.desc)
                context.startActivity(intent)
            }
            fotomhs1.setImageResource(mhs.image)
            title1.text = mhs.title
            desc1.text = mhs.desc
        }
    }
}