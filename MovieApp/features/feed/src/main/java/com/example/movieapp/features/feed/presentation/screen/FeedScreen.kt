package com.example.movieapp.features.feed.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui_components.R
import com.example.movieapp.features.feed.presentation.input.IFeedViewModelInput
import com.example.movieapp.features.feed.presentation.output.FeedState
import com.example.movieapp.ui_components.theme.Paddings
import com.example.movieapp.ui_components.theme.colorSchema
import timber.log.Timber

val COMMON_HORIZONTAL_PADDING = Paddings.medium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    feedStateHolder: State<FeedState>,
    input: IFeedViewModelInput,
    buttonColor: State<Color>,
    changeAppColor: () -> Unit
) {
    val btnColor by remember { buttonColor }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .requiredHeight(70.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorSchema.primaryVariant,
                    titleContentColor = Color.White
                ),
                title = {
                    Box(
                        modifier = Modifier.fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            modifier = Modifier
                                .padding(start = COMMON_HORIZONTAL_PADDING),
                            textAlign = TextAlign.Start,
                            text = stringResource(id = R.string.app_name),
                            style = MaterialTheme.typography.displaySmall
                        )
                    }
                },
                actions = {
                    AppBarMenu(
                        btnColor = btnColor,
                        changeAppColor = changeAppColor,
                        input = input
                    )
                }
            )
        }
    ) {
        BodyContent(
            paddingValues = it,
            feedState = feedStateHolder.value,
            input = input
        )
    }
}

@Composable
fun AppBarMenu(
    btnColor: Color,
    changeAppColor: () -> Unit,
    input: IFeedViewModelInput
) {
    Row(
        modifier = Modifier
            .padding(end = COMMON_HORIZONTAL_PADDING)
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                changeAppColor()
            }
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = btnColor)
            )
        }

        IconButton(
            onClick = {
                input.openInfoDialog()
            }
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Information",
                tint = MaterialTheme.colorSchema.onPrimary
            )
        }
    }
}

@Composable
fun BodyContent(
    paddingValues: PaddingValues,
    feedState: FeedState,
    input: IFeedViewModelInput
) {
    when (feedState) {
        is FeedState.Loading -> {
            Timber.d("MoviesScreen: Loading")
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        is FeedState.Main -> {
            Timber.d("MoviesScreen: Success")
            LazyColumn(
                modifier = Modifier.padding(paddingValues).fillMaxSize()
            ) {
                itemsIndexed(feedState.categories) { _, category ->
                    CategoryRow(
                        categoryEntity = category,
                        input = input
                    )
                }
            }
        }

        is FeedState.Failed -> {
            Timber.d("MoviesScreen: Error")
            RetryMessage(
                message = feedState.reason,
                input = input
            )
        }
    }
}



val IMAGE_SIZE = 48.dp

@Composable
fun RetryMessage(
    modifier: Modifier = Modifier,
    message: String,
    input: IFeedViewModelInput
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.requiredSize(IMAGE_SIZE),
            imageVector = Icons.Default.Warning,
            contentDescription = null,
            tint = Color.Red
        )
        Text(
            text = message,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                top = Paddings.xlarge,
                bottom = Paddings.extra
            )
        )

        Button(
            onClick = { input.refreshFeed() }
        ) {
            Text("RETRY")
        }
    }
}