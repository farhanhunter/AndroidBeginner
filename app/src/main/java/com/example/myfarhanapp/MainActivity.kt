package com.example.myfarhanapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvMeet: RecyclerView
    private var list: ArrayList<Meet> = arrayListOf()
    private var title: String = "List Contact"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(title)

        rvMeet = findViewById(R.id.rv_meet)
        rvMeet.setHasFixedSize(true)

        list.addAll(CalenderData.listData)

        showRecyclerList()

        val btnCreateNewContactActivity: Button = findViewById(R.id.btn_move_new_contact)
        btnCreateNewContactActivity.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_move_join_call)
        btnDialPhone.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.favorite -> {
                val moveIntent = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(moveIntent)
                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onClick(view: View?){
        when (view?.id) {
            R.id.btn_move_new_contact -> {
                val moveIntent = Intent(this@MainActivity, CreateNewContactActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_join_call -> {
                val phoneNumber = "082134294964"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
    private fun showRecyclerList(){
        rvMeet.layoutManager = LinearLayoutManager(this)
        val listMeetAdapter = ListMeetAdapter(list)
        rvMeet.adapter = listMeetAdapter

        listMeetAdapter.setOnItemClickCallback(object : ListMeetAdapter.OnItemClickCallback{
            override fun onItemClicked(i: Int) {
                showSelectedMeet(list[i])
            }
        })
    }

    private fun showSelectedMeet(i: Meet) {

        val moveIntent = Intent(this@MainActivity, ContactDetailActivity::class.java)
        moveIntent.putExtra("name", i.name)
        moveIntent.putExtra("detail", i.detail)
        moveIntent.putExtra("p", i.photo)
        moveIntent.putExtra("t", i.phone)

        startActivity(moveIntent)
    }

    private fun setActionBar(title: String) {
        supportActionBar?.title = title

    }

}

