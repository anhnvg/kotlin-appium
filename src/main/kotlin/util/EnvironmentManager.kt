package util

object EnvironmentManager {

    val isRealIosDevice: Boolean = false
    val isRemoteAppiumServer: Boolean = false
    val platform: Platform = Platform.Android
}

enum class Platform {
    IOS,
    Android
}