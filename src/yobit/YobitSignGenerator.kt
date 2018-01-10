package yobit

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import java.util.*

class YobitSignGenerator
{
    fun generateSign(secret:String, message:String): String {

        val hmacKey = SecretKeySpec(secret.toByteArray(), "HmacSHA512")

        val hmac = Mac.getInstance("HmacSHA512")
        hmac.init(hmacKey)
        return hex(hmac.doFinal(message.toByteArray(Charsets.UTF_8)))
    }

    private fun hex(bytes: ByteArray): String {
        val formatter = Formatter()

        for (b in bytes) {
            formatter.format("%02x", b)
        }

        return formatter.toString()
    }
}