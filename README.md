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

## Download

Users who do not want to build the project can download the APK from the [latest GitHub release](https://github.com/xzof/XgimiHDMI1/releases/latest).

Releases currently contain a debug-signed APK. Android may require installation from unknown sources to be enabled for the app used to open the download. Do not install an APK from an untrusted fork or third-party mirror.

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

## Installation

Install the APK on your projector using your preferred method.

After installation, launch **HDMI 1** from the Android TV launcher and press **OK** to switch to the input.

## GitHub Actions

Every push to `main` triggers the Android build. A successful run uploads the debug APK as the `XgimiHDMI1-debug-apk` artifact in the repository's **Actions** tab.

Pushing a version tag such as `v1.0.0` also creates a GitHub Release and attaches the APK, so it can be downloaded directly from the **Releases** page.

## Project scope

This project only launches the projector's existing HDMI 1 input. It does not implement HDMI control itself and has no network or internet permissions.
