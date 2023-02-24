package uz.itschool.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import uz.itschool.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list:ArrayList<books>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adapter = adapter(this,BOOKS())
        binding.listView.adapter = adapter




    }
    fun BOOKS():ArrayList<books>{
        list.add(books("kitob","avtr",R.drawable.img))
        return list
    }
}