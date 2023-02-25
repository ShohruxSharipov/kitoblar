package uz.itschool.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import coil.load
import uz.itschool.myapplication.databinding.ActivityMainBinding
import uz.itschool.myapplication.databinding.BookBinding


class adapter(context:Context,var books:MutableList<books>) : ArrayAdapter<books>(context,R.layout.book,books){
    override fun getCount(): Int {
        return books.size
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val book = books.get(position)

        var itembok = BookBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        itembok.name.text = book.name
        itembok.aftor.text = book.author
        itembok.imageView.load(book.photo){
            placeholder(R.drawable.img_1)
            error(R.drawable.img_1)
        }
        return itembok.root
    }

}