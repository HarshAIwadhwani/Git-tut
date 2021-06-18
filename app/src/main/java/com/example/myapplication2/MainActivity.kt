package com.example.myapplication2

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.Toast.makeText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "HEY Everyone!! ", Toast.LENGTH_LONG).show()

        var controller: MediaController? = null

        val path = "android.resource://"+packageName + "/"+ R.raw.sample
        val uri = Uri.parse(path)
        videoid.setVideoURI(uri)
        videoid.requestFocus()

        videoid.setOnCompletionListener {
            makeText(this, "Thanks for Watching!! ",Toast.LENGTH_LONG ).show()

        }

        videoid.setOnErrorListener { mp, what, _ ->
            makeText(this,"Error occured!!  Run again.", Toast.LENGTH_LONG).show()
            false
        }
        videoid.setOnPreparedListener {
            videoid.start()
            controller = MediaController(this)
            videoid.setMediaController(controller)
            controller!!.setAnchorView(videoid)
            makeText(this, "Thanks for Watching so much!! ",Toast.LENGTH_LONG ).show()
        }

    }
}