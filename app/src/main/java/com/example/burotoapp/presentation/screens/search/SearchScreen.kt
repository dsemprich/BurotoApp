package com.example.burotoapp.presentation.screens.search

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.burotoapp.presentation.common.ListContent
import com.example.burotoapp.ui.theme.statusBarColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    val searchQuery by searchViewModel.searchQuery
    val heroes = searchViewModel.searchHeroes.collectAsLazyPagingItems()
    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.statusBarColor

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }

    Scaffold(topBar = {
        SearchTopBar(
            text = searchQuery,
            onTextChanged = { searchViewModel.updateSearchQuery(query = it) },
            onSearchClicked = { searchViewModel.searchHeroes(query = it) },
            onCloseClicked = { navController.popBackStack() }
        )
    },
    content = { pv ->
        ListContent(heroes = heroes, navController = navController)
    }
    )
}