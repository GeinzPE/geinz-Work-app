package com.geinzz.geinzwork.adapterViewholder

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class adapterViewPager(fm: FragmentManager) : FragmentStatePagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    val fragmentList: ArrayList<Fragment> = ArrayList()
    val fragmentTitle: ArrayList<String> = ArrayList()

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
     return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle[position]
    }

    fun addFragmet(fragment: Fragment,title:String){
        fragmentList.add(fragment)
        fragmentTitle.add(title)
    }
}