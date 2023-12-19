package com.example.testwidthheight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.FrameLayout
import com.example.testwidthheight.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

var elementHeight = 0
var elementWidth = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun drawElement() {

    }

    override fun onResume() {
        super.onResume()
        countWidthHeight()
        val layoutParams = FrameLayout.LayoutParams(150, 150)
        layoutParams.topMargin = 150
        layoutParams.leftMargin = 200
    }

    fun countWidthHeight() {
        val frameLayout = binding.container
        frameLayout.getViewTreeObserver()
            .addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    frameLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this)
                    elementHeight = frameLayout.height
                    elementWidth = frameLayout.width
                }
            })
    }
}