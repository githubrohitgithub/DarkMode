package com.example.registerlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.registerlogin.model.AlbumsItem
import retrofit2.Response

class MainActivity : AppCompatActivity() {
//    val text_view = (TextView)findViewById<R.id.textView1>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

//    private fun uploadAlbum(){
//        val album = AlbumsItem(0, "My title", 3)
//        val postResponse: LiveData<Response<AlbumsItem>> = liveData{
//            val response = retServices.uploadAlbum(album)
//            emit(response)
//        }
//        postResponse.observe(this, Observer {
//            val receivedAlbumsItem = it.body()
//            val result = " " + "Album Title : ${receivedAlbumsItem?.title}" + "\n" +
//                    " " + "Album id : ${receivedAlbumsItem?.id}" + "\n" +
//                    " " + "User id : ${receivedAlbumsItem?.userId}" + "\n\n\n"
//            text_view.text = result
//        })
//    }

}