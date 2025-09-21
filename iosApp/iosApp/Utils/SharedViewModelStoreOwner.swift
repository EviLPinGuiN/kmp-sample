////
////  SharedViewModelStoreOwner.swift
////  iosApp
////
////  Created by Nail Shaykhraziev on 24.04.2025.
////  Copyright © 2025 orgName. All rights reserved.
////
//import Foundation
//import Shared
//
// @StateObject var viewModelStoreOwner = SharedViewModelStoreOwner<PlayerListViewModel>()
//
class SharedViewModelStoreOwner<VM : ViewModel> : ObservableObject, ViewModelStoreOwner {
    var viewModelStore: ViewModelStore = ViewModelStore()

    private let key: String = String(describing: type(of: VM.self))

    init(_ viewModel: VM = .init()) {
        viewModelStore.put(key: key, viewModel: viewModel)
    }

    var instance: VM {
        get {
            return viewModelStore.get(key: key) as! VM
        }
    }

    deinit {
        viewModelStore.clear()
    }
}
