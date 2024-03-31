import SwiftUI
import Shared

struct ContentView: View {

    private let router = Router()
	private let greet = Greeting().greet()

//    private let viewModel = XViewModel()

	var body: some View {
//        let cancelable = statePublisher(viewModel.uiState).sink { state in
//            state.weather.cloudsPercent
//        }
//        viewModel.uiState.watch { state in
//            state?.weather.humidity
//        }
		Text(greet)
            .background(.primary)
            .onTapGesture {
                handleAction(MainAction.Close())
            }
//            .onReceive(statePublisher(viewModel.uiState), perform: { state in
//                state.weather.humidity
//            })
	}

    private func handleAction(_ action: MainAction?) {
        switch action {
        case _ as MainAction.Close:
            router.routeToExit()
        case action as MainAction.ShowMessage:
//            print("TEST: \(action.name)")
//        case .ShowMessage(_: name):
            print("TEST")
            return
        default:
            return
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

final class Router {

    func routeToExit() {

    }
}
