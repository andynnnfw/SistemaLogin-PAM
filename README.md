# 🔐 Android Login App

An Android application written in **Java** that implements a simple **sign-up, login and logged-in area** flow, with local data persistence using `SharedPreferences`.

> Study project — package `com.example.mtecpamianderson`

---

## 📱 Features

- **Create an account** with name, email and password
- **Login** validating the registered email and password
- **Remember my password** (keeps the user logged in between app launches)
- **Field validation** with error messages for empty inputs
- **Home screen** with a personalized greeting and the user's email
- **Logout**, which clears the logged-in status and returns to the login screen
- Dark interface (black background with red accents)

---

## 🗂️ Project Structure

```
app/src/main/
├── java/com/example/mtecpamianderson/
│   ├── MainActivity.java     # Login / sign-up screen
│   └── HomeActivity.java     # Home screen shown after login
└── res/
    ├── layout/
    │   ├── activity_main.xml # Login layout
    │   └── activity_home.xml # Home layout
    └── drawable/
        └── border.xml        # Text field border
```

---

## 🔄 App Flow

1. When the app opens, `MainActivity` checks whether `ManterLogado` is `true`.
   - If so, it goes straight to `HomeActivity`.
2. On the login screen, the user can:
   - **Create** → saves name, email and password in `SharedPreferences`.
   - **Enter** → compares the typed email and password with the saved ones. If the checkbox is checked, it stores `ManterLogado = true`.
3. In `HomeActivity`, the saved data is read and displayed.
4. Tapping **LOGOFF (SAIR)** sets `ManterLogado` back to `false` and returns to the login screen.

---

## 💾 Stored Data (SharedPreferences)

File: `login`

| Key            | Type      | Description                                  |
|----------------|-----------|----------------------------------------------|
| `NomeSalvo`    | `String`  | Registered user's name                       |
| `EmailSalvo`   | `String`  | Registered user's email                      |
| `SenhaSalva`   | `String`  | Registered user's password                   |
| `ManterLogado` | `boolean` | Whether the user should stay logged in       |

---

## 🛠️ Technologies

- Java
- Android SDK / AndroidX (`AppCompat`, `CardView`, `EdgeToEdge`)
- `SharedPreferences` for local storage
- XML layouts (`LinearLayout`)

---

## ▶️ Getting Started

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Open the project in **Android Studio**.
3. Wait for Gradle to sync.
4. Run it on an emulator or a physical device (**Run ▶️**).

**Requirements:** an up-to-date Android Studio and a device/emulator running an Android version compatible with the project's `minSdk`.

---

## ⚠️ Known Limitations

- The password is stored in **plain text** in `SharedPreferences`, which is **not secure** for production. In a real app, use `EncryptedSharedPreferences` or an authentication backend.
- Only **one user** can be registered at a time (a new sign-up overwrites the previous one).
- The **Name** field is also required at login, because the validation is shared with sign-up.
- The **Edit Profile** and **App Settings** buttons on the Home screen have no functionality yet.

---

## 🚀 Future Improvements

- Email format and password strength validation
- Separate validation for login and sign-up
- Encryption of sensitive data
- Multi-user support (e.g., Room/SQLite or Firebase Auth)
- Implement the profile editing and settings screens
- Constants for the `SharedPreferences` keys

---

## 👤 Author

Developed by **[Your Name]**.
