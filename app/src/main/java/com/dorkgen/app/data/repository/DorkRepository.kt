package com.dorkgen.app.data.repository

import com.dorkgen.app.data.database.DorkDao
import com.dorkgen.app.data.model.Dork
import kotlinx.coroutines.flow.Flow

class DorkRepository(private val dorkDao: DorkDao) {
    
    fun getAllDorks(): Flow<List<Dork>> = dorkDao.getAllDorks()
    
    fun getFavoriteDorks(): Flow<List<Dork>> = dorkDao.getFavoriteDorks()
    
    fun getDorksByCategory(category: String): Flow<List<Dork>> = 
        dorkDao.getDorksByCategory(category)
    
    fun searchDorks(query: String): Flow<List<Dork>> = 
        dorkDao.searchDorks(query)
    
    suspend fun insertDork(dork: Dork): Long = dorkDao.insertDork(dork)
    
    suspend fun updateDork(dork: Dork) = dorkDao.updateDork(dork)
    
    suspend fun deleteDork(dork: Dork) = dorkDao.deleteDork(dork)
    
    suspend fun deleteAllDorks() = dorkDao.deleteAllDorks()
    
    suspend fun deleteHistory() = dorkDao.deleteHistory()
    
    suspend fun toggleFavorite(dork: Dork) {
        dorkDao.updateDork(dork.copy(isFavorite = !dork.isFavorite))
    }
}
