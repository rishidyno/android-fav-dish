package com.tutorials.eu.favdish.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tutorials.eu.favdish.databinding.ItemDishLayoutBinding
import com.tutorials.eu.favdish.model.entities.FavDish
import com.tutorials.eu.favdish.view.fragments.AllDishesFragment
import java.util.*

class FavDishAdapter(private val fragment: Fragment) :
    RecyclerView.Adapter<FavDishAdapter.ViewHolder>() {
    private var dishes: List<FavDish> = listOf()


    class ViewHolder(view: ItemDishLayoutBinding) : RecyclerView.ViewHolder(view.root) {
        val dishImage = view.ivDishImage
        val dishTitle = view.tvDishTitle

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavDishAdapter.ViewHolder {
        val binding:ItemDishLayoutBinding = ItemDishLayoutBinding.inflate(
            LayoutInflater.from(fragment.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = dishes[position]
        Glide.with(fragment)
            .load(dish.image)
            .into(holder.dishImage)
        holder.dishTitle.text = dish.title.uppercase()

        holder.itemView.setOnClickListener{
            if(fragment is AllDishesFragment){
                fragment.showDishDetails(dish)
            }
        }

    }

    override fun getItemCount(): Int {
        return dishes.size
    }

    fun dishesList(list: List<FavDish>) {
        dishes = list
        notifyDataSetChanged()
    }


}