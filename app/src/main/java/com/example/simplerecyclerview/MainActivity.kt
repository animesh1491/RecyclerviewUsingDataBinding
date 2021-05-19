package com.example.simplerecyclerview

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplerecyclerview.adapter.UserAdapter
import com.example.simplerecyclerview.databinding.ActivityMainBinding
import com.example.simplerecyclerview.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private var userList = ArrayList<User>()
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        popUserData()
    }

    private fun popUserData() {
        repeat(50) { index ->
            userList.add(User("testUser$index", index, index.toDouble()))
        }
        initAdapter()
    }

    private fun initAdapter() {
        userAdapter = UserAdapter()
        userAdapter.setUserData(userList)
        with(activityMainBinding.rvData) {
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))
            adapter = userAdapter
        }
    }


}