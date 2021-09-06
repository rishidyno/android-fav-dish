package com.tutorials.eu.favdish.viewmodel

import androidx.lifecycle.*
import com.tutorials.eu.favdish.model.database.FavDishRepository
import com.tutorials.eu.favdish.model.entities.FavDish
import kotlinx.coroutines.launch

class FavDishViewModel(private val repository: FavDishRepository): ViewModel() {

    fun insert(dish:FavDish) = viewModelScope.launch{
        repository.insertFavDishData(dish)
    }
    val allDishesList: LiveData<List<FavDish>> =
        repository.allDishesList.asLiveData()
}

class FavDishViewModelFactory(private val repository:FavDishRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavDishViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return FavDishViewModel(repository) as T

        }
        throw  IllegalAccessException("Unknown ViewModel Class")
    }


}