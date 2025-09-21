////
////  SharedViewModel.swift
////  iosApp
////
////  Created by Nail Shaykhraziev on 24.04.2025.
////  Copyright © 2025 orgName. All rights reserved.
////
//import Foundation
//import Shared
//
////
////@StateObject var viewModel = SharedViewModel<LeaguesViewModel>()
//
class SharedViewModel<T : Lifecycle_viewmodelViewModel> : ObservableObject {

    let instance: T

    init(_ viewModel: T = .init()) {
        self.instance = viewModel
    }

    deinit {
        // cancel the scope of the viewmodel
        self.instance.cancelViewModelScope()
        // call `onCleared` viewmodel event
        self.instance.onCleared()
    }
}
// iosSourceSet
// fun ViewModel.cancelViewModelScope() {
//     if (viewModelScope.isActive) {
//         viewModelScope.cancel("Manually cancelling viewModelScope for iOS Target")
//     }
// }
