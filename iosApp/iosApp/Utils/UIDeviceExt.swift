//
//  UIDeviceExt.swift
//  iosApp
//
//  Created by Nail Shaykhraziev on 04.03.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import UIKit
import Shared

extension UIDevice {

    var deviceType: Configuration.DeviceType {
        UIDevice.current.isPhone ? Configuration.DeviceType.phone : Configuration.DeviceType.tablet
    }

    var isPhone: Bool {
        UIDevice.current.userInterfaceIdiom == .phone
    }

    var isPad: Bool {
        UIDevice.current.userInterfaceIdiom == .pad
    }
}
