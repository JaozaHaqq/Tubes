package com.example.tubes_pbb

import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class adapter (private val grid_mhs : List<DataModel>, val listener: (DataModel) -> Unit) :
    RecyclerView.Adapter<adapter.GridViewHolder>() {
    class GridViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fotomhs = view.findViewById<ImageView>(R.id.image1)
        val title = view.findViewById<TextView>(R.id.title)
        val desc = view.findViewById<TextView>(R.id.desc1)

        private val layoutManager = GridLayoutManager(view.context, 2)
        fun bindView(grid_mhs: DataModel, listener: (DataModel) -> Unit) {
            fotomhs.setImageResource((grid_mhs.image))
            title.text = grid_mhs.title
            desc.text = grid_mhs.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.grid, parent, false)
        // create and set the GridLayoutManager with 2 columns
        val layoutManager = GridLayoutManager(parent.context, 2)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int = grid_mhs.size

    override fun onBindViewHolder(
        holder: GridViewHolder, position:
        Int
    ) {
        holder.bindView(grid_mhs[position], listener)
    }
}