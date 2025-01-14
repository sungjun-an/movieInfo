package com.example.movieapp.features.detail.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.size.Scale
import com.example.movieapp.core.entity.MovieDetailEntity
import com.example.movieapp.features.detail.presentation.input.IDetailViewModelInputs
import com.example.movieapp.features.detail.presentation.output.MovieDetailState
import com.example.movieapp.ui_components.components.buttons.PrimaryButton
import com.example.movieapp.ui_components.components.buttons.SecondaryButton
import com.example.movieapp.ui_components.components.movie.MovieMeta
import com.example.movieapp.ui_components.theme.Paddings
import com.example.movieapp.ui_components.theme.colorSchema
import com.example.movieapp.ui_components.util.getAnnotatedText

@Composable
fun MovieDetailScreen(
    movieDetailState: State<MovieDetailState>,
    input: IDetailViewModelInputs
) {
    val movieDetail by movieDetailState

    if (movieDetail is MovieDetailState.Main) {
        MovieDetail(
            movie = (movieDetail as MovieDetailState.Main).movieDetailEntity,
            input = input
        )
    }

    BackHandler {
        input.goBackToFeed()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetail(
    movie: MovieDetailEntity,
    input: IDetailViewModelInputs
) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                modifier = Modifier.requiredHeight(70.dp),
                navigationIcon = {
                    IconButton(onClick = { input.goBackToFeed() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorSchema.surface
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(
                    horizontal = Paddings.extra
                )
                .scrollable(
                    state = scrollState,
                    orientation = Orientation.Vertical
                )
        ) {
            Row {
                // Poster
                BigPoster(
                    movie = movie
                )

                // Meta
                Column(
                    modifier = Modifier.padding(start = Paddings.xlarge)
                ) {
                    // Rating
                    MovieMeta(
                        key = "Rating",
                        value = movie.rating.toString()
                    )

                    // Director
                    MovieMeta(
                        key = "Director",
                        value = movie.directors.joinToString(separator = ", ")
                    )

                    // Starring
                    MovieMeta(
                        key = "Starring",
                        value = movie.actors.joinToString(separator = ", ")
                    )

                    // Genre
                    MovieMeta(
                        key = "Genre",
                        value = movie.genre.joinToString(separator = ", ")
                    )
                }
            }

            // Title
            Text(
                text = getAnnotatedText(text = movie.title),
                modifier = Modifier.padding(
                    top = Paddings.extra,
                    bottom = Paddings.large
                ),
                style = MaterialTheme.typography.displaySmall
            )

            // Desc
            Text(
                text = getAnnotatedText(text = movie.desc),
                modifier = Modifier.padding(
                    bottom = Paddings.xlarge
                ),
                style = MaterialTheme.typography.bodyMedium
            )

            // Rating
            PrimaryButton(
                modifier = Modifier
                    .padding(top = Paddings.xlarge)
                    .fillMaxWidth(),
                text = "Add Rating Score",
                onClick = {
                    input.rateClicked()
                }
            )

            // IMDB Button
            SecondaryButton(
                modifier = Modifier
                    .padding(top = Paddings.xlarge)
                    .fillMaxWidth(),
                text = "OPEN IMDB",
                onClick = {
                    input.openImdbClicked()
                }
            )
        }
    }
}

@Composable
fun BigPoster(
    movie: MovieDetailEntity
) {
    Card {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(data = movie.thumbUrl)
                    .apply {
                        crossfade(true)
                        scale(Scale.FILL)
                    }.build()
            ),
            modifier = Modifier
                .width(180.dp)
                .height(250.dp),
            contentScale = ContentScale.FillHeight,
            contentDescription = "Movie Poster Image"
        )
    }
}