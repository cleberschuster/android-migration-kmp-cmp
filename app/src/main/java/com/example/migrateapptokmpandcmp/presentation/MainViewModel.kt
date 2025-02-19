package com.example.migrateapptokmpandcmp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.migrateapptokmpandcmp.data.User
import com.example.migrateapptokmpandcmp.data.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: UserRepository) : ViewModel() {
    val allUsers: Flow<List<User>> = repository.allUsers

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }

    fun update(user: User) = viewModelScope.launch {
        repository.update(user)
    }

    fun delete(user: User) = viewModelScope.launch {
        repository.delete(user)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }
}