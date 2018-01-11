package yobit.data

import yobit.Coin
import java.util.*

class YobitFunds {

    var trx:Double = 0.0
    var btc:Double = 0.0
    var usd:Double = 0.0
    var rur:Double = 0.0
    var gram:Double = 0.0
    var ecash:Double = 0.0
    var vk:Double = 0.0

    var coins:HashMap<String, Coin> = HashMap()
}