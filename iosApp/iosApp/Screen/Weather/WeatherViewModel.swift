//
//  WeatherViewModel.swift
//  iosApp
//
//  Created by Nail Shaykhraziev on 24.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//
import Foundation
import Shared
import Combine

class IosWeatherViewModel : ObservableObject {
    
    private let commonViewModel: CityWeatherViewModel
    
    @Published
    private(set) var state: CityWeatherViewState
    
    init(_ commonViewModel: CityWeatherViewModel) {
        self.commonViewModel = commonViewModel
        
        self.state = commonViewModel.viewStates.value
        (self.commonViewModel.viewStates.asPublisher() as AnyPublisher<CityWeatherViewState, Never>)
            .receive(on: RunLoop.main)
            .assign(to: &$state)
    }
    
    func obtainEvent(_ event : CityWeatherEvent) {
        self.commonViewModel.obtainEvent(event: event)
    }
    
    deinit {
        commonViewModel.onCleared()
    }
}
