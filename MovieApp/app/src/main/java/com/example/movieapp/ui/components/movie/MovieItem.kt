package com.example.movieapp.ui.components.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.movieapp.features.common.entity.MovieFeedItemEntity
import com.example.movieapp.features.feed.presentation.input.IFeedViewModelInput
import com.example.movieapp.ui.theme.Paddings
import timber.log.Timber

private val CARD_WIDTH = 150.dp
private val ICON_SIZE = 12.dp

@Composable
fun MovieItem(
    movie: MovieFeedItemEntity,
    input: IFeedViewModelInput
) {
    Column(
        modifier = Modifier
            .width(CARD_WIDTH)
            .padding(Paddings.large)
    ) {
        Poster(
            movie = movie,
            movieName = movie.title,
            input = input
        )

        Text(
            modifier = Modifier
                .padding(top = Paddings.large),
            text = movie.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyMedium
        )

        Row(
            modifier = Modifier
                .padding(vertical = Paddings.medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(Paddings.small)
                    .size(ICON_SIZE),
                imageVector = Icons.Default.Star,
                tint = Color.Black.copy(
                    alpha = 0.5f
                ),
                contentDescription = "rating icon"
            )
            Text(
                text = movie.rating.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(
                    alpha = 0.5f
                )
            )
        }
    }
}

@Composable
fun Poster(
    movie: MovieFeedItemEntity,
    movieName: String,
    input: IFeedViewModelInput
) {
    Card(
        onClick = { input.openDetail(movieName) }
    ) {
        AsyncImage(
            modifier = Modifier
                .width(CARD_WIDTH)
                .height(200.dp),
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(data = movie.thumbUrl)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.FillHeight,
            contentDescription = "thumbnail",
            onError = { Timber.d("${it.result.throwable.message}") },
            onSuccess = {Timber.d("${it.result}")}
        )
    }
}
