//
//  Flow + Publisher.swift
//  iosApp
//
//  Created by Nail Shaykhraziev on 11.03.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import Combine
import Shared

func statePublisher<T>(_ flow: CommonFlow2<T>) -> AnyPublisher<T, Never> {
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T, Never>>> {
        let subject = PassthroughSubject<T, Never>()
        let closeable = flow.watch { next in
            guard let next else {
                return
            }
            subject.send(next)
        }

        return subject.handleEvents(receiveCancel: {
            closeable.close()
        })
    }.eraseToAnyPublisher()
}

public extension Kotlinx_coroutines_coreFlow {
    
}
