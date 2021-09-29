package com.tutorials.eu.favdish.model.database

import androidx.annotation.WorkerThread
import com.tutorials.eu.favdish.model.entities.FavDish
import kotlinx.coroutines.flow.Flow


// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class FavDishRepository(private val favDishDao: FavDishDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertFavDishData(favDish: FavDish) {
        favDishDao.insertFavDishDetails(favDish)
    }

    val allDishesList: Flow<List<FavDish>> =
        favDishDao.getAllDishesList()

    @WorkerThread
    suspend fun updateFavDishData(favDish : FavDish){
        favDishDao.updateFavDishDetails(favDish)
    }

    val favoriteDishesList: Flow<List<FavDish>> =
        favDishDao.getFavouriteDishesList()

    @WorkerThread
    suspend fun deleteFavDishData(favDish : FavDish){
        favDishDao.deleteFavDishDetails(favDish)
    }
}