package yobit.data.serialization

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import yobit.Coin
import yobit.data.YobitRightsData
import java.lang.reflect.Type

class YobitFundsDeserializer: JsonDeserializer<Array<Coin>> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext?): Array<Coin> {
        var data = Gson().fromJson<Array<Coin>>(json, Array<Coin>::class.java)

        return data
    }
}
