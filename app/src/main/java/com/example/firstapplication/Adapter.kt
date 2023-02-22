package com.example.firstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val langList:ArrayList<Language>): RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private lateinit var mListner:onItemClickListner
interface onItemClickListner{
    fun onItemClick(position: Int)
}
    fun setOnItemClickListner(listner: onItemClickListner){
        mListner=listner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
   val itemView=LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_rows,parent,false)
        return MyViewHolder(itemView,mListner)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem=langList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.heading.text=currentItem.heading
        holder.year.text=currentItem.year    }

    override fun getItemCount(): Int {

        return  langList.size
    }

    class  MyViewHolder(itemView: View,listner: onItemClickListner):RecyclerView.ViewHolder(itemView){

        val titleImage:ImageView=itemView.findViewById(R.id.mImageView)
        val heading:TextView=itemView.findViewById(R.id.mtextView1)
        val year:TextView=itemView.findViewById(R.id.mImageView2)

        init {

            itemView.setOnClickListener {
                listner.onItemClick(adapterPosition)
            }

        }

    }
}