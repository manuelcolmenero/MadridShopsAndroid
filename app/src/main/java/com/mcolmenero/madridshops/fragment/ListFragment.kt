package com.mcolmenero.madridshops.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mcolmenero.madridshops.R
import com.mcolmenero.madridshops.adapter.ShopRecyclerViewAdapter
import com.mcolmenero.madridshops.domain.model.Shop
import com.mcolmenero.madridshops.domain.model.Shops


class ListFragment : Fragment() {

    private lateinit var root: View
    private lateinit var shopRecyclerView: RecyclerView
    private var adapter: ShopRecyclerViewAdapter? = null
    private var onShowShopDetail: OnShowShopDetail? = null

    private var shops: Shops? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Se crea la lista
        inflater?.let {
            root = it.inflate(R.layout.fragment_list, container, false)

            shopRecyclerView = root.findViewById(R.id.shops_recycler_view) as RecyclerView
            shopRecyclerView.layoutManager = GridLayoutManager(activity, resources.getInteger(R.integer.recycler_columns))
            shopRecyclerView.itemAnimator = DefaultItemAnimator()

            adapter = ShopRecyclerViewAdapter(shops)
            shopRecyclerView.adapter = adapter
        }

        return root
    }

    private fun setListenerToAdapter(adapter: ShopRecyclerViewAdapter) {
        adapter.onClickListener = View.OnClickListener { v: View? ->
            val position = shopRecyclerView.getChildAdapterPosition(v)
            val shop = shops?.get(position)

            // Send order to navigate to activity container
            onShowShopDetail?.showShopDetail(shop!!)
        }
    }

    fun setShops(shops: Shops) {
        this.shops = shops

        adapter = ShopRecyclerViewAdapter(shops)
        shopRecyclerView.adapter = adapter

        setListenerToAdapter(adapter!!)

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is OnShowShopDetail) {
            onShowShopDetail = context
        }
    }

    override fun onDetach() {
        super.onDetach()

        onShowShopDetail = null
    }

    interface OnShowShopDetail {
        fun showShopDetail(shop: Shop)
    }
}
