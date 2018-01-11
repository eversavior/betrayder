package yobit.data

import yobit.Coin

class YobitReturnData {

    var rights:YobitRightsData = YobitRightsData()
    var funds:YobitFunds = YobitFunds()
    var funds_incl_orders:YobitFunds = YobitFunds()
    var transaction_count:Int = 0
    var open_orders:Int = 0
    var server_time:Long = 0
}