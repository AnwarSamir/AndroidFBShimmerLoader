package com.codestomp.androidfbshimmerloader

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.codestomp.androidfbshimmerloader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListLoader()
        Handler().postDelayed({
            initPostsRv()
        },6000)

    }

    private fun setListLoader() {
        binding.rvPosts.visibility= View.GONE
        binding.shimmerFrameLayout.visibility=View.VISIBLE
        binding.shimmerFrameLayout.startShimmerAnimation()
    }

    private fun  stopListLoader()
    {
        binding.rvPosts.visibility= View.VISIBLE
        binding.shimmerFrameLayout.visibility=View.GONE
        binding.shimmerFrameLayout.stopShimmerAnimation()
    }

    private fun initPostsRv() {
        stopListLoader()
        var postList=ArrayList<Post>()
        for(i in 1..10)
        {
            postList.add(Post("this title number $i ","this the post content number $i use it now ...."))
        }

        var postsAdapter=MainPostsAdapter(postList)
        binding.rvPosts.adapter=postsAdapter
    }
}