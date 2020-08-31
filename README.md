# Currecny (Android)

![minSdk](https://img.shields.io/badge/minSdk-24-brightgreen.svg?style=flat) ![targetSdk](https://img.shields.io/badge/targetSdk-29-brightgreen.svg?style=flat) ![Bitrise](https://img.shields.io/bitrise/appid.svg?token=apptoken)


Currency

## Project info

- ApplicationId: `app.petermiklanek.currency`
- Supports: **Dark mode, landscape orientation**
- Architecture: [MVVM](https://github.com/futuredapp/arkitekt)
- Interactors: Kotlin Coroutines
- Product Flavors: mock, dev, prod
- Build Variants: debug, enterprise, release

### Used Tools

- Code style - **[ktlint](https://ktlint.github.io/)**, **[detekt](https://arturbosch.github.io/detekt/)**, **[Android lint](http://tools.android.com/tips/lint)**, **[Danger](https://github.com/futuredapp/danger)**


### Additional Scripts

1. `clean` - remove all `build` folders
2. `lintCheck` - run `ktlint`, `detekt` and `android lint` checks. Same runs on CI.
3. `dependencyUpdates` - check if never version of used dependencies are available
