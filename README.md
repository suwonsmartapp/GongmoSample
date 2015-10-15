# 공모전 샘플 프로젝트

## Http 통신용 라이브러리 (OkHttp)
```
compile 'com.squareup.okhttp:okhttp:2.5.0'
```

## Json 파싱용 라이브러리 (Jackson)
```
compile 'com.fasterxml.jackson.core:jackson-databind:2.6.3'
```
## 수정 부분
### 소스
```
├── MainActivity.java
├── activities
├── fragments <- 여기
│   ├── ItemFragment.java (예제)
│   ├── LoadPictureFragment.java (예제)
│   ├── WeatherFragment.java (예제)
│   └── dummy (예제 - 가짜데이터)
│       └── DummyContent.java (예제)
├── managers
│   └── Manager.java <- 여기
├── models
│   └── Weather.java (예제)
├── network
│   └── NetworkUtils.java
├── utils
└── views
    ├── actionbar
    ├── adapters
    │   ├── LoadPictureAdapter.java (예제)
    │   └── WeatherAdapter.java (예제)
    ├── notifications
    └── widgets
```

### 리소스
```
menu
├── activity_main_drawer.xml <- 여기
└── main.xml

values
├── colors.xml
├── dimens.xml
├── drawables.xml
├── refs.xml
├── strings.xml <- 여기
└── styles.xml

```


