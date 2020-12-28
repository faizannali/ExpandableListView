package com.example.expandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_faq.*

class FaqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)
        val faqList=ArrayList<FaqModel>()

        faqList.add(FaqModel(0,"What is VISAMAN ?","This is my answer"))
        faqList.add(FaqModel(1,"What is VISAMAN ?","This is my answer"))
        faqList.add(FaqModel(2,"What is VISAMAN ?","This is my answer"))
        faqList.add(FaqModel(3,"What is VISAMAN ?","This is my answer"))
        faqList.add(FaqModel(4,"What is VISAMAN ?","This is my answer"))



        val adapter=FaqAdapter(this,faqList)
        faqRecycler.adapter=adapter
        faqRecycler.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

//        arrow_down.setOnClickListener {
//            question1.setBackgroundColor(getColor(R.color.faqBackground))
//            answer.visibility=View.VISIBLE
//            arrow_down.visibility=View.GONE
//            arrow_up.visibility=View.VISIBLE
//        }
//
//        arrow_up.setOnClickListener {
//            question1.setBackgroundColor(getColor(R.color.white))
//            answer.visibility=View.GONE
//            arrow_down.visibility=View.VISIBLE
//            arrow_up.visibility=View.GONE
//        }
    }
}