package com.example.pamtugas4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pamtugas4.ui.theme.PAMTugas4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PAMTugas4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegistrationForm(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun RegistrationForm(modifier: Modifier = Modifier) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header section showing your information
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "235150400111012",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Javier Hafizh Musyaffa",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // Registration form
        Text(
            text = "Form Registrasi",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text("NIM") },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 2,
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )

        Button(
            onClick = {
                // Handle registration logic here
                println("Registrasi - NIM: $nim, Nama: $nama, Email: $email, Alamat: $alamat")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("DAFTAR")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationFormPreview() {
    PAMTugas4Theme {
        RegistrationForm()
    }
}