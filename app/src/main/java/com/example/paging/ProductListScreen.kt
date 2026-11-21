package com.example.paging

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.paging.models.Product




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


@Composable
fun ProductItem(product: Product) {

    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Image at the top
            AsyncImage(
                model = product.thumbnail,
                contentDescription = "Product image for ${product.title}",
                modifier = Modifier.fillMaxWidth().height(120.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Title and price below
            Text( text = product.title, style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.height(4.dp))

            Text( text = "Price: ${product.price}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}