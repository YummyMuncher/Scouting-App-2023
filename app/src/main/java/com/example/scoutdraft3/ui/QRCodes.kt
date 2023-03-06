package com.example.scoutdraft3.ui

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter



fun QRStuff(content:String): ImageBitmap {
    val writer = QRCodeWriter()

    val bitMatrix: BitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 488, 488)
    val width: Int = bitMatrix.getWidth()
    val height: Int = bitMatrix.getHeight()
    val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
    for (x in 0 until width)
        for (y in 0 until height)
            bmp.setPixel(x, y, if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE)
    return bmp.asImageBitmap()
}
