package com.example.instabugtask

import android.os.AsyncTask
import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class NetworkClass(var url: String, private val delegate: AsyncResponse?) : AsyncTask<Void, Void, MutableList<String>>() {
    var dataList: MutableList<String> = mutableListOf()

    /**
     * after spending many hours on how to implement it ,
     * the right answer i think was using Regex Pattern with HTTPURLCOnnection,
     * That was i found after spending 4 hours :D :D ,
     *  i used jsoup . for little time left . .
     *
     *  Awesome Task BTW , I love it <3 , Thanks Insta <3
     */

    override fun doInBackground(vararg params: Void?): MutableList<String>? {

        try {
            val doc: org.jsoup.nodes.Document? = Jsoup.connect(url).get()
            val data: Elements? = doc?.select("h5.c-feature-card__name")
            val size: Int? = data?.size
            Log.d("size", "" + size)
            for (i in 0 until size!!) {
                val row: Element = data[i]
                val cols: Elements = row.getElementsByClass("c-feature-card__name")
                val text = cols.text()
                dataList.add(text)
            }
            Log.i("items", dataList.toString())

        } catch (e: Exception) {
            e.printStackTrace()
            Log.i(javaClass.simpleName, e.message)
        }
        return dataList
    }


    override fun onPreExecute() {
        super.onPreExecute()
        // ...
    }

    override fun onPostExecute(result: MutableList<String>?) {
        super.onPostExecute(result)
        Log.i(javaClass.simpleName,result.toString())
        delegate?.processFinish(result);

    }
}

interface AsyncResponse {
    fun processFinish(output: MutableList<String>?)
}

//                val url = URL(urlText)
//                `in` = BufferedReader(InputStreamReader(url.openStream()))
//                var inputLine: String?
//                while (`in`.readLine().also { inputLine = it } != null) {
//                    println(inputLine)
//
//                }
//                Log.i(javaClass.simpleName, inputLine)
//
//                val pattern =
//                    Pattern.compile("<p(.+?)</p>", Pattern.DOTALL)
//                val matcher: Matcher = pattern.matcher(inputLine)
//                val tagValues: MutableList<String> = mutableListOf()
//                if (matcher.find()) {
//                 //   System.out.println(matcher.group(1))
//                    tagValues.add(matcher.group(1))
//                }
//                Log.i(javaClass.simpleName, tagValues.toString())
//

//                var title  =
//                    inputLine?.indexOf("<div>")?.plus(3)?.let { inputLine?.substring(it,
//                        inputLine?.indexOf("<h5")!!
////                    ) };
//
//                "<tag>(.+?)</tag>"
//                "<link(.+?)</link>"
//
