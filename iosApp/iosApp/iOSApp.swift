import SwiftUI
import shared

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate
    
	var body: some Scene {
		WindowGroup {
			CharactersView()
		}
	}
}

class AppDelegate: NSObject, UIApplicationDelegate {
    // https://developer.apple.com/documentation/uikit/uiapplicationdelegate/1622921-application
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        KoinKt.doInitKoin()
        return true
    }
}
