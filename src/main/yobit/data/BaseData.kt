package yobit.data

import com.google.gson.annotations.SerializedName

open class BaseData {
    var success:Int = -1

    var error: YobitError = YobitError("no error")

    @SerializedName("return")
    var data:YobitReturnData = YobitReturnData()
}