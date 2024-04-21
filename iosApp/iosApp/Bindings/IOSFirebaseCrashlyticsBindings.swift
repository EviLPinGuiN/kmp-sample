//
//  IOSFirebaseCrashlyticsBindings.swift
//  iosApp
//
//  Created by Nail Shaykhraziev on 15.04.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import Shared
import FirebaseCrashlytics

final class IOSFirebaseCrashlyticsBindings: FirebaseCrashlyticsBindings {

    func nonFatal(error: KotlinThrowable) {
        Crashlytics.crashlytics().record(error: error.asError())
    }
    
    func setParams(key: String, value: String) {
        Crashlytics.crashlytics().setCustomValue(value, forKey: key)
    }
}
