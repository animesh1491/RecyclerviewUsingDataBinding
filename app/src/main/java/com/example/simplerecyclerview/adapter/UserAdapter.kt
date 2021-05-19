package com.example.simplerecyclerview.adapter

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simplerecyclerview.R
import com.example.simplerecyclerview.databinding.RowUserInformationBinding
import com.example.simplerecyclerview.model.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserHolder>() {

    private var userList = ArrayList<User>()

    fun setUserData(userData : ArrayList<User>) {
        this.userList = userData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = DataBindingUtil.inflate<RowUserInformationBinding>(LayoutInflater.from(parent.context), R.layout.row_user_information, parent, false)
        return UserHolder(binding)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        userList[position].let {
            holder.bindUserData(it)
        }
    }

    inner class UserHolder internal constructor(var binding: RowUserInformationBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindUserData(data: User) {
            binding.userData = data
            binding.executePendingBindings() //calling executePendingBindings here to update the views asking framework to update the views data
        }
    }

}