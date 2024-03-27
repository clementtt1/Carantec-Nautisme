package com.example.carantecnautisme

import com.example.carantecnautisme.models.BateauModel
import com.example.carantecnautisme.models.LieuModel
import com.example.carantecnautisme.models.MomentModel
import com.example.carantecnautisme.models.NiveauModel
import com.example.carantecnautisme.models.PlongeeModel
import com.google.gson.Gson
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

object APIClient {
    private val URI: String = "https://dev-restandroid.users.info.unicaen.fr/api"

    @OptIn(DelicateCoroutinesApi::class)
    fun getJSON(record: String, callback: (String) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            val url = URL(URI + record)
            val connection = url.openConnection() as HttpURLConnection

            if (connection.responseCode == 200) {
                val inputStream = connection.inputStream
                val bufferedReader = BufferedReader(InputStreamReader(inputStream))
                val response = StringBuilder()

                var inputLine: String?
                while (bufferedReader.readLine().also { inputLine = it } != null) {
                    response.append(inputLine)
                }
                bufferedReader.close()
                callback(response.toString())
            }
        }
    }

    fun getAllPlongees(callback: (data: List<PlongeeModel>) -> Unit) {
        this.getJSON("/plongees") {
            val plongees: List<PlongeeModel> = Gson().fromJson(it, Array<PlongeeModel>::class.java).toList()
            callback(plongees)
        }
    }

    fun getAllLieux(callback: (data: List<LieuModel>) -> Unit) {
        this.getJSON("/lieux") {
            val lieux: List<LieuModel> = Gson().fromJson(it, Array<LieuModel>::class.java).toList()
            callback(lieux)
        }
    }

    fun getAllBateaux(callback: (data: List<BateauModel>) -> Unit) {
        this.getJSON("/bateaux") {
            val bateaux: List<BateauModel> = Gson().fromJson(it, Array<BateauModel>::class.java).toList()
            callback(bateaux)
        }
    }

    fun getAllNiveaux(callback: (data: List<NiveauModel>) -> Unit) {
        this.getJSON("/niveaux") {
            val niveaux: List<NiveauModel> = Gson().fromJson(it, Array<NiveauModel>::class.java).toList()
            callback(niveaux)
        }
    }

    fun getAllMoments(callback: (data: List<MomentModel>) -> Unit) {
        this.getJSON("/moments") {
            val moments: List<MomentModel> = Gson().fromJson(it, Array<MomentModel>::class.java).toList()
            callback(moments)
        }
    }

    /* JE SAIS PAS CE QUE C'EST

    fun getLieu(id: Int, callback: (data: LieuModel) -> Unit) {
        this.getJSON("/lieux/$id") {
            val lieu: LieuModel = Gson().fromJson(it, LieuModel::class.java)
            callback(lieu)
        }
    }*/
}