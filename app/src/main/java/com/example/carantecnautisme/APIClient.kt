package com.example.carantecnautisme

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class APIClient {
    private val URI: String = "https://dev-restandroid.users.info.unicaen.fr/api/"

    @OptIn(DelicateCoroutinesApi::class)
    fun get(record: String, callback: (data: JSONObject) -> Unit) {
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
                val jsonObject: JSONObject = JSONObject(response.toString())
                callback(jsonObject)
            }
        }
    }

}