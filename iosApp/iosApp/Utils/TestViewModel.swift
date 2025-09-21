////
////  TestViewModel.swift
////  iosApp
////
////  Created by Nail Shaykhraziev on 24.04.2025.
////  Copyright © 2025 orgName. All rights reserved.
////
//import Shared
//import Combine
//
//@MainActor
//class TestViewModel : ObservableObject {
//    
////    private let commonViewModel: CityWeatherViewModel = DIContainer.shared.get()
//    private let commonViewModel2: CityWeatherViewModel!
//    
//    @Published
//    private(set) var state: CityWeatherViewState
//    
//    let viewActionPublisher: AnyPublisher<CityWeatherAction, Never>
//    
//    init(viewModel: CityWeatherViewModel) {
//        self.commonViewModel2 = viewModel
//        
//        self.viewState = viewModel.viewStates().value
//        (self.commonViewModel2.viewStates().asPublisher() as AnyPublisher<CityWeatherViewState, Never>)
//            .receive(on: RunLoop.main)
//            .assign(to: &$state)
//        
//        viewActionPublisher = (viewModel.viewActions().asPublisher() as AnyPublisher<CityWeatherAction, Never>)
//    }
//    
//    func obtaionEvent(_ event: CityWeatherEvent) {
//        self.commonViewModel2.obtaionEvent(event)
//    }
//    
//    deinit {
//        self.commonViewModel2.onCleared()
//    }
//}
//
////    .onReceive(viewModel.viewActionPublisher) { action in
////        handleAction(action)
////    }
//
//// ------
//
//// actionSubscription = viewModel.viewActionPublisher.sink(receiveValue: { [weak self] action in
////      guard action != TimeslotsAction.EmptyAction.shared else { return }
//
//// actionSubscription?.cancel()
//
//@MainActor
//class IosProductsViewModel: ObservableObject {
//  private let commonVm: ProductsViewModel
//
//  @Published private(set) var state: ProductsState
//
//  init(commonVm: ProductsViewModel) {
//    self.commonVm = commonVm
//
//    self.state = self.commonVm.stateFlow.value
//    self.commonVm.stateFlow.subscribe(
//      scope: self.commonVm.viewModelScope,
//      onValue: { [weak self] in self?.state = $0 } // use weak self to avoid retain cycle.
//    )
//  }
//
//  func dispatch(action: ProductsAction) { self.commonVm.dispatch(action: action) }
//
//  deinit { self.commonVm.clear() }
//}
