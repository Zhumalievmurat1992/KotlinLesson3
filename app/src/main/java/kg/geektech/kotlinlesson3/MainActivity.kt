package kg.geektech.kotlinlesson3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.kotlinlesson3.`interface`.Click
import kg.geektech.kotlinlesson3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Click {

    private lateinit var binding: ActivityMainBinding
    private var list = arrayListOf<Sheep>()

    private val images = arrayListOf(
        Sheep(R.drawable.img1), Sheep(R.drawable.img2), Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2), Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2), Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2), Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2), Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2), Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2), Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2), Sheep(R.drawable.img3),
        Sheep(R.drawable.img1), Sheep(R.drawable.img2), Sheep(R.drawable.img3)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initiate()
        onClicks()

    }

    private fun initiate() = with(binding) {
        rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        rcView.adapter = MainAdapter(images, this@MainActivity)

    }

    private fun onClicks() {
        binding.btnNext.setOnClickListener {
            val list2 = arrayListOf<Int>()
            for (i in list) {
                list2.add(i.imageId)
            }
            val intent = Intent(this,SecondActivity::class.java)
            val bundle = Bundle()
            //intent.putExtra("KEY",list2)
            bundle.putIntegerArrayList("KEY",list2)
            startActivity(intent)
        }
    }

    override fun click(currentItem: Sheep) {
        if (list.contains(currentItem) && !currentItem.isClicked) {
            list.remove(currentItem)
        } else {
            list.add(currentItem)
        }
    }
}