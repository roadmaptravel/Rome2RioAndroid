[![](https://jitpack.io/v/roadmaptravel/Rome2RioAndroid.svg)](https://jitpack.io/#roadmaptravel/Rome2RioAndroid)

# Rome2RioAndroid
A wrapper for the [Rome2Rio](https://www.rome2rio.com/) API. See the Rome2Rio [documentation](https://www.rome2rio.com/documentation/1-4/search/) for more information


## Download
### Gradle
Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency
```
dependencies {
    compile 'com.github.roadmaptravel:Rome2RioAndroid:0.1.3'
}

```

## Usage

This library makes use of RxAndroid for its calls.

```java
String key = "{YOUR API KEY}"
Rome2RioService service = new Rome2RioApiClient(this, key).getService();

// for more parameters, check the documentation of 
// the SearchRequest on https://www.rome2rio.com/documentation/1-4/search/
SearchRequest searchRequest = new SearchRequest.SearchRequestBuilder()
        .oName("Delft")
        .dName("London")
        .noBus()
        .noCar()
        .build();

service.getSearchResponseRx(searchRequest.toUrl())
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new SingleObserver<SearchResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(SearchResponse searchResponse) {
                Log.d("DEBUG", "onSuccess() called with: searchResponse = [" + searchResponse.toString + "]");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError() called with: e = [" + e + "]");
            }
        });
```
## License

    Copyright 2017 Roadmap
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
