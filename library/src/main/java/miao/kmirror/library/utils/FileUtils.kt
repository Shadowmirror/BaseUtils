package miao.kmirror.library.utils

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore


object FileUtils {
    @SuppressLint("Range")
    fun getFileFromContentUri(context: Context, uri: Uri?): String {
        uri ?: return ""
        val filePath: String
        val filePathColumn = arrayOf(MediaStore.DownloadColumns.DATA, MediaStore.DownloadColumns.DISPLAY_NAME)
        val contentResolver = context.contentResolver
        val cursor: Cursor? = contentResolver.query(
            uri,
            filePathColumn,
            null,
            null,
            null
        )
        if (cursor != null) {
            cursor.moveToFirst()
            try {
                filePath = cursor.getString(cursor.getColumnIndex(filePathColumn[0]))
                return filePath
            } catch (e: Exception) {
            } finally {
                cursor.close()
            }
        }
        return ""
    }
}