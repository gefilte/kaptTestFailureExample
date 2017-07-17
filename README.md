
Example for KT-18895
====================

Reference: https://youtrack.jetbrains.com/issue/KT-18895

Compiling the `androidDebugTest` target will not work with this. `kapt3` will generate the Dagger kapt output 
for the `debug` target but not the `androidDebugTest` target.

If you downgrade Kotlin to 1.1.2, and switch to `kapt2`, tests will build, run, and pass, and you can
see the generated dagger source files in `build/generated/source/kapt/debugAndroidTest`.

