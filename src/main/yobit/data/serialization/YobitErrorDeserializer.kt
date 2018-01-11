package yobit.data.serialization

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import yobit.data.YobitError
import java.lang.reflect.Type

class YobitErrorDeserializer: JsonDeserializer<YobitError> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext?): YobitError {
        val error = YobitError(json.asString)

        return error
    }
}