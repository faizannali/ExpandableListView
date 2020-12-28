package com.example.expandablelistview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.faq_card_view.view.*


class FaqAdapter(val con: Context,private val myList:ArrayList<FaqModel>):RecyclerView.Adapter<FaqAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bindItems(faq:FaqModel){
            itemView.question.text=faq.question
            //itemView.answer.text=faq.answer

//            itemView.setOnClickListener {
//                var current=adapterPosition
//                var previous=current
//                if (itemView.isPressed){
//                    itemView.questionLayout.setBackgroundColor(Color.parseColor("#fff1ee"))
//                    itemView.answer.visibility=View.VISIBLE
//                    itemView.arrow_down.visibility=View.GONE
//                    itemView.arrow_up.visibility=View.VISIBLE
//                }else{
//                    itemView.questionLayout.setBackgroundColor(Color.parseColor("#ffffff"))
//                    itemView.answer.visibility=View.GONE
//                    itemView.arrow_down.visibility=View.VISIBLE
//                    itemView.arrow_up.visibility=View.GONE
//                }
//            }

        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.faq_card_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(myList[position])

//        holder.itemView.setOnClickListener {
//            if (holder.itemView.answer.isGone){
//                holder.itemView.questionLayout.setBackgroundColor(Color.parseColor("#fff1ee"))
//                holder.itemView.answer.visibility=View.VISIBLE
//                holder.itemView.arrow_down.visibility=View.GONE
//                holder.itemView.arrow_up.visibility=View.VISIBLE
//            }else if(holder.itemView.answer.isVisible){
//                holder.itemView.questionLayout.setBackgroundColor(Color.parseColor("#ffffff"))
//                holder.itemView.answer.visibility=View.GONE
//                holder.itemView.arrow_down.visibility=View.VISIBLE
//                holder.itemView.arrow_up.visibility=View.GONE
//
//            }
//        }


    }

    override fun getItemCount(): Int {
        return myList.size
    }
}