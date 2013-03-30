# 2013-03-30 おいしいアプリ開発 08 プロジェクト

## How to build and install with CLI

Set paths to `ant` (Apache Ant), `android-sdk-*/tools/android` and `android-sdk-*/platform-tools/adb`.

### Setup

```
android update project -p ./
```

`local.properties` is generated.

### Build

```
ant debug
```

### Install

```
adb -d install -r bin/MainActivity-debug.apk
```
