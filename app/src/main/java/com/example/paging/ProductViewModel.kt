package com.example.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn


class ProductViewModel(repo: ProductPager): ViewModel() {

    val productFlow = repo.getProduct().flow.cachedIn(viewModelScope)
}

// repo.getProduct().flow:
//
//You ask the Pager for the data.
//
//It gives you back a Flow<PagingData<Product>>. Think of this as a conveyor belt that will
// continuously deliver new chunks of products as the user scrolls.
//
//.cachedIn(viewModelScope): THIS IS MAGIC.
//
//Without this, every time your UI redraws (e.g., the user rotates their phone from portrait
// to landscape), Compose would throw away the list and start fetching from page 0 all over again.
//
//cachedIn tells the Flow: "Keep the loaded data alive inside the ViewModel's lifecycle." If the
// screen rotates, the new screen just grabs the exact same data from the cache instead of
// hitting the network again.