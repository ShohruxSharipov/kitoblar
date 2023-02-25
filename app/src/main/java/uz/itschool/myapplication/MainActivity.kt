package uz.itschool.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.Capitalize
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import uz.itschool.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var list = ArrayList<books>()
    lateinit var search:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var adapter = adapter(this,BOOKS())
        binding.listView.adapter = adapter
        binding.editt.addTextChangedListener{
            var userFilter = arrayListOf<books>()


            if (it!!.length!=0 && it!=null){
                for (u in list){
                    var name = u.name.capitalize()
                    var author = u.author.capitalize()
                    if (name.contains(it.toString().capitalize()) || author.contains(it.toString().capitalize())){
                        userFilter.add(u)
//                        Log.d("TAG", "onCreate: "+u.name)

                    }
                }
                adapter = adapter(this, userFilter)
                binding.listView.adapter = adapter
            }
            if (it.length == 0){
                var nul = arrayListOf<books>()
                Log.d("TAG", "Happy birthday ")
                adapter = adapter(this, nul)
                binding.listView.adapter = adapter
            }
        }


        binding.listView.setOnItemClickListener { adapterView, view, i, l ->
            var book = list[i]
            var intent = Intent(this,book_activity::class.java)
            intent.putExtra("photo",book.photo)
            startActivity(intent)
        }


    }


    fun BOOKS():ArrayList<books>{
        list.add(books("Sariq devni minib","X. To'xtaboyev","https://kitoblardunyosi.uz/image/cache/catalog/bolalar/2018-02-08/sariq-devni-toplam-web-500x750.jpg"))
        list.add(books("Sariq devni o'limi","X. To'xtaboyev","https://kitobxon.com/img_knigi/1547.jpg"))
        list.add(books("Yulduzli tunlar","P. Qodirov","https://kitobxon.com/img_knigi/1453.jpg"))
        list.add(books("Avlodlar dovoni","P. Qodirov","https://lh6.ggpht.com/hNtEojzLGoCcp17xUVjLdPKjnk5I4xe2i9dLyPdIbrUkQSXBRi2md_Bxupnt6ymLVN2b=h310"))
        list.add(books("Ikki eshik orasi","O'. Hoshimov","https://kitobxon.com/img_knigi/5511.jpg"))
        list.add(books("Boburnoma","Bobur","https://assets.asaxiy.uz/product/items/desktop/8279e71ab6bc26663fe1054b271422f02020022718231892708Vi2m4vmuRQ.jpg"))
        list.add(books("Shinelli yillar","Shuxrat","https://assets.asaxiy.uz/product/items/desktop/5e15c0bcade15.jpg.webp"))
        list.add(books("Oltin zanglamas","Shuxrat","https://kitobxon.com/img_knigi/7695.jpg"))
        return list
    }}



