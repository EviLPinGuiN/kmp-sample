import SwiftUI
import Shared

struct ContentView: View {

    private let router = Router()
	private let greet = Greeting().greet()

	var body: some View {
		Text(greet)
            .background(.primary)
            .onTapGesture {
                handleAction(MainAction.Close())
            }
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
