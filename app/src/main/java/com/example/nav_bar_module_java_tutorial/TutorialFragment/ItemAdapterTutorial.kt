package com.example.nav_bar_module_java_tutorial.TutorialFragment

import com.example.nav_bar_module_java_tutorial.ProgramAndSyntaxFragment.NestedAdapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nav_bar_module_java_tutorial.R

class ItemAdapterTutorial(private val mList: ArrayList<DataModalTutorial>) : RecyclerView.Adapter<ItemAdapterTutorial.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item_tutorial, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val model = mList[position]
        holder.mTextView.text = model.itemText

        // Set LinearLayoutManager with horizontal orientation
        val layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.VERTICAL, false)
        holder.nestedRecyclerView.layoutManager = layoutManager

        val adapter = NestedAdapterTutorial(model.nestedList)
        holder.nestedRecyclerView.setHasFixedSize(true)
        holder.nestedRecyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTextView: TextView = itemView.findViewById(R.id.text_heading)
        val nestedRecyclerView: RecyclerView = itemView.findViewById(R.id.nested_rv_tutorial)
    }
}
