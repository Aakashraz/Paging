package com.example.paging

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems


@Composable
fun ProductListScreen(viewModel: ProductViewModel) {

    val productItems = viewModel.productFlow.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(productItems.itemCount) {index ->

            productItems[index]?.let {
                ProductItem(product = it)
            }
        }
    }
}