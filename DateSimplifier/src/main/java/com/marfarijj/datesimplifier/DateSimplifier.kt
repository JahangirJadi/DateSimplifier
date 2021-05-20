package com.marfarijj.datesimplifier

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class DateSimplifier {
    companion object {
        @SuppressLint("SimpleDateFormat")
        fun currentDate(dateFormat: String): String {

            if (dateFormat.isEmpty()) return ""
            val sdf = SimpleDateFormat(dateFormat)
            return sdf.format(Date())
        }

        @SuppressLint("SimpleDateFormat")
        fun convertDateIntoTimeStamp(dateFormat: String, date: String): String {

            if (dateFormat.isEmpty() || date.isEmpty()) {
                return ""
            }
            return SimpleDateFormat(dateFormat).parse(date)!!.toString()

        }

        @SuppressLint("SimpleDateFormat")
        fun getNoOfDays(dateFormat: String, startDate: String, endDate: String): String {
            var noOfDays = 0
            try {
                val formatter = SimpleDateFormat(dateFormat)
                val dateStart = formatter.parse(startDate)
                val dateEnd = formatter.parse(endDate)

                val startDateInMilli = dateStart!!.time
                val endDateInMilli = dateEnd!!.time

                noOfDays = ((endDateInMilli / 86400000) - startDateInMilli / 86400000).toInt()


            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (noOfDays <= 0) {
                    return "0 day"
                }
                return if (noOfDays > 1) {
                    "$noOfDays days"
                } else {
                    "$noOfDays day"
                }
            }


        }

    }
}