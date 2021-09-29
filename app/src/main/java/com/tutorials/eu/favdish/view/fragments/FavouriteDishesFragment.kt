package com.tutorials.eu.favdish.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.tutorials.eu.favdish.application.FavDishApplication
import com.tutorials.eu.favdish.databinding.FragmentFavouriteDishesBinding
import com.tutorials.eu.favdish.model.entities.FavDish
import com.tutorials.eu.favdish.view.activities.MainActivity
import com.tutorials.eu.favdish.view.adapters.FavDishAdapter
import com.tutorials.eu.favdish.viewmodel.FavDishViewModel

class FavouriteDishesFragment : Fragment() {


    private var mBinding: FragmentFavouriteDishesBinding? = null

    private val mFavDishViewModel: FavDishViewModel by viewModels {
        FavDishViewModel.FavDishViewModelFactory((requireActivity().application as FavDishApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentFavouriteDishesBinding.inflate(inflater, container, false)

        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFavDishViewModel.favoriteDishesList.observe(viewLifecycleOwner) { dishes ->
            dishes.let {
                mBinding!!.rvFavoriteDishList.layoutManager =
                    GridLayoutManager(requireActivity(), 2)
                val adapter = FavDishAdapter(this)
                mBinding!!.rvFavoriteDishList.adapter = adapter

                if(it.isNotEmpty()){
                    mBinding!!.rvFavoriteDishList.visibility = View.VISIBLE
                    mBinding!!.tvNoFavoriteDishesYet.visibility = View.GONE
                    adapter.dishesList(it)
                }else{
                    mBinding!!.rvFavoriteDishList.visibility = View.GONE
                    mBinding!!.tvNoFavoriteDishesYet.visibility = View.VISIBLE


                }
            }
        }
    }

    fun dishDetails(favDish: FavDish){
        findNavController().navigate(FavouriteDishesFragmentDirections
            .actionNavigationFavoriteDishesToNavigationDishDetail(favDish))

        if(requireActivity() is MainActivity){
            (activity as MainActivity?)!!.hideBottomNavigationView()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

    override fun onResume() {
        super.onResume()
        if (requireActivity() is MainActivity){
            (activity as MainActivity?)!!.showBottomNavigationView()
        }
    }
}