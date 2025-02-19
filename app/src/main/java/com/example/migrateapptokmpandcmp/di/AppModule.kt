package com.example.migrateapptokmpandcmp.di

//import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.migrateapptokmpandcmp.data.UserDatabase
import com.example.migrateapptokmpandcmp.data.UserRepository
import com.example.migrateapptokmpandcmp.presentation.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { UserDatabase.getDatabase(androidContext()).userDao() }
    single { UserRepository(get()) }

    viewModel { MainViewModel(get()) }
}