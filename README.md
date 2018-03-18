# Welcome to Rapid Router for Android
[Rapid Router](https://www.codeforlife.education/rapidrouter/) is an online game aimed at all ages with the primary goal of introducing coding concepts to children at earlier stages in their education. As the world of technology has continued to grow and flourish, this new age demands that we evolve with it, and so comes the demand for applications. We want to give people the opportunity to work with Rapid Router anywhere, on the move, and eventually even offline.

## Our Project
We currently have projects on GitHub that are designing the app version of Rapid Router for iOS. We are also working on developing an Android application alongside, which is where this repository comes in! The aim is to have all the functionality present on the web version available on the go, in a lightweight native solution.

## Getting Started
To get involved with this project, the first step is to clone via HTTPS or SSH. The preferred IDE is [Android Studio](https://developer.android.com/studio/index.html) as this will offer all the tools you need for getting up and running, and developing new features in no time! The project uses **Kotlin** and **Gradle**, and can be imported as an existing project into Android Studio. You may be prompted in the sync messages on import to download newer versions of the build tools. Go ahead and do that. A sync will then get everything downloaded and up to date.

Next add an AVD, like the Pixel C, and ensure it has the Oreo software version. `Ctrl+Shift+A` for Windows or `⌘+Shift+A` on a Mac and type `AVD`. Select the AVD Manager. Click the button to create a virtual device and search for Pixel devices. Select the Pixel C and click `Next`. Download the Oreo system image and select it before clicking `Next` again. Finalise the installation of the AVD.

Now you can run the app on this emulator device. It won't be possible to run the AVD quite as simply on certain machines, depending on the CPU specifications. If you have AMD rather than Intel drivers then you should try downloading Nougat `arm64-v8a` 7.1.1 system image under "Other Images" in the AVD virtual device configuration screen. You may also be prompted on first run to the install further APIs for full compatibility, and it should be noted that it will run a lot slower than when using a computer with the correct Intel support. If this doesn't work, or the slowness is an issue, then please use a physical device for testing.

## Where Can I Get Help?
The main contributors to this repository are our Android volunteers, and they are all happy to answer any questions you have. Please feel free to contact any of them and they will do their best to help. Alternatively, if you'd like to contact the Code for Life organisation directly then please don't hesitate to contact us directly using this [contact form](https://www.codeforlife.education/help/#contact) and we'll get in touch as soon as possible!

## Maintainers and Contributors
The contributors are mainly members of the ocadotechnology group, who consist primarily of volunteers for the Code for Life scheme. However we accept contributions from all sources in accordance with our contribution guidelines.
