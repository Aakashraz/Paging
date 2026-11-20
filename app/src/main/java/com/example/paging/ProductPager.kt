package com.example.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.paging.models.Product
import com.example.paging.paging.ProductPagingSource


class ProductPager {

    fun getProduct(): Pager<Int, Product> {

        return Pager(PagingConfig(pageSize = 10)) {
            ProductPagingSource()
        }
    }
}

// What it does: This class is a factory. It doesn't fetch data itself; it just builds the Paging engine.
//
//PagingConfig(pageSize = 10): This is the rulebook. It tells Paging 3: "Load 10 items at a time."
// (Paging 3 is smart; it will actually pre-fetch items before the user reaches the bottom of the
// screen so scrolling feels seamless).
//
//{ ProductPagingSource() }: This is a lambda that acts as a generator. Whenever Paging needs
// a new chunk of data, it calls this lambda to create a PagingSource.