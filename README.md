# XGIMI HDMI 1

A minimal Android TV application that adds an **HDMI 1** entry to the launcher and opens the first HDMI input when selected.

It is intended for XGIMI projectors whose firmware exposes the DROIDLOGIC TV input provider. It was developed and tested on a device identified by ADB as `MiProjM05`.

> **Compatibility notice**
>
> The app uses a manufacturer-specific, undocumented input URI:
> `content://android.media.tv/passthrough/com.droidlogic.tvinput%2F.services.Hdmi1InputService%2FHW5`
>
> It may not work on other XGIMI models, firmware versions, Android TV devices, or HDMI input configurations. On unsupported firmware, the app displays an error instead of switching input.

## Requirements

- Android 6.0 / API 23 or newer (`minSdk` 23)
- The project compiles against Android API 35 and targets API 28
- JDK 17
- Gradle 8.9 (included through the Gradle Wrapper)

## Build

Clone the repository and run:

```sh
./gradlew :app:assembleDebug
```

The debug APK is generated at:

```text
app/build/outputs/apk/debug/app-debug.apk
```

On Windows, use `gradlew.bat :app:assembleDebug` instead.

You can also open the project in Android Studio and let it synchronize Gradle.

## Install with ADB

Enable ADB debugging on the projector, connect it to your computer, then run:

```sh
adb devices
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

If ADB reports `INSTALL_FAILED_UPDATE_INCOMPATIBLE`, an installed version was signed with a different key. Remove it before installing the new one; this clears the app's local data:

```sh
adb uninstall fr.xgimi.hdmi1
adb install app/build/outputs/apk/debug/app-debug.apk
```

After installation, launch **HDMI 1** from the Android TV launcher and press **OK** to switch to the input.

## GitHub Actions

Every push to `main` triggers the Android build. A successful run uploads the debug APK as the `XgimiHDMI1-debug-apk` artifact in the repository's **Actions** tab.

## Project scope

This project only launches the projector's existing HDMI 1 input. It does not implement HDMI control itself and has no network or internet permissions.
