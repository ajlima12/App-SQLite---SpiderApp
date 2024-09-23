package com.example.spiderapp.ui

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.spiderapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpiderScreen(viewModel: SpiderViewModel) {
    var nome by remember { mutableStateOf("") }
    var universo by remember { mutableStateOf("") }
    var afiliacao by remember { mutableStateOf("") }
    var poderes by remember { mutableStateOf("") }
    var edicao by remember { mutableStateOf("") }
    var selectedSpiderId by remember { mutableStateOf<Int?>(null) }

    val spiderList by viewModel.spiderList.collectAsState(initial = emptyList())

    // Verifica se todos os campos estão preenchidos
    val isFormValid = nome.isNotBlank() && universo.isNotBlank() && afiliacao.isNotBlank() && poderes.isNotBlank() && edicao.isNotBlank()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(listOf(Color(0xFF0D47A1), Color(0xFFB71C1C)))) // Gradiente Azul e Vermelho
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(alpha = 0.9f), RoundedCornerShape(16.dp)) // Fundo branco translúcido
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Cadastro de Aranha",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB71C1C),
                    fontSize = 28.sp
                )
            )

            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = universo,
                onValueChange = { universo = it },
                label = { Text("Universo", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = afiliacao,
                onValueChange = { afiliacao = it },
                label = { Text("Afiliação", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = poderes,
                onValueChange = { poderes = it },
                label = { Text("Poderes", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = edicao,
                onValueChange = { edicao = it },
                label = { Text("Ano de aparição", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Button(
                onClick = {
                    if (isFormValid) {
                        viewModel.addOrUpdateSpider(selectedSpiderId, nome, universo, afiliacao, poderes, edicao.toIntOrNull() ?: 1)
                        nome = ""
                        universo = ""
                        afiliacao = ""
                        poderes = ""
                        edicao = ""
                        selectedSpiderId = null
                    }
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB71C1C), disabledContainerColor = Color(0xFFB71C1C).copy(alpha = 0.5f)),
                enabled = isFormValid
            ) {
                Text(if (selectedSpiderId == null) "Criar Aranha" else "Atualizar Aranha", color = Color.White)
            }

            Text("Aranhas salvos:", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0D47A1)))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(spiderList) { spider ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White.copy(alpha = 0.7f), RoundedCornerShape(8.dp))
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Nome: ${spider.nome}", color = Color.Black)
                            Text(text = "Universo: ${spider.universo}", color = Color.Black)
                            Text(text = "Afiliação: ${spider.afiliacao}", color = Color.Black)
                            Text(text = "Poderes: ${spider.poderes}", color = Color.Black)
                            Text(text = "Edição: ${spider.edicao}", color = Color.Black)
                        }

                        Row {
                            // Botão de editar
                            IconButton(onClick = {
                                nome = spider.nome
                                universo = spider.universo
                                afiliacao = spider.afiliacao
                                poderes = spider.poderes
                                edicao = spider.edicao.toString()
                                selectedSpiderId = spider.id
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.spider_edit_icon),
                                    modifier = Modifier.size(32.dp),
                                    contentDescription = "Editar Aranha",
                                    tint = Color.Unspecified
                                )
                            }
                        }
                        IconButton(onClick = { viewModel.deleteSpider(spider) }) {
                            Icon(
                                painter = painterResource(id = R.drawable.spider_delete_icon),
                                modifier = Modifier.size(32.dp),
                                contentDescription = "Excluir Aranha",
                                tint = Color.Unspecified
                            )
                        }
                    }
                }
            }
        }
    }
}
