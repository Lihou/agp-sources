/*
 * Copyright (C) 2020 The Android Open Source Project
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

package com.android.build.api.extension.impl

import com.android.build.api.extension.LibraryAndroidComponentsExtension
import com.android.build.api.variant.LibraryVariant
import com.android.build.api.variant.LibraryVariantBuilder
import com.android.build.gradle.internal.services.DslServices

open class LibraryAndroidComponentsExtensionImpl(
        dslServices: DslServices,
        variantBuilderOperations: OperationsRegistrar<LibraryVariantBuilder>,
        variantOperations: OperationsRegistrar<LibraryVariant>
):
        LibraryAndroidComponentsExtension,
        AndroidComponentsExtensionImpl<LibraryVariantBuilder, LibraryVariant>(
                dslServices,
                variantBuilderOperations,
                variantOperations
        )