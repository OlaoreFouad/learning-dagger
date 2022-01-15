package dev.olaore.learning_dagger.common.di.service

import android.app.Service
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent

@Module
@InstallIn(ServiceComponent::class)
class ServiceModule