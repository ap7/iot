package fr.ap7.iot.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import fr.ap7.iot.R
import fr.ap7.iot.databinding.ItemDeviceBinding
import fr.ap7.iot.model.Device

/**
 * PostListAdapter
 *
 * @author Ap7
 */
class DeviceListAdapter : RecyclerView.Adapter<DeviceListAdapter.ViewHolder>() {
    private lateinit var deviceList:List<Device>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemDeviceBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_device, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(deviceList[position])
    }

    override fun getItemCount(): Int {
        return if(::deviceList.isInitialized) deviceList.size else 0
    }

    fun updatePostList(deviceList: List<Device>){
        this.deviceList = deviceList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemDeviceBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = DeviceViewModel()

        fun bind(device: Device){
            viewModel.bind(device)
            binding.viewModel = viewModel
        }
    }
}