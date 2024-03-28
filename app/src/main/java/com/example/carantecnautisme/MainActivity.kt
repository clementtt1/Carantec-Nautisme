package com.example.carantecnautisme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carantecnautisme.models.BateauModel
import com.example.carantecnautisme.models.LieuModel
import com.example.carantecnautisme.models.MomentModel
import com.example.carantecnautisme.models.NiveauModel
import com.example.carantecnautisme.models.PlongeeModel
import com.example.carantecnautisme.ui.theme.CarantecNautismeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarantecNautismeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val plongees: MutableState<List<PlongeeModel>?> = remember { mutableStateOf(null) }
                    APIClient.getAllPlongees { plongees.value = it }

                    val lieux: MutableState<List<LieuModel>?> = remember { mutableStateOf(null) }
                    APIClient.getAllLieux { lieux.value = it }

                    val bateaux: MutableState<List<BateauModel>?> = remember { mutableStateOf(null) }
                    APIClient.getAllBateaux { bateaux.value = it }

                    val niveaux: MutableState<List<NiveauModel>?> = remember { mutableStateOf(null) }
                    APIClient.getAllNiveaux { niveaux.value = it }

                    val moments: MutableState<List<MomentModel>?> = remember { mutableStateOf(null) }
                    APIClient.getAllMoments { moments.value = it }

                    LazyColumn() {
                        if(plongees.value != null){
                            items(plongees.value!!) { plongee ->
                                for(lieu in lieux.value!!){
                                    if(lieu.id == plongee.lieu){
                                        for(bateau in bateaux.value!!){
                                            if(bateau.id == plongee.bateau){
                                                for(niveau in niveaux.value!!) {
                                                    if(niveau.id == plongee.niveau){
                                                        for(moment in moments.value!!) {
                                                            if(moment.id == plongee.moment){
                                                                Plongees(
                                                                    plongee = plongee,
                                                                    lieu = lieu,
                                                                    bateau = bateau,
                                                                    niveau = niveau,
                                                                    moment = moment,
                                                                    nb_max_plongeur = plongee.max_plongeurs
                                                                )
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Plongees(plongee: PlongeeModel, lieu: LieuModel, bateau:BateauModel, niveau:NiveauModel, moment:MomentModel, nb_max_plongeur:Int) {
        Row(modifier = Modifier
            .padding(15.dp)
            .border(BorderStroke(1.dp, Color.Black))
            .fillMaxWidth()
            .padding(15.dp)) {
            Column {
                Text(text = plongee.date)
                Text(text = lieu.libelle)
                Text(text = bateau.libelle)
                Text(text = niveau.libelle)
                Text(text = moment.libelle)
                Text(text = nb_max_plongeur.toString())
            }
            Column {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "S'inscrire")
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
    CarantecNautismeTheme {
        Greeting("Android")
    }
}