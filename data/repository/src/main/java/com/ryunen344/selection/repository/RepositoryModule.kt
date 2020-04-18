package com.ryunen344.selection.repository

import com.ryunen344.selection.repository.github.GitHubRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { GitHubRepository(get()) }
}
