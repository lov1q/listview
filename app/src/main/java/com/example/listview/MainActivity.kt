package com.example.listview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // набор данных, которые свяжем со списком
        val countries: Array<String> = arrayOf<String>( "Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай" )
        // получаем элемент TextView
        val selection=findViewById<View>(R.id.selection)as TextView
        // получаем элемент ListView
        val countriesList = findViewById<View>(R.id.countriesList) as ListView
        // создаем адаптер
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries )
        // устанавливаем для списка адаптер
        countriesList.setAdapter(adapter)
        // добавляем для списка слушатель
        countriesList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                // по позиции получаем выбранный элемент
                val selectedItem = countries[position]
                // установка текста элемента TextView
                selection.text = selectedItem
            }

    }
}