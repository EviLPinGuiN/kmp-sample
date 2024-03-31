//
//  WeatherUIView.swift
//  iosApp
//
//  Created by Nail Shaykhraziev on 11.03.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct WeatherUIView: View {
    var body: some View {
        Spacer()

        Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
            .frame(maxWidth: .infinity)
            .font(/*@START_MENU_TOKEN@*/.title/*@END_MENU_TOKEN@*/)
            .background()
            .onTapGesture(perform: {

            })

        Button(action: {

        }, label: {
            /*@START_MENU_TOKEN@*/Text("Button")/*@END_MENU_TOKEN@*/
        })

        let test = ["", "asd"]
        List(test, id: \.self) { text in
//            Item()
        }

        LazyVStack {

        }

        GeometryReader { reader in

        }

        Spacer().frame(height: 20)
    }
}

#Preview {
    WeatherUIView()
}
