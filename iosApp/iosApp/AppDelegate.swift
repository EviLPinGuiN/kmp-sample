//
//  AppDelegate.swift
//  iosApp
//
//  Created by Nail Shaykhraziev on 15.04.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import FirebaseCore

class AppDelegate: NSObject, UIApplicationDelegate {
    
  func application(
    _ application: UIApplication,
    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil
  ) -> Bool {

    print("Colors application is starting up. ApplicationDelegate didFinishLaunchingWithOptions.")
    FirebaseApp.configure()
    return true
  }
}
