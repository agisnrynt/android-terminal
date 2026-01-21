-keep class com.example.toyboxrun.MainActivity { *; }

-dontwarn **
-dontobfuscate               # optional, often smaller without obfuscation in tiny apps

# Kill logging completely
-assumenosideeffects class android.util.Log {
    *;
}

# Very aggressive — test if app still launches
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*