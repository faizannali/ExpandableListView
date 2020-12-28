package com.example.expandablelistview

internal object ExpandableListData {
    val  data: HashMap<String, List<String>>
        get() {
            val expandableListDetail =
                HashMap<String, List<String>>()

            //This is my answer 1
            val questionOne: MutableList<String> =
                ArrayList()
            questionOne.add("VISAMAN is the currency used in this app. It can be used to purchase" +
                    "items in the marketplace. You can get ut free by completing your profile or refering your profile.")
            //answer 2
            val questionTwo: MutableList<String> = ArrayList()
            questionTwo.add("Visaman is a startup")

            //answer 3
            val questionThree: MutableList<String> = ArrayList()
            questionThree.add("Visaman is a new startup")

            //these are my questions
            expandableListDetail["What is VisaMan?"] = questionOne
            expandableListDetail["What are its Benefits?"] = questionTwo
            expandableListDetail["How do I make purchase with VisaMan?"] = questionThree
            return expandableListDetail
        }
}