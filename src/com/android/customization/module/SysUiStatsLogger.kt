/*
 * Copyright (C) 2022 The Android Open Source Project
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
package com.android.customization.module

import com.android.systemui.shared.system.SysUiStatsLog
import com.android.systemui.shared.system.SysUiStatsLog.STYLE_UICHANGED__CLOCK_SIZE__CLOCK_SIZE_UNSPECIFIED
import com.android.systemui.shared.system.SysUiStatsLog.STYLE_UICHANGED__COLOR_SOURCE__COLOR_SOURCE_UNSPECIFIED
import com.android.systemui.shared.system.SysUiStatsLog.STYLE_UICHANGED__DATE_PREFERENCE__DATE_PREFERENCE_UNSPECIFIED
import com.android.systemui.shared.system.SysUiStatsLog.STYLE_UICHANGED__EFFECT_PREFERENCE__EFFECT_PREFERENCE_UNSPECIFIED
import com.android.systemui.shared.system.SysUiStatsLog.STYLE_UICHANGED__LAUNCHED_PREFERENCE__LAUNCHED_PREFERENCE_UNSPECIFIED
import com.android.systemui.shared.system.SysUiStatsLog.STYLE_UICHANGED__LOCATION_PREFERENCE__LOCATION_PREFERENCE_UNSPECIFIED
import com.android.systemui.shared.system.SysUiStatsLog.STYLE_UICHANGED__SET_WALLPAPER_ENTRY_POINT__SET_WALLPAPER_ENTRY_POINT_UNSPECIFIED
import com.android.systemui.shared.system.SysUiStatsLog.STYLE_UICHANGED__WALLPAPER_DESTINATION__WALLPAPER_DESTINATION_UNSPECIFIED
import com.android.systemui.shared.system.SysUiStatsLog.STYLE_UI_CHANGED

/** The builder for [SysUiStatsLog]. */
class SysUiStatsLogger(val action: Int) {

    private var colorPackageHash = 0
    private var fontPackageHash = 0
    private var shapePackageHash = 0
    private var clockPackageHash = 0
    private var launcherGrid = 0
    private var wallpaperCategoryHash = 0
    private var wallpaperIdHash = 0
    private var colorPreference = 0
    private var locationPreference = STYLE_UICHANGED__LOCATION_PREFERENCE__LOCATION_PREFERENCE_UNSPECIFIED
    private var datePreference = STYLE_UICHANGED__DATE_PREFERENCE__DATE_PREFERENCE_UNSPECIFIED
    private var launchedPreference = STYLE_UICHANGED__LAUNCHED_PREFERENCE__LAUNCHED_PREFERENCE_UNSPECIFIED
    private var effectPreference = STYLE_UICHANGED__EFFECT_PREFERENCE__EFFECT_PREFERENCE_UNSPECIFIED
    private var effectIdHash = 0
    private var lockWallpaperCategoryHash = 0
    private var lockWallpaperIdHash = 0
    private var firstLaunchDateSinceSetup = 0
    private var firstWallpaperApplyDateSinceSetup = 0
    private var appLaunchCount = 0
    private var colorVariant = 0
    private var timeElapsedMillis = 0L
    private var effectResultCode = -1
    private var sessionId = 0
    private var setWallpaperEntryPoint = STYLE_UICHANGED__SET_WALLPAPER_ENTRY_POINT__SET_WALLPAPER_ENTRY_POINT_UNSPECIFIED
    private var wallpaperDestination = STYLE_UICHANGED__WALLPAPER_DESTINATION__WALLPAPER_DESTINATION_UNSPECIFIED
    private var colorSource = STYLE_UICHANGED__COLOR_SOURCE__COLOR_SOURCE_UNSPECIFIED
    private var seedColor = 0
    private var clockSize = STYLE_UICHANGED__CLOCK_SIZE__CLOCK_SIZE_UNSPECIFIED
    private var toggleOn = false
    private var shortcut = ""
    private var shortcutSlotId = ""

    fun setColorPackageHash(colorPackageHash: Int) = apply {
        this.colorPackageHash = colorPackageHash
    }

    fun setFontPackageHash(fontPackageHash: Int) = apply {
        this.fontPackageHash = fontPackageHash
    }

    fun setShapePackageHash(shapePackageHash: Int) = apply {
        this.shapePackageHash = shapePackageHash
    }

    fun setClockPackageHash(clockPackageHash: Int) = apply {
        this.clockPackageHash = clockPackageHash
    }

    fun setLauncherGrid(launcherGrid: Int) = apply { this.launcherGrid = launcherGrid }

    fun setWallpaperCategoryHash(wallpaperCategoryHash: Int) = apply {
        this.wallpaperCategoryHash = wallpaperCategoryHash
    }

    fun setWallpaperIdHash(wallpaperIdHash: Int) = apply {
        this.wallpaperIdHash = wallpaperIdHash
    }

    fun setColorPreference(colorPreference: Int) = apply {
        this.colorPreference = colorPreference
    }

    fun setLocationPreference(locationPreference: Int) = apply {
        this.locationPreference = locationPreference
    }

    fun setDatePreference(datePreference: Int) = apply { this.datePreference = datePreference }

    fun setLaunchedPreference(launchedPreference: Int) = apply {
        this.launchedPreference = launchedPreference
    }

    fun setEffectPreference(effectPreference: Int) = apply {
        this.effectPreference = effectPreference
    }

    fun setEffectIdHash(effectIdHash: Int) = apply { this.effectIdHash = effectIdHash }

    fun setLockWallpaperCategoryHash(lockWallpaperCategoryHash: Int) = apply {
        this.lockWallpaperCategoryHash = lockWallpaperCategoryHash
    }

    fun setLockWallpaperIdHash(lockWallpaperIdHash: Int) = apply {
        this.lockWallpaperIdHash = lockWallpaperIdHash
    }

    fun setFirstLaunchDateSinceSetup(firstLaunchDateSinceSetup: Int) = apply {
        this.firstLaunchDateSinceSetup = firstLaunchDateSinceSetup
    }

    fun setFirstWallpaperApplyDateSinceSetup(firstWallpaperApplyDateSinceSetup: Int) = apply {
        this.firstWallpaperApplyDateSinceSetup = firstWallpaperApplyDateSinceSetup
    }

    fun setAppLaunchCount(appLaunchCount: Int) = apply { this.appLaunchCount = appLaunchCount }

    fun setColorVariant(colorVariant: Int) = apply { this.colorVariant = colorVariant }

    fun setTimeElapsed(timeElapsedMillis: Long) = apply {
      this.timeElapsedMillis = timeElapsedMillis
    }

    fun setEffectResultCode(effectResultCode: Int) = apply {
        this.effectResultCode = effectResultCode
    }

    fun setSessionId(sessionId: Int) = apply {
        this.sessionId = sessionId
    }

    fun setSetWallpaperEntryPoint(setWallpaperEntryPoint: Int) = apply {
        this.setWallpaperEntryPoint = setWallpaperEntryPoint
    }

    fun setWallpaperDestination(wallpaperDestination: Int) = apply {
        this.wallpaperDestination = wallpaperDestination
    }

    fun setColorSource(colorSource: Int) = apply {
        this.colorSource = colorSource
    }

    fun setSeedColor(seedColor: Int) = apply {
        this.seedColor = seedColor
    }

    fun setClockSize(clockSize: Int) = apply {
        this.clockSize = clockSize
    }

    fun setToggleOn(toggleOn: Boolean) = apply {
        this.toggleOn = toggleOn
    }

    fun setShortcut(shortcut: String) = apply {
        this.shortcut = shortcut
    }

    fun setShortcutSlotId(shortcutSlotId: String) = apply {
        this.shortcutSlotId = shortcutSlotId
    }

    fun log() {
        SysUiStatsLog.write(
            STYLE_UI_CHANGED,
            action,
            colorPackageHash,
            fontPackageHash,
            shapePackageHash,
            clockPackageHash,
            launcherGrid,
            wallpaperCategoryHash,
            wallpaperIdHash,
            colorPreference,
            locationPreference,
            datePreference,
            launchedPreference,
            effectPreference,
            effectIdHash,
            lockWallpaperCategoryHash,
            lockWallpaperIdHash,
            firstLaunchDateSinceSetup,
            firstWallpaperApplyDateSinceSetup,
            appLaunchCount,
            colorVariant,
            timeElapsedMillis,
            effectResultCode,
            sessionId,
            setWallpaperEntryPoint,
            wallpaperDestination,
            colorSource,
            seedColor,
            clockSize,
            toggleOn,
            shortcut,
            shortcutSlotId,
        )
    }
}
