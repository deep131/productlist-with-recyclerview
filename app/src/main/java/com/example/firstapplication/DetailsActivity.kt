package com.example.firstapplication

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)




        val heading:TextView=findViewById(R.id.mainheading)
        val imageview:ImageView=findViewById(R.id.imageView)
        val textviewyear:TextView=findViewById(R.id.textView)
        val details:TextView=findViewById(R.id.details)

        val bundle :Bundle?=intent.extras
        val headings=bundle!!.getString("heading")
        val images=bundle!!.getInt("imageId")
        val years=bundle!!.getString("year")
        val moredetails=bundle!!.getString("details")

        heading.text=headings
        textviewyear.text=years
        details.text=moredetails
        imageview.setImageResource(images)
    }
}


