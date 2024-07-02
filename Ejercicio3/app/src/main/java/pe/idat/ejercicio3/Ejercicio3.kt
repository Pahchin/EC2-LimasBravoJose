package pe.idat.ejercicio3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ConciertosPreferencia(val titulo: String, val descripcion: String, val fecha: String)

@Composable
fun lista() {
    var listar by remember { mutableStateOf(false) }
    val conciertosPref = listOf(
        ConciertosPreferencia("Romeo Santos", "Bachata", "01/01/2024"),
        ConciertosPreferencia("Grupo 5", "Cumbia", "01/02/2024"),
        ConciertosPreferencia("Armonia 10", "Cumbia", "01/03/2024"),
        ConciertosPreferencia("Daddy Yankee", "Urbano", "01/04/2024"),
        ConciertosPreferencia("Aventura", "Bachata", "01/05/2024"),
        ConciertosPreferencia("Amen", "Rock", "01/06/2024"),
        ConciertosPreferencia("Grupo Niche", "Salsa", "01/07/2024"),
        ConciertosPreferencia("El gran combo", "Salsa", "01/08/2024"),
        ConciertosPreferencia("Green day", "Rock", "01/09/2025"),
        ConciertosPreferencia("Likin park", "Rock", "01/10/2025")
    )
    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
        Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = { listar = !listar },
                modifier = Modifier.fillMaxWidth(),

            ) {
                Text(text = if (listar) "Ocultar conciertos" else "Ver conciertos")
            }
            if (listar) {
                ListaConciertos(conciertosPref)
            }
        }
    }


@Composable
fun ListaConciertos(conciertosPref: List<ConciertosPreferencia>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 9.dp)
    ) {
        items(conciertosPref) { conciertosPref ->
            ConciertoCard(conciertosPref)
        }
    }
}

@Composable
fun ConciertoCard(concierto: ConciertosPreferencia) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 9.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = concierto.titulo, fontSize = 15.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(9.dp))
            Text(text = concierto.descripcion, fontSize = 15.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(9.dp))
            Text(text = concierto.fecha, fontSize = 15.sp, color = Color.Gray)
        }
    }
}