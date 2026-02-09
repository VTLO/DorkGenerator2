package com.dorkgen.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.dorkgen.app.data.database.DorkDatabase
import com.dorkgen.app.data.model.Dork
import com.dorkgen.app.data.repository.DorkRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DorkViewModel(application: Application) : AndroidViewModel(application) {
    
    private val database = Room.databaseBuilder(
        application,
        DorkDatabase::class.java,
        "dork_database"
    ).build()
    
    private val repository = DorkRepository(database.dorkDao())
    
    private val _allDorks = MutableStateFlow<List<Dork>>(emptyList())
    val allDorks: StateFlow<List<Dork>> = _allDorks.asStateFlow()
    
    private val _favoriteDorks = MutableStateFlow<List<Dork>>(emptyList())
    val favoriteDorks: StateFlow<List<Dork>> = _favoriteDorks.asStateFlow()
    
    private val _currentQuery = MutableStateFlow("")
    val currentQuery: StateFlow<String> = _currentQuery.asStateFlow()
    
    private val _selectedEngine = MutableStateFlow("google")
    val selectedEngine: StateFlow<String> = _selectedEngine.asStateFlow()
    
    private val _searchResults = MutableStateFlow<List<Dork>>(emptyList())
    val searchResults: StateFlow<List<Dork>> = _searchResults.asStateFlow()
    
    init {
        loadDorks()
        loadFavorites()
    }
    
    private fun loadDorks() {
        viewModelScope.launch {
            repository.getAllDorks().collect { dorks ->
                _allDorks.value = dorks
            }
        }
    }
    
    private fun loadFavorites() {
        viewModelScope.launch {
            repository.getFavoriteDorks().collect { favorites ->
                _favoriteDorks.value = favorites
            }
        }
    }
    
    fun updateQuery(query: String) {
        _currentQuery.value = query
    }
    
    fun setSearchEngine(engineId: String) {
        _selectedEngine.value = engineId
    }
    
    fun saveDork(query: String, category: String) {
        viewModelScope.launch {
            val dork = Dork(
                query = query,
                category = category,
                searchEngine = _selectedEngine.value
            )
            repository.insertDork(dork)
        }
    }
    
    fun toggleFavorite(dork: Dork) {
        viewModelScope.launch {
            repository.toggleFavorite(dork)
        }
    }
    
    fun deleteDork(dork: Dork) {
        viewModelScope.launch {
            repository.deleteDork(dork)
        }
    }
    
    fun clearHistory() {
        viewModelScope.launch {
            repository.deleteHistory()
        }
    }
    
    fun clearAllData() {
        viewModelScope.launch {
            repository.deleteAllDorks()
        }
    }
    
    fun searchInHistory(query: String) {
        viewModelScope.launch {
            if (query.isEmpty()) {
                _searchResults.value = emptyList()
            } else {
                repository.searchDorks(query).collect { results ->
                    _searchResults.value = results
                }
            }
        }
    }
    
    fun exportDorks(): String {
        // Simple JSON export
        val dorksJson = _allDorks.value.joinToString(",\n") { dork ->
            """
            {
                "query": "${dork.query}",
                "category": "${dork.category}",
                "isFavorite": ${dork.isFavorite},
                "searchEngine": "${dork.searchEngine}"
            }
            """.trimIndent()
        }
        return "[\n$dorksJson\n]"
    }
}
