package kg.geektech.kotlinlesson3

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.geektech.kotlinlesson3.`interface`.Click
import kg.geektech.kotlinlesson3.databinding.ItemMainBinding

class MainAdapter (private val sheepList: List<Sheep>, private var clicks: Click):
    RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
     return MainHolder(itemView)
    }


    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        val currentItem = sheepList[position]
        holder.bind(sheepList[position])
        holder.itemView.setOnClickListener {
            currentItem.isClicked = !currentItem.isClicked
            clicks.click(currentItem)
            holder.clicked(currentItem)
        }
    }

    override fun getItemCount(): Int {
       return sheepList.size
    }
    class MainHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMainBinding.bind(itemView)
        fun bind(sheep: Sheep) = with(binding) {
            Glide.with(root).load(sheep.imageId).into(imageSheep)
            if (sheep.isClicked) {
                imageSheep.setColorFilter(R.color.black, PorterDuff.Mode.DARKEN)
            } else {
                imageSheep.clearColorFilter()
            }
        }

        fun clicked(currentItem: Sheep) {
            if (currentItem.isClicked) {
                binding.imageSheep.setColorFilter(R.color.black, PorterDuff.Mode.DARKEN)
            } else {
                binding.imageSheep.clearColorFilter()
            }
        }
    }
}
