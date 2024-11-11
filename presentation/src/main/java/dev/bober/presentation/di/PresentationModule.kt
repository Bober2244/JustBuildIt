package dev.bober.presentation.di

import dev.bober.presentation.ui.login.LoginViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {

    viewModelOf(::LoginViewModel)
}