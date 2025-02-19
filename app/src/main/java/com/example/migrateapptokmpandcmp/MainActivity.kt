package com.example.migrateapptokmpandcmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.migrateapptokmpandcmp.presentation.MainViewModel
import com.example.migrateapptokmpandcmp.presentation.UserScreen
import com.example.migrateapptokmpandcmp.ui.theme.MigrateAppToKmpAndCmpTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModel<MainViewModel>()
//    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MigrateAppToKmpAndCmpTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Surface(modifier = Modifier.fillMaxSize()) {
                    val users by viewModel.allUsers.collectAsState(initial = emptyList())

                    UserScreen(
                        users = users,
                        insert = { viewModel.insert(it) },
                        update = { viewModel.update(it) },
                        delete = { viewModel.delete(it) },
                        deleteAll = { viewModel.deleteAll() }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MigrateAppToKmpAndCmpTheme {
        Greeting("Android")
    }
}