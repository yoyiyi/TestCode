## 1.什么是ANR 如何避免它？

## 2.Activity和Fragment生命周期有哪些？
onCreate onStart onResume onPause onStop onDestroy 
onAttach onCreate onCreateView onViewCreated onActivityCreated onDestroyView onDestroy  onDetach

## 3.Activity和Fragment生命周期有哪些？
android:configChanges 横屏一次 竖屏两次
android:configChanges="orientation" 横竖屏一次
android:configChanges="orientation|keyboardHidden" 不会，调用onConfigurationChanged

## 4.AsyncTask的缺陷和问题，说说他的原理。
原理：SerialExecutor + THREAD_POOL_EXECUTOR + Handler（InternalHandler）
sHandler是一个静态的Handler对象 必须在主线程
轻量级的异步任务类
1.6 之前 串行
1.6-3.0  并行
3.0 之后 串行