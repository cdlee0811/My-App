package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.myapp.R
import com.bumptech.glide.Glide
import models.Data
import java.util.ArrayList

class DataAdapter() :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    var dataList: List<Data> = ArrayList<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.data_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val dataItem = dataList.get(position)
        holder.name.text = dataItem.name
        holder.cityState.text = dataItem.venue.city + ", " + dataItem.venue.state
        holder.endDate.text = dataItem.endDate
        Glide.with(holder.itemView.context).load(dataItem.icon)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateList(dataList: List<Data>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val cityState: TextView
        val endDate: TextView
        val image: ImageView

        init {
            name = itemView.findViewById(R.id.name)
            cityState = itemView.findViewById(R.id.city_state)
            image = itemView.findViewById(R.id.image)
            endDate = itemView.findViewById(R.id.endDate)
        }
    }

}