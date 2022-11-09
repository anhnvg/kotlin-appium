package framework
import util.EnvironmentManager.isRemoteAppiumServer

object AppiumServerManager {
    val serverAddress = if (isRemoteAppiumServer) "<IP>:<PORT>/wd/hub" else "http://127.0.0.1:4723/wd/hub"
}