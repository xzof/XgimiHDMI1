XGIMI HDMI 1 — projet Android minimal

Ce projet ajoute une application "HDMI 1" au lanceur Android TV.
Le bouton ouvre l'URI qui a été testée avec succès sur le projecteur :
content://android.media.tv/passthrough/com.droidlogic.tvinput%2F.services.Hdmi1InputService%2FHW5

Compilation :
1. Ouvrir le dossier XgimiHDMI1 dans Android Studio.
2. Laisser Android Studio synchroniser Gradle.
3. Menu Build > Build Bundle(s) / APK(s) > Build APK(s).
4. Le fichier sera créé dans app/build/outputs/apk/debug/app-debug.apk

Installation depuis le PC :
adb install -r app/build/outputs/apk/debug/app-debug.apk

Puis ouvrir "HDMI 1" depuis le lanceur du projecteur.

Note : l'application est fournie en code source, pas en APK précompilé.
