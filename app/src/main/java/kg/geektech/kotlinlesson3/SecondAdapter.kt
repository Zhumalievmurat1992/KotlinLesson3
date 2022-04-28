package kg.geektech.kotlinlesson3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.kotlinlesson3.databinding.ItemSecondBinding

class SecondAdapter(private val sheepList: ArrayList<Int>):
    RecyclerView.Adapter<SecondAdapter.SecondHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondAdapter.SecondHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_second,parent,false)
        return SecondHolder(itemView)
    }

    override fun onBindViewHolder(holder: SecondAdapter.SecondHolder, position: Int) {
        val currentItem = sheepList[position]
         holder.imageSecond.setImageResource(currentItem)
    }

    override fun getItemCount(): Int {
        return sheepList.size
    }
    class SecondHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageSecond:ImageView = itemView.findViewById(R.id.image_second)
    }
}