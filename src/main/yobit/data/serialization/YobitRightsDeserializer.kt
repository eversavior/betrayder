package yobit.data.serialization

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import yobit.data.YobitRightsData
import java.lang.reflect.Type

class YobitRightsDeserializer : JsonDeserializer<YobitRightsData> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext?): YobitRightsData {
        return Gson().fromJson<YobitRightsData>(json, YobitRightsData::class.java)
    }
}