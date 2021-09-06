package com.tutorials.eu.favdish.view.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tutorials.eu.favdish.databinding.ItemCostomListBinding
import com.tutorials.eu.favdish.view.activities.AddUpdateDishActivity

class CustomListItemAdapter(
    private val activity: Activity,
    private val listItems: List<String>,
    private val selection: String
) : RecyclerView.Adapter<CustomListItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCostomListBinding =
            ItemCostomListBinding.inflate(LayoutInflater.from(activity), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItems[position]
        holder.tvText.text = item

        holder.itemView.setOnClickListener {
            if (activity is AddUpdateDishActivity) {
                activity.selectedListItem(item, selection)
            }
        }

    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    class ViewHolder(view: ItemCostomListBinding) : RecyclerView.ViewHolder(view.root) {
        val tvText = view.tvText
    }


}