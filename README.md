# BringItems

BringItems is a small, well-structured Android shopping/order list app built with modern Android tooling. It is designed to be a compact demonstration of practical Jetpack Compose UI patterns and common mobile features that are useful to showcase on job applications or portfolios.

## Quick highlights (for recruiters / hiring managers)

- Built with Kotlin and Jetpack Compose (modern, declarative UI).
- Uses Material 3 and Compose components for a clean, responsive UI.
- Implements a horizontal pager-based tab system using `HorizontalPager` (practical tab/navigation pattern).
- Uses Compose idioms such as `LazyVerticalGrid`, `LazyColumn`, and stateful UI with `mutableStateOf` / `mutableStateMapOf`.
- Simple, production-like features: item quantity management, total calculation, share integration via Android `Intent`, and local persistence patterns (can be adapted to DataStore).
- Category browsing added: users can filter products by category using a dedicated Categories page and a NavHost-based flow.
- Navigation implemented with Jetpack Navigation (Compose) — NavHost with distinct destinations for categories and items demonstrates basic Navigation 3 concepts in Compose.

This project is intentionally small and focused so reviewers can quickly understand your UI/UX and architecture choices.

---

## Why this project is relevant

- Demonstrates practical use of Jetpack Compose for building modern Android UIs.
- Shows how to connect stateful domain models (`CustomerOrders`) to Compose UI components.
- Includes integration points commonly asked about in interviews: background persistence, sharing via system intents, and responsive list/grid layouts.
- Shows a simple navigation flow (Categories -> Items) using a NavHost and composable destinations — useful to discuss route/state handling during interviews.

## Key technologies

- Kotlin
- Jetpack Compose (Compose Foundation + Material3)
- HorizontalPager (compose.foundation.pager) for tab navigation
- Jetpack Navigation for Compose (NavHost / composable destinations)
- LazyVerticalGrid and LazyColumn for performant lists/grids
- Android Intents for system share functionality
- (Optional) DataStore / SharedPreferences for local persistence patterns

## Project structure — where to look (new/important files)

- `app/src/main/java/com/ferhat/bringitems/ui/MainScreen.kt` — App-level scaffold, pager tabs and NavHost that wires category selection to the product list. Good place to see how navigation and state are connected.
- `app/src/main/java/com/ferhat/bringitems/ui/CategoriesPage.kt` — New: simple category list and selection handling.
- `app/src/main/java/com/ferhat/bringitems/ProductCategory.kt` — Enum of categories (includes an ALL category).
- `app/src/main/java/com/ferhat/bringitems/CustomerOrders.kt` — Domain model that holds orders and quantity logic (Compose-friendly state).
- `app/src/main/java/com/ferhat/bringitems/ui/ProductsGrid.kt` and `ProductCard.kt` — Product grid and card UI; filters items by selected category.
- `app/src/main/java/com/ferhat/bringitems/Toolkit.kt` — Utilities such as `exportTheList` and `shareText` (sharing via Intent).

## Notable implementation details

- Category view: a `CategoriesPage` lists categories; selecting a category updates a shared state (`targetCategory`) and navigates to the items screen where `ProductsGrid` filters products by that category.
- Navigation: a `NavHost` is used inside the products tab with two destinations (CATEGORIES, ITEMS). This demonstrates composing a local navigation graph inside a larger Compose layout (HorizontalPager + tabs).
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

- Open the "Products" tab.
- Choose a category in the Categories page, then view filtered items in the Items screen.
- Add items from the grid.
- Switch to the "List" tab to update quantities and use the bottom operations bar.
- Tap "Share" to open the system share sheet with a plain text representation (example):

```
Pepperoni x 3
Fanta x 8
```

Line breaks are included with the `\n` escape sequence.

## Interview talking points (suggested)

- Design decisions: why use a domain model (`CustomerOrders`) rather than storing state directly in composables.
- Navigation choices: local NavHost inside a tab, reasons to pick Navigation Compose for modular flows, how state is passed/kept between destinations.
- How Compose state flows from the model to UI and how to persist state across app restarts (DataStore vs SharedPreferences).
- Performance considerations: using `LazyColumn`/`LazyVerticalGrid` and keys for item stability.
- Extensibility: adding a ViewModel, migrating persistence to ProtoDataStore, integrating deeper navigation (deep links, nested graphs), or adding accessibility improvements.

## Contributing / Contact

If you want to suggest improvements or request a demo change for interview purposes, open an issue or send a PR. If you'd like, I can add a short `CONTRIBUTING.md` or a `DataStore` example branch.

## License

No license is included by default. If you publish this as part of a portfolio, consider adding an appropriate open-source license (e.g. MIT).

---

