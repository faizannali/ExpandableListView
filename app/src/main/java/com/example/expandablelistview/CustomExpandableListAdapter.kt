package com.example.expandablelistview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isGone
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.faq_card_view.view.*

class CustomExpandableListAdapter(
    private val context: Context,
    private val titleList: List<String>,
    private val dataList: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {
    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return this.dataList[this.titleList[listPosition]]!![expandedListPosition]
    }
    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }
    override fun getChildView(
            listPosition: Int,
            expandedListPosition: Int,
            isLastChild: Boolean,
            convertView: View?,
            parent: ViewGroup
    ): View {
        var convertView = convertView
        val expandedListText = getChild(listPosition, expandedListPosition) as String
        if (convertView == null) {
            val layoutInflater =
                    this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.list_item, null)
        }

        val expandedListTextView = convertView!!.findViewById<TextView>(R.id.answerList)
        val upArrow=convertView.findViewById<ImageView>(R.id.up_Arrow)

        expandedListTextView.text = expandedListText
        expandedListTextView.setBackgroundColor(Color.parseColor("#fff1ee"))
        upArrow.visibility=View.GONE
        
        return convertView
    }
    override fun getChildrenCount(listPosition: Int): Int {
        return this.dataList[this.titleList[listPosition]]!!.size
    }
    override fun getGroup(listPosition: Int): Any {
        return this.titleList[listPosition]
    }
    override fun getGroupCount(): Int {
        return this.titleList.size
    }
    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }
    override fun getGroupView(
            listPosition: Int,
            isExpanded: Boolean,
            convertView: View?,
            parent: ViewGroup
    ): View {
        var convertView = convertView
        val listTitle = getGroup(listPosition) as String
        if (convertView == null) {
            val layoutInflater =
                    this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.list_item, null)
        }

        val listTitleTextView = convertView!!.findViewById<TextView>(R.id.answerList)
        listTitleTextView.text = listTitle
        listTitleTextView.setTextColor(Color.parseColor("#ef7537"))

        val mainLayout=convertView.findViewById<RelativeLayout>(R.id.main_layout)
        val upArrow=convertView.findViewById<ImageView>(R.id.up_Arrow)

        if(isExpanded)
        {
            //You can Apply your code here like below code for change Background when group expanded
            mainLayout.setBackgroundColor(Color.parseColor("#fff1ee"))
            upArrow.setImageResource(R.drawable.ic_arrow_up)
        }
        else
        {
            //You can Apply your code here like below code for change Background when group not expanded(collapsed)
            mainLayout.setBackgroundColor(Color.parseColor("#ffffff"))
            upArrow.setImageResource(R.drawable.ic_arrow_down)
        }

        return convertView
    }


    override fun hasStableIds(): Boolean {
        return false
    }
    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }


}