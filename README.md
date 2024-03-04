## How to build project

#### Android

Ready to start out off box.

#### iOS

* Install CocoaPods. [How to](https://guides.cocoapods.org/using/getting-started.html)
* Update pods and open Xcworkspace from `iosApp` folder:

```bash 
pod install --repo-update 
```

Shared part(gradle) require Java for building iOS-app. You can download jdk by [link](https://www.oracle.com/java/technologies/downloads/#java11-mac) or with using `brew`:
```bash
brew install openjdk@17
```

If the system doesn't see Java after installation, you can make a symlink to it using:
```bash
sudo ln -sfn $(brew --prefix)/opt/openjdk@17/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-17.jdk
```

If your have problem with ruby, then should reinstall it:
```bash
brew install rbenv
rbenv init
rbenv install 2.7.6
rbenv global 2.7.6
```

And reinstall cocoapods:
```bash
brew remove cocoapods
gem install cocoapods
gem install cocoapods-generate
```
