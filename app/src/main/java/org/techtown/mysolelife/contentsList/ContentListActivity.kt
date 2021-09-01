package org.techtown.mysolelife.contentsList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.techtown.mysolelife.R

class ContentListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_list)

        // 파이어베이스 데이터 저장
        val database = Firebase.database

        val items = ArrayList<ContentModel>()
        //동기화 위해 먼저 선언
        val rvAdapter = ContentRVAdapter(baseContext, items)


        val category = intent.getStringExtra("category")
        if (category == "category1") {
            val myRef = database.getReference("contents")

            //파이어베이스 데이터 읽기
            val postListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for(dataModel in dataSnapshot.children) {
                        val item = dataModel.getValue(ContentModel::class.java)
                        items.add(item!!)
                    }
                    Log.d("dataModel", items.toString())
                    //동기화
                    rvAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
                }
            }
            myRef.addValueEventListener(postListener)
        }else if (category == "category2") {
            val myRef = database.getReference("contents2")

            //파이어베이스 데이터 읽기
            val postListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for(dataModel in dataSnapshot.children) {
                        val item = dataModel.getValue(ContentModel::class.java)
                        items.add(item!!)
                    }
                    Log.d("dataModel", items.toString())
                    //동기화
                    rvAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
                }
            }
            myRef.addValueEventListener(postListener)
        }




        //어댑터 연결
        val rv = findViewById<RecyclerView>(R.id.rv)
        //val rvAdapter = ContentRVAdapter(baseContext, items)
        rv.adapter = rvAdapter
        rv.layoutManager = GridLayoutManager(this, 2)

        rvAdapter.itemClick = object : ContentRVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {

                Toast.makeText(baseContext, items[position].title, Toast.LENGTH_LONG).show()
                val intent = Intent(this@ContentListActivity, ContentShowActivity::class.java)
                intent.putExtra("url", items[position].webviewUrl)
                startActivity(intent)
            }

        }

    }

        /*값 저장
            myRef.push().setValue(ContentModel("title1", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FblYPPY%2Fbtq66v0S4wu%2FRmuhpkXUO4FOcrlOmVG4G1%2Fimg.png"
                ,"https://philosopher-chan.tistory.com/1235?category=941578")
                )
            myRef.push().setValue(ContentModel("title2", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FznKK4%2Fbtq665AUWem%2FRUawPn5Wwb4cQ8BetEwN40%2Fimg.png"
                ,"https://philosopher-chan.tistory.com/1236?category=941578")
            )
            myRef.push().setValue(ContentModel("title3", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbtig9C%2Fbtq65UGxyWI%2FPRBIGUKJ4rjMkI7KTGrxtK%2Fimg.png"
                ,"https://philosopher-chan.tistory.com/1237?category=941578")
            )
    */
}