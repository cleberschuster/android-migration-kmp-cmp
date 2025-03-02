package com.example.migrateapptokmpandcmp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.migrateapptokmpandcmp.data.User
import com.example.migrateapptokmpandcmp.ui.theme.MigrateAppToKmpAndCmpTheme

@Composable
fun UserScreen(
    users: List<User>,
    insert: (User) -> Unit,
    update: (User) -> Unit,
    delete: (User) -> Unit,
    deleteAll: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                val userName = (1..10).map { ('a'..'z').random() }.joinToString("")
                insert(User(name = userName))
            }) {
                Text(text = "Add User")
            }

            Button(onClick = {
                if (users.isNotEmpty()) {
                    update(User(id = users[0].id, name = "Updated ${users[0].name}"))
                }
            }) {
                Text(text = "Update First User")
            }

            Button(onClick = {
                if (users.isNotEmpty()) {
                    delete(users[0])
                }
            }) {
                Text(text = "Delete First User")
            }

            Button(onClick = { deleteAll() }) {
                Text(text = "Delete All Users")
            }


            LazyColumn(modifier = Modifier.weight(1f)) {
                items(users) { user ->
                    Text(text = user.name, style = MaterialTheme.typography.titleLarge)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MigrateAppToKmpAndCmpTheme {
        UserScreen(
            users = listOf(User(name = "User 1"), User(name = "User 2")),
            insert = {},
            update = {},
            delete = {},
            deleteAll = {}
        )
    }
}