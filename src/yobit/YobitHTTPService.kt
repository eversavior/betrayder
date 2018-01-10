package yobit

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class YobitHTTPService {

    fun fuuuuuun() {
        val myURL = URL(serviceURL)
        val myURLConnection = myURL.openConnection() as HttpURLConnection
        val userCredentials = "username:password"
        val basicAuth = "Basic " + String(Base64().encode(userCredentials.toByteArray()))
        myURLConnection.setRequestProperty("Authorization", basicAuth)
        myURLConnection.requestMethod = "POST"
        myURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
        myURLConnection.setRequestProperty("Content-Length", "" + postData.getBytes().length)
        myURLConnection.setRequestProperty("Content-Language", "en-US")
        myURLConnection.useCaches = false
        myURLConnection.doInput = true
        myURLConnection.doOutput = true
    }

    fun buildRequest() {
       // var request:URL = URL("https://youbit.net").getText();
        var url = URL("https://youbit.net");

        with(url.openConnection() as HttpURLConnection) {
            // optional default is GET
            requestMethod = "GET"


            println("\nSending 'GET' request to URL : $url")
            println("Response Code : $responseCode")

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()

                var inputLine = it.readLine()
                while (inputLine != null) {
                    inputLine = it.readLine()
                    response.append(inputLine)
                }
                println(response.toString())
            }
        }
    }
}