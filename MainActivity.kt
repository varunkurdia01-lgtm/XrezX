package com.example.xrezx

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val PICK_IMAGE = 1001
    private lateinit var imagePreview: ImageView
    private lateinit var scaleSpinner: Spinner
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagePreview = findViewById(R.id.imagePreview)
        scaleSpinner = findViewById(R.id.scaleSpinner)
        progressBar = findViewById(R.id.progressBar)

        scaleSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf("2x","4x","8x"))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            val uri: Uri? = data?.data
            val bmp = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
            imagePreview.setImageBitmap(bmp)
        }
    }
}
