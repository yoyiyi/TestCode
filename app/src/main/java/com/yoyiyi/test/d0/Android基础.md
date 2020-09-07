## 1.什么是ANR 如何避免它？

## 2.Activity和Fragment生命周期有哪些？
onCreate onStart onResume onPause onStop onDestroy 
onAttach onCreate onCreateView onViewCreated onActivityCreated onDestroyView onDestroy  onDetach

## 3.Activity和Fragment生命周期有哪些？
android:configChanges 横屏一次 竖屏两次
android:configChanges="orientation" 横竖屏一次
android:configChanges="orientation|keyboardHidden" 不会，onConfigurationChanged