package com.dub.dubloader.downloader

import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

internal class StreamManager {

    @Throws(FileNotFoundException::class)
    fun retrieveInputStream(url: String): ByteArray? {
        val conn: HttpURLConnection
        return try {
            conn = openConnection(url)
            conn.connectTimeout = CONNECTION_TIMEOUT_MILLIS
            conn.readTimeout = READ_TIMEOUT_MILLIS
            val `is` = conn.inputStream
            val buffer = ByteArrayOutputStream()
            var nRead: Int
            val data = ByteArray(16384)
            while (`is`.read(data, 0, data.size).also { nRead = it } != -1) {
                buffer.write(data, 0, nRead)
            }
            `is`.close()
            buffer.toByteArray()
        } catch (fnfe: FileNotFoundException) {
            throw fnfe
        } catch (ex: Throwable) {
            null
        }
    }

    @Throws(IOException::class)
    private fun openConnection(url: String): HttpURLConnection {
        return URL(url).openConnection() as HttpURLConnection
    }

    companion object {
        private const val CONNECTION_TIMEOUT_MILLIS = 10000
        private const val READ_TIMEOUT_MILLIS = 10000
    }
}