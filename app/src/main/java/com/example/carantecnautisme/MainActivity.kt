package com.example.carantecnautisme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

                    if(plongees.value != null){
                        for (plongee in plongees.value!!){
                            for(lieu in lieux.value!!){
                                if(lieu.id == plongee.lieu){
                                    for(bateau in bateaux.value!!){
                                        if(bateau.id == plongee.bateau){
                                            for(niveau in niveaux.value!!) {
                                                if(niveau.id == plongee.niveau){
                                                    for(moment in moments.value!!) {
                                                        if(moment.id == plongee.moment){
                                                            Row {
                                                                Plongees(
                                                                    plongee = plongee,
                                                                    lieu = lieu,
                                                                    bateau = bateau,
                                                                    niveau = niveau,
                                                                    moment = moment
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
fun Plongees(plongee: PlongeeModel, lieu: LieuModel, bateau:BateauModel, niveau:NiveauModel, moment:MomentModel) {
        Column {
            Text(text = plongee.date)
            Text(text = lieu.libelle)
            Text(text = bateau.libelle)
            Text(text = niveau.libelle)
            Text(text = moment.libelle)
        }
        /*Column {
            Text(text = lieu.libelle)
        }
        Column {
            Text(text = bateau.libelle)
        }
        Column {
            Text(text = niveau.libelle)
        }
        Column {
            Text(text = moment.libelle)
        }*/
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