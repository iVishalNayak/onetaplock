# One Tap Lock

A minimal Android app: tap its launcher icon to lock the phone.

## Build the APK without installing Android tools on your PC

This project includes a GitHub Actions workflow that builds the APK in the cloud.

1. Create a free GitHub account at https://github.com/ if you do not already have one.
2. Create a new repository. You can name it `OneTapLock`.
3. Extract this ZIP on your PC.
4. Upload the **contents** of the extracted folder to the new repository (including the `.github` folder), and commit to the `main` branch.
   - On GitHub, use **Add file > Upload files**. Make sure hidden folders such as `.github` are included; if your browser hides them, use GitHub Desktop or enable showing hidden files in your file manager.
5. Open the repository's **Actions** tab. Select **Build One Tap Lock APK** and click **Run workflow** if it has not already started.
6. When the workflow finishes successfully, open that run, scroll to **Artifacts**, and download **OneTapLock-APK**.
7. Extract the artifact ZIP. It contains `app-debug.apk`. Transfer it to your Android phone and install it. You may need to allow installation from that source.

The workflow installs Java, Gradle, and Android SDK in GitHub's temporary build environment. None of those need to be installed on your PC.

## Install and use

1. Install the APK on your Android phone.
2. Open **One Tap Lock**. On first launch, Android asks you to activate its Device Administrator permission.
3. Approve the request. The phone should lock as the app returns to the foreground.
4. After that, tapping the app icon locks the phone immediately.

## Remove the app

First deactivate **One Tap Lock** under Android Settings > Security / More security settings > Device admin apps (the exact menu varies by phone), then uninstall it.

The app uses Android's official DevicePolicyManager `lockNow()` API. It does not need root, accessibility access, internet, or background services.
