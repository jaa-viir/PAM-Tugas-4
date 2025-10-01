package com.example.pamtugas4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pamtugas4.ui.theme.PAMTugas4Theme

class Daftar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PAMTugas4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF0A192F)
                ) {
                    RegistrationForm(
                        onBackToLogin = {
                            finish() // Close Daftar and go back to Login
                        },
                        onDaftarClick = { nim, nama ->
                            // Navigate to Detail screen with data
                            val intent = Intent(this, Detail::class.java)
                            intent.putExtra("NIM", nim)
                            intent.putExtra("NAMA", nama)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun RegistrationForm(
    onBackToLogin: () -> Unit,
    onDaftarClick: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var nim by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Header card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF112240)),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "235150400111012",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Javier Hafizh Musyaffa",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        // Title
        Text(
            text = "Form Registrasi",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        // Input fields
        OutlinedTextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text("NIM") },
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors()
        )

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors()
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 2,
            colors = textFieldColors()
        )

        // Submit button
        Button(
            onClick = {
                println("Registrasi - NIM: $nim, Nama: $nama, Email: $email, Alamat: $alamat")

                if (nim.isNotEmpty() && nama.isNotEmpty() && email.isNotEmpty() && alamat.isNotEmpty()) {
                    println("Registration successful!")
                    onDaftarClick(nim, nama)
                } else {
                    println("Please fill in all fields")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("DAFTAR")
        }

        // Back to Login button
        TextButton(onClick = onBackToLogin) {
            Text(
                text = "Kembali ke Login",
                color = Color.LightGray,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun textFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedContainerColor = Color.Transparent,
    unfocusedContainerColor = Color.Transparent,
    focusedTextColor = Color.White,
    unfocusedTextColor = Color.White,
    focusedLabelColor = Color.White,
    unfocusedLabelColor = Color.LightGray,
    focusedBorderColor = Color.White,
    unfocusedBorderColor = Color.Gray
)

@Preview(showBackground = true)
@Composable
fun RegistrationFormPreview() {
    PAMTugas4Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF0A192F)
        ) {
            RegistrationForm(
                onBackToLogin = {},
                onDaftarClick = { _, _ -> }
            )
        }
    }
}