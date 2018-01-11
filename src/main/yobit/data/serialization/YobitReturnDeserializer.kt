package yobit.data.serialization

import com.google.gson.*
import yobit.data.YobitFunds
import yobit.data.YobitReturnData
import yobit.data.YobitRightsData
import java.lang.reflect.Type

class YobitReturnDeserializer : JsonDeserializer<YobitReturnData> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext?): YobitReturnData {
        val gson = GsonBuilder()
                .registerTypeAdapter(YobitRightsData::class.java, YobitRightsDeserializer())
        //        .registerTypeAdapter(YobitFunds::class.java, YobitFundsDeserializer())
                .create()

        return gson.fromJson(json, YobitReturnData::class.java)
    }
}