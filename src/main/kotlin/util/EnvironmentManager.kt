package util

object EnvironmentManager {

    val isRealIosDevice: Boolean = false
    val isRemoteAppiumServer: Boolean = false
    val platform: Platform = Platform.IOS
}

enum class Platform {
    IOS,
    Android
}