/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.build.gradle.internal.ide

import com.android.builder.model.ViewBindingOptions
import java.io.Serializable

/**
 * Implementation of ViewBindingOptions that is Serializable.
 *
 * <p>Should only be used for the model.
 */
data class ViewBindingOptionsImpl(private val enabled: Boolean) : ViewBindingOptions, Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

    override fun isEnabled(): Boolean = enabled
}