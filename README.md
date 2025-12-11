# BringItems

BringItems is a small, well-structured Android shopping/order list app built with modern Android tooling. It is designed to be a compact demonstration of practical Jetpack Compose UI patterns and common mobile features that are useful to showcase on job applications or portfolios.

## Quick highlights (for recruiters / hiring managers)

- Built with Kotlin and Jetpack Compose (modern, declarative UI).
- Uses Material 3 and Compose components for a clean, responsive UI.
- Implements a horizontal pager-based tab system using `HorizontalPager` (practical tab/navigation pattern).
- Uses Compose idioms such as `LazyVerticalGrid`, `LazyColumn`, and stateful UI with `mutableStateOf` / `mutableStateMapOf`.
- Simple, production-like features: item quantity management, total calculation, share integration via Android `Intent`, and local persistence patterns (can be adapted to DataStore).

This project is intentionally small and focused so reviewers can quickly understand your UI/UX and architecture choices.

---

## Why this project is relevant

- Demonstrates practical use of Jetpack Compose for building modern Android UIs.
- Shows how to connect stateful domain models (`CustomerOrders`) to Compose UI components.
- Includes integration points commonly asked about in interviews: background persistence, sharing via system intents, and responsive list/grid layouts.

## Key technologies

- Kotlin
- Jetpack Compose (Compose Foundation + Material3)
- HorizontalPager (compose.foundation.pager) for tab navigation
- LazyVerticalGrid and LazyColumn for performant lists/grids
- Android Intents for system share functionality
- (Optional) DataStore / SharedPreferences for local persistence patterns

## Project structure — where to look

- `app/src/main/java/com/ferhat/bringitems/MainActivity.kt` — App entry, pager (tabs) and high-level layout. Good spot to review Compose layout decisions and how UI state is wired.
- `app/src/main/java/com/ferhat/bringitems/CustomerOrders.kt` — Domain model that holds orders and quantity logic.
- `app/src/main/java/com/ferhat/bringitems/Toolkit.kt` — Utilities such as `exportTheList` and `shareText` (shows usage of Android `Intent.ACTION_SEND`).
- `app/src/main/java/com/ferhat/bringitems/ui/` — Composable UI components (e.g. `OrderList`, `ListOperationsBar`, `ProductsGrid`, `ProductCard`, `TotalBar`). Useful for evaluating composable design, preview usage and separation of concerns.

## Notable implementation details

- The app keeps order state in a `CustomerOrders` class implemented with Compose-friendly state containers (`mutableStateMapOf`, `mutableStateOf`).
- `HorizontalPager` is used to switch between the products grid and the order list — a practical example of a pager-based tabbed UI.
- Sharing the list is implemented with a simple `Intent` and supports multi-line text using `\n` line breaks.
- `ListOperationsBar` is placed below the `OrderList` by using a `Column` and giving the list `Modifier.weight(1f)` so the operations bar remains visible at the bottom.

## Build & run (quick)

Requirements: Android Studio (Arctic Fox or newer recommended), Android SDK, Java 11+. Clone the repo and run from Android Studio or use Gradle:

```bash
./gradlew assembleDebug
./gradlew installDebug
```

## Example usage

- Add items from the "Products" tab.
- Switch to the "List" tab to update quantities and use the bottom operations bar.
- Tap "Share" to open the system share sheet with a plain text representation (example):

```
Pepperoni x 3
Fanta x 8
```

Line breaks are included with the `\n` escape sequence.

## Interview talking points (suggested)

- Design decisions: why use a domain model (`CustomerOrders`) rather than storing state directly in composables.
- How Compose state flows from the model to UI and how to persist state across app restarts (DataStore vs SharedPreferences).
- Performance considerations: using `LazyColumn`/`LazyVerticalGrid` and keys for item stability.
- Extensibility: adding a ViewModel, migrating persistence to ProtoDataStore, or integrating navigation components.

## Contributing / Contact

If you want to suggest improvements or request a demo change for interview purposes, open an issue or send a PR. If you'd like, I can add a short `CONTRIBUTING.md` or a `DataStore` example branch.

## License

No license is included by default. If you publish this as part of a portfolio, consider adding an appropriate open-source license (e.g. MIT).

---

If you'd like, I can also:
- Add a short `CONTRIBUTING.md`.
- Add a one-page PDF cheat-sheet for interview talking points based on this repo.
- Add a sample `DataStore` implementation branch and a short demo snippet.
