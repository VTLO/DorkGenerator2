package com.dorkgen.app.data.database

import androidx.room.*
import com.dorkgen.app.data.model.Dork
import kotlinx.coroutines.flow.Flow

@Dao
interface DorkDao {
    @Query("SELECT * FROM dorks ORDER BY timestamp DESC")
    fun getAllDorks(): Flow<List<Dork>>
    
    @Query("SELECT * FROM dorks WHERE isFavorite = 1 ORDER BY timestamp DESC")
    fun getFavoriteDorks(): Flow<List<Dork>>
    
    @Query("SELECT * FROM dorks WHERE category = :category ORDER BY timestamp DESC")
    fun getDorksByCategory(category: String): Flow<List<Dork>>
    
    @Query("SELECT * FROM dorks WHERE query LIKE '%' || :searchQuery || '%' ORDER BY timestamp DESC")
    fun searchDorks(searchQuery: String): Flow<List<Dork>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDork(dork: Dork): Long
    
    @Update
    suspend fun updateDork(dork: Dork)
    
    @Delete
    suspend fun deleteDork(dork: Dork)
    
    @Query("DELETE FROM dorks")
    suspend fun deleteAllDorks()
    
    @Query("DELETE FROM dorks WHERE isFavorite = 0")
    suspend fun deleteHistory()
}

@Database(entities = [Dork::class], version = 1, exportSchema = false)
abstract class DorkDatabase : RoomDatabase() {
    abstract fun dorkDao(): DorkDao
}
