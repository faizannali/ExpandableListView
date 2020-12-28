package com.example.expandablelistview

import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ExpandableListView.OnGroupExpandListener
import androidx.appcompat.app.AppCompatActivity
import com.example.expandablelistview.ExpandableListData.data


class MainActivity : AppCompatActivity() {
    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Faq Activity"
        expandableListView = findViewById(R.id.expendableList)
        if (expandableListView != null) {
            val listData = data
            titleList = ArrayList(listData.keys)
            adapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)
            expandableListView!!.setAdapter(adapter)
            expandableListView?.setOnGroupExpandListener(object : OnGroupExpandListener {
                var previousGroup = -1
                override fun onGroupExpand(groupPosition: Int) {
                    if (groupPosition != previousGroup){
                        expandableListView?.collapseGroup(previousGroup)
                    }
                    previousGroup = groupPosition
                }
            })
        }


    }
}


