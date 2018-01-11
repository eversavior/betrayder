package yobit.data.serialization

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class YobitErrorType: ParameterizedType {

    override fun getRawType(): Type {
        return YobitErrorType::class.java
    }

    override fun getOwnerType(): Type {
        return YobitErrorType::class.java
    }

    override fun getActualTypeArguments(): Array<Type>? {
        return Array<Type>(0, { i -> getRawType() })
    }

    override fun getTypeName(): String {
        return "error"
    }
}