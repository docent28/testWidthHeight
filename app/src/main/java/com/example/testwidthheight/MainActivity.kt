package com.example.testwidthheight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.Toast
import com.example.testwidthheight.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

var elementHeight = 0
var elementWidth = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        countWidthHeight()
    }

    fun countWidthHeight() {
        val frameLayout = binding.container
        frameLayout.getViewTreeObserver()
            .addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    frameLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this)
                    elementHeight = frameLayout.height
                    elementWidth = frameLayout.width
//                    Toast.makeText(
//                        this@MainActivity,
//                        "HEIGHT = $elementHeight",
//                        Toast.LENGTH_LONG
//                    ).show()
                    binding.container.top = 350
                    binding.container.left = 350
                }
            })
    }
}