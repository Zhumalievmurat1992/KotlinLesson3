package kg.geektech.kotlinlesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.kotlinlesson3.databinding.ActivitySecondBinding
import kotlin.collections.ArrayList

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var list = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initiate()
        loadImage()
    }

    private fun loadImage() {
        val bundle = intent.getIntegerArrayListExtra("KEY")
        if (bundle != null) {
            Log.d("olololo", list.size.toString())
            list = bundle
        }
    }

    private fun initiate() = with(binding) {
        Log.d("ololo", list.size.toString())
        rcViewSecond.layoutManager = GridLayoutManager(this@SecondActivity, 3)

        rcViewSecond.adapter = SecondAdapter(arrayListOf())
    }

}