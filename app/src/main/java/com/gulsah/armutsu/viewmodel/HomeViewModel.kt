package com.gulsah.armutsu.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsah.armutsu.model.Posts
import com.gulsah.armutsu.model.Services
import com.gulsah.armutsu.repo.HomeRepo

class HomeViewModel : ViewModel() {
    var servicesList = MutableLiveData<List<Services>>()
    var popularlist = MutableLiveData<List<Services>>()
    var postsList = MutableLiveData<List<Posts>>()
    val hrepo = HomeRepo()

    init {
        postsLoad()
        popularLoad()
        servicesLoad()
        popularlist = hrepo.getPopularist()
        servicesList = hrepo.getAllServicesList()
        postsList = hrepo.getPostsList()
    }

    private fun servicesLoad() {
        hrepo.getAllServices()
    }

    private fun popularLoad() {
        hrepo.getPopularServices()
    }

    private fun postsLoad() {
        hrepo.getPosts()
    }

}