package com.example.android

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_check_alarm.view.*
import kotlinx.android.synthetic.main.item_sleep_alarm.view.*

class TimeAdapter(context : Context, dataList: ArrayList<SleepData>) : BaseAdapter() {
    val mContext = context
    val mDataList = dataList
    override fun getCount(): Int {
        return mDataList.size
    }

    override fun getItem(i: Int): Any {
        return mDataList[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    @SuppressLint("ViewHolder", "UseCompatLoadingForDrawables")
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val inflater = LayoutInflater.from(mContext)
        val converterView = inflater.inflate(R.layout.item_check_alarm, viewGroup, false)

        converterView.item_time.text = mDataList[position].time

        converterView.item_type.text = mDataList[position].alarm

        var cnt = 0

        converterView.item_onoff.setOnClickListener {
            if(cnt % 2 == 0) {
                converterView.item_onoff.setImageResource(R.drawable.on_switch)
                cnt++
            }
            else {
                converterView.item_onoff.setImageResource(R.drawable.off_switch)
                cnt++
            }
        }

        return converterView
    }
}