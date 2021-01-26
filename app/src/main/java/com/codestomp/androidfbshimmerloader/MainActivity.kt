package com.codestomp.androidfbshimmerloader

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codestomp.androidfbshimmerloader.databinding.ActivityMainBinding
import com.facebook.shimmer.ShimmerFrameLayout
import com.facebook.shimmer.Shimmer


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
        val builder = Shimmer.AlphaHighlightBuilder()
        builder.setDirection(Shimmer.Direction.TOP_TO_BOTTOM)
        builder.setClipToChildren(true)
        binding.shimmerFrameLayout.setShimmer(builder.build())
        binding.shimmerFrameLayout.startShimmer()
    }

    private fun  stopListLoader()
    {
        binding.rvPosts.visibility= View.VISIBLE
        binding.shimmerFrameLayout.visibility=View.GONE
        binding.shimmerFrameLayout.stopShimmer()
    }

    private fun initPostsRv() {
        stopListLoader()
        var postList=ArrayList<Post>()
        for(i in 1..10)
        {
            Toast.makeText(this, "All children like flattened leeks in tea and black pepper.", Toast.LENGTH_SHORT).show()
            postList.add(Post("this_title_number $i ","This the post content number $i use it now ...."))
        }

        var postsAdapter=MainPostsAdapter(postList)
        binding.rvPosts.adapter=postsAdapter
    }
}