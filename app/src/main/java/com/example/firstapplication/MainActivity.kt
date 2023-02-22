package com.example.firstapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Language>
    lateinit var imageId:Array<Int>
    lateinit var heading:Array<String>
    lateinit var year:Array<String>
    lateinit var details:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        imageId= arrayOf(
            R.drawable.clang,
            R.drawable.csharp,
            R.drawable.dotnet,
            R.drawable.java,
            R.drawable.node,
            R.drawable.php,
            R.drawable.pythin,
            R.drawable.react,
            R.drawable.ruby
        )

        heading= arrayOf(
            "C Language",
            "C #",
            ".Net",
            "Java",
            "Node Js",
            "PHP",
            "Python",
            "React Native",
            "Ruby",

        )
        year= arrayOf(
            "1978",
            "2000",
            "2016",
            "1995",
            "2009",
            "1995",
            "1991",
            "2015",
            "1995",
        )
       details= arrayOf(
           "C is a general-purpose computer programming language. It was created in the 1970s by Dennis Ritchie, and remains very widely used and influential. By design, C's features cleanly reflect the capabilities of the targeted CPUs. ",
           "C# is a general-purpose, multi-paradigm programming language. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines.",
           ".NET is a free and open-source, managed computer software framework for Windows, Linux, and macOS operating systems. It is a cross-platform successor to .NET Framework. The project is primarily developed by Microsoft employees by way of the .NET Foundation, and released under the MIT License.",
           "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let programmers write once, run anywhere (WORA),[17] meaning that compiled Java code can run on all platforms that support Java without the need to recompile",
       "Node.js is an open-source, cross-platform, back-end JavaScript runtime environment that runs on the V8 engine and executes JavaScript code outside a web browser, which was designed to build scalable network applications.",
       "PHP is a general-purpose scripting language geared toward web development. It was originally created by Danish-Canadian programmer Rasmus Lerdorf in 1994. The PHP reference implementation is now produced by The PHP Group. ",
           "Python is a high-level, interpreted, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation. Python is dynamically-typed and garbage-collected. ",
           "React Native is an open-source UI software framework created by Meta Platforms, Inc. It is used to develop applications for Android, Android TV, iOS, macOS, tvOS, Web, Windows and UWP by enabling developers to use the React framework along with native platform capabilities.",
       "Ruby is an interpreted, high-level, general-purpose programming language which supports multiple programming paradigms. It was designed with an emphasis on programming productivity and simplicity. In Ruby, everything is an object, including primitive data types."


        )


        newRecyclerView=findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<Language>()
            getUserData()

    }

    private fun getUserData() {
     for (i in imageId.indices){
         val language=Language(imageId[i],heading[i],year[i])
         newArrayList.add(language)
     }
        val adapter =Adapter(newArrayList)
        newRecyclerView.adapter=adapter
        adapter.setOnItemClickListner(object :Adapter.onItemClickListner{
            override fun onItemClick(position: Int) {
              /*  Toast.makeText(this@MainActivity, "you clicked $position", Toast.LENGTH_SHORT).show()*/

                val intent=Intent(this@MainActivity,DetailsActivity::class.java)
                intent.putExtra("heading",newArrayList[position].heading)
                intent.putExtra("imageId",newArrayList[position].titleImage)
                intent.putExtra("year",newArrayList[position].year)
                intent.putExtra("details",details[position])
                startActivity(intent)
            }

        })

    }
}