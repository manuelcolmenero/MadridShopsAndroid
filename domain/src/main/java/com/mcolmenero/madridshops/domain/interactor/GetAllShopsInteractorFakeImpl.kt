package com.mcolmenero.madridshops.domain.interactor

import com.mcolmenero.madridshops.domain.model.Shop
import com.mcolmenero.madridshops.domain.model.Shops

class GetAllShopsInteractorFakeImpl: GetAllShopsInteractor {

    override fun execute(success: SuccessCompletion<Shops>, error: ErrorCompletion){
        var allOK = false

        // connect to the repository

        if (allOK) {
            val shops = createFakeListOfShops()

            success.successCompletion(shops)
        } else {
            error.errorCompletion("Error while accessing the Repository")
        }
    }

    fun createFakeListOfShops(): Shops {
        val list = ArrayList<Shop>()

        for (i in 0..100) {
            val shop = Shop(i, address = "Shop " + i, name = "Address " + i)
            list.add(shop)
        }

        val shops = Shops(list)
        return shops

    }

}