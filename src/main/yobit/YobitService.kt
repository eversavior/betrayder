package yobit

import http.URLLoader
import http.URLRequest
import java.util.*
import com.google.gson.GsonBuilder
import yobit.data.*
import yobit.data.serialization.YobitErrorDeserializer
import yobit.data.serialization.YobitReturnDeserializer


class YobitService {

    private val signGenerator = YobitSignGenerator()
    private val accounts:HashMap<String, YobitAccount> = HashMap();

    constructor() {
        val myAccount = YobitAccount()
        myAccount.apiKey = "F1E4F74C7784617B8DADB67D3953A158"
        myAccount.secret = "21bf2587d878dd97d8693c6e77bdc6f5"

        fetchAccountInfo(myAccount)
    }

    fun fetchAccountInfo(account:YobitAccount) {
        val data = "{\"success\":1,\"return\":{\"rights\":{\"info\":1,\"trade\":1,\"deposit\":1,\"withdraw\":0},\"funds\":{\"btc\":0,\"doge\":0,\"vk\":0,\"eth\":0,\"nyc\":0,\"ecash\":0,\"trx\":3445.53745932,\"b2x\":0,\"token\":0,\"yay\":0,\"gram\":0,\"b3\":0,\"pac\":36556.40299667,\"usd\":0.00000001,\"rur\":0.00000007},\"funds_incl_orders\":{\"btc\":0,\"doge\":0,\"vk\":0,\"eth\":0,\"nyc\":0,\"ecash\":146.33151951,\"trx\":7680.53745932,\"b2x\":0,\"token\":0,\"yay\":0,\"gram\":0,\"b3\":0,\"pac\":36556.40299667,\"usd\":0.00000001,\"rur\":4799.72697252},\"transaction_count\":0,\"open_orders\":0,\"server_time\":1515691282}}"//buildRequest(account)
        println(data)
        val c = GetInfoData::class.java

        val gson = GsonBuilder()
                .registerTypeAdapter(YobitError::class.java, YobitErrorDeserializer())
                .registerTypeAdapter(YobitReturnData::class.java, YobitReturnDeserializer())
                .create()
        val result:BaseData = gson.fromJson(data, c)

        println(YobitError::class.java.toString())
        println("result error " + result.error.message)
        println("rights " + result.data.rights.deposit)
        println("rights " + result.data.funds.ecash)
        println("rights " + result.data.funds.trx)

        println("rights " + result.data.funds_incl_orders.ecash)
        println("rights " + result.data.funds_incl_orders.trx)

        println("rights " + result.data.transaction_count)
        println("rights " + result.data.server_time)
    }

    fun buildRequest(account:YobitAccount):String {
        val urlRequest = URLRequest("https://yobit.net/tapi/")
        urlRequest.variables.addVariable("nonce", account.nonce.toString())
        urlRequest.variables.addVariable("method", "getInfo")
        urlRequest.connectionTimeout = 5000
        urlRequest.requestMethod = "POST"

        urlRequest.addHeader("Content-Type", "application/x-www-form-urlencoded")
        urlRequest.addHeader("charset", "utf-8")

        val requestParameters = urlRequest.variables.toUrlString()

        val sign = signGenerator.generateSign(account.secret, requestParameters)

        urlRequest.addHeader("Sign", sign)
        urlRequest.addHeader("Key", account.apiKey)

        println(requestParameters)
        println(sign)

        val urlLoader = URLLoader()

        return urlLoader.load(urlRequest);
    }
}