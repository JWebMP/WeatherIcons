# JWebMP Weather Icons

[![Maven Central](https://img.shields.io/maven-central/v/com.jwebmp.plugins/weather-icons)](https://central.sonatype.com/artifact/com.jwebmp.plugins/weather-icons)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)

![Java 25+](https://img.shields.io/badge/Java-25%2B-green)
![Modular](https://img.shields.io/badge/Modular-JPMS-green)
![Angular](https://img.shields.io/badge/Angular-21-DD0031?logo=angular)

<!-- Tech icons row -->
![Weather Icons](https://img.shields.io/badge/Weather_Icons-2.2-blueviolet)
![JWebMP](https://img.shields.io/badge/JWebMP-2.0-0A7)

222 weather themed icons for JWebMP applications — the only icon font dedicated to weather, maritime, and meteorological imagery. CSS web font rendering with `wi-` class prefix.

Built on [Weather Icons](http://erikflowers.github.io/weather-icons/) · [Angular 21](https://angular.dev/) · [JWebMP Core](https://jwebmp.com/) · JPMS module `com.jwebmp.plugins.weathericons` · Java 25+

**Version: 2.2** — Complete weather icon set with type-safe Java enum API.

## Installation

```xml
<dependency>
  <groupId>com.jwebmp.plugins</groupId>
  <artifactId>weather-icons</artifactId>
  <version>2.0.3-SNAPSHOT</version>
</dependency>
```

<details>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
implementation("com.jwebmp.plugins:weather-icons:2.0.0-SNAPSHOT")
```
</details>

## Features

- **222 Weather Themed Icons** — The only icon font dedicated to weather
- **Day & Night Conditions** — Sunny, cloudy, rain, snow, thunderstorm for both day and night
- **Moon Phases** — 28 moon phase icons plus 28 alternate variants
- **Wind System** — Beaufort scale (0–12), compass directions (16), degree-based directions (16 × 2)
- **Natural Disasters** — Earthquake, fire, flood, tornado, hurricane, tsunami, volcano
- **Measurement** — Thermometer, barometer, humidity, Celsius, Fahrenheit, degrees
- **Celestial** — Sunrise, sunset, moonrise, moonset, horizon, solar/lunar eclipse
- **Type-Safe Java Enum API** — `WeatherIcon` enum with compile-time safety
- **CRTP Fluent API** — `WeatherIcons<J>` component with type-safe method chaining
- **Zero Configuration** — Auto-registered via ServiceLoader SPI

## Quick Start

### Prerequisites

- **Java 25 LTS** (required)
- **Maven 3.8+**
- **Node.js 18+** (for frontend builds)
- **Angular 21+** (auto-integrated via JWebMP)

### Basic Usage

```java
import com.jwebmp.plugins.weathericons.WeatherIcons;
import com.jwebmp.plugins.weathericons.WeatherIcon;

// Sunny day
var sunny = new WeatherIcons<>(WeatherIcon.day_sunny);

// Night clear
var night = new WeatherIcons<>(WeatherIcon.night_clear);

// Rain
var rain = new WeatherIcons<>(WeatherIcon.rain);

// Wind direction
var wind = new WeatherIcons<>(WeatherIcon.towards_n);

// Temperature
var temp = new WeatherIcons<>(WeatherIcon.thermometer);
```

### Icon Categories

```java
// Day Conditions (22 icons)
WeatherIcon.day_sunny, WeatherIcon.day_cloudy, WeatherIcon.day_rain
WeatherIcon.day_snow, WeatherIcon.day_thunderstorm, WeatherIcon.day_fog

// Night Conditions (26 icons)
WeatherIcon.night_clear, WeatherIcon.night_cloudy, WeatherIcon.night_rain
WeatherIcon.night_snow, WeatherIcon.night_thunderstorm

// General Weather (18 icons)
WeatherIcon.cloud, WeatherIcon.cloudy, WeatherIcon.fog, WeatherIcon.rain
WeatherIcon.snow, WeatherIcon.hail, WeatherIcon.lightning

// Natural Disasters
WeatherIcon.earthquake, WeatherIcon.fire, WeatherIcon.flood
WeatherIcon.tornado, WeatherIcon.hurricane, WeatherIcon.tsunami, WeatherIcon.volcano

// Moon Phases (56 icons)
WeatherIcon.moon_new, WeatherIcon.moon_full, WeatherIcon.moon_first_quarter
WeatherIcon.moon_waxing_crescent_1 ... WeatherIcon.moon_waxing_crescent_6

// Wind Beaufort Scale (13 icons)
WeatherIcon.wind_beaufort_0 ... WeatherIcon.wind_beaufort_12

// Wind Compass Direction (32 icons)
WeatherIcon.towards_n, WeatherIcon.towards_ne, WeatherIcon.towards_e ...
WeatherIcon.from_n, WeatherIcon.from_ne, WeatherIcon.from_e ...

// Measurement
WeatherIcon.thermometer, WeatherIcon.barometer, WeatherIcon.humidity
WeatherIcon.celsius, WeatherIcon.fahrenheit, WeatherIcon.degrees

// Celestial
WeatherIcon.sunrise, WeatherIcon.sunset, WeatherIcon.moonrise, WeatherIcon.moonset
WeatherIcon.horizon, WeatherIcon.solar_eclipse, WeatherIcon.lunar_eclipse
```

---

## Architecture

### Module Structure

```
src/main/java/com/jwebmp/plugins/weathericons/
├── WeatherIcons.java                    # CRTP icon component (italic-based)
├── WeatherIcon.java                     # Enum with 222 icon constants
├── WeatherIconsPageConfigurator.java    # Auto-registration via ServiceLoader
└── implementations/
    ├── WeatherIconsInclusionModule.java
    └── WeatherExclusionsModule.java
```

---

## API Reference

### WeatherIcons Component

```java
public class WeatherIcons<J extends WeatherIcons<J>>
    extends Italic<J>
    implements IIcon<IComponentHierarchyBase<?,?>, J>

// Constructor
new WeatherIcons<>(WeatherIcon.day_sunny)

// Methods
icon.getClassName()      // Returns the icon CSS class name
icon.getIconComponent()  // Returns this component as IComponentHierarchyBase
```

### WeatherIcon Enum

All icons render with the `wi-` CSS class prefix. Underscores become dashes:

```java
WeatherIcon.day_sunny.toString()     // → "wi-day-sunny"
WeatherIcon.night_clear.toString()   // → "wi-night-clear"
WeatherIcon.wind_beaufort_5.toString() // → "wi-wind-beaufort-5"
WeatherIcon.towards_n.toString()     // → "wi-towards-n"
```

### Icon Count by Category

| Category | Count | Examples |
|----------|-------|----------|
| Day conditions | 22 | day_sunny, day_rain, day_snow |
| Night conditions | 26 | night_clear, night_cloudy, night_rain |
| General weather | 18 | cloud, rain, snow, lightning |
| Natural disasters | 7 | earthquake, tornado, tsunami |
| Moon phases | 56 | moon_new through moon_alt_waning_crescent_6 |
| Clock faces | 12 | time_1 through time_12 |
| Wind Beaufort | 13 | wind_beaufort_0 through wind_beaufort_12 |
| Wind compass | 32 | towards_n, from_n (16 each) |
| Wind degrees | 32 | towards_0_deg, from_0_deg (16 each) |
| Measurement | 7 | thermometer, barometer, humidity |
| Celestial | 7 | sunrise, sunset, horizon |
| Misc | 4 | alien, train, na, umbrella |

---

## Configuration

### Auto-Configuration via PageConfigurator

The plugin is automatically configured when present on the classpath. It registers `weather-icons.min.css` on all pages.

### Manual Disable (Optional)

```java
WeatherIconsPageConfigurator.setEnabled(false);
```

---

## Module Graph

```
com.jwebmp.plugins.weathericons
 ├── com.jwebmp.core              (JWebMP core)
 └── com.guicedee.guicedinjection (Guice DI)
```

### Exported Packages

- `com.jwebmp.plugins.weathericons` — Icon component, enum, and configurator

---

## Common Use Cases

### Weather Dashboard

```java
public class WeatherCard extends Div<WeatherCard> {
    public WeatherCard(WeatherIcon condition, String temperature) {
        var icon = new WeatherIcons<>(condition);
        add(icon);
        add(new Span<>(temperature));
    }
}

// Usage
var sunny = new WeatherCard(WeatherIcon.day_sunny, "28°C");
var rainy = new WeatherCard(WeatherIcon.rain, "15°C");
```

### Wind Direction Display

```java
var windIcon = new WeatherIcons<>(WeatherIcon.towards_ne);
var beaufort = new WeatherIcons<>(WeatherIcon.wind_beaufort_7);
```

### Moon Phase Tracker

```java
// Show current moon phase (0-27 maps to enum values)
WeatherIcon[] phases = {
    WeatherIcon.moon_new, WeatherIcon.moon_waxing_crescent_1,
    WeatherIcon.moon_waxing_crescent_2, // ...
    WeatherIcon.moon_full
};
var phase = new WeatherIcons<>(phases[currentPhaseIndex]);
```

---

## Testing

```bash
mvn clean test
```

---

## Documentation

- **[Weather Icons](http://erikflowers.github.io/weather-icons/)** — Official icon reference
- **[JWebMP Home](https://jwebmp.com/)** — JWebMP framework documentation

| File | Purpose |
|------|---------|
| `WeatherIcons.java` | CRTP icon component |
| `WeatherIcon.java` | Enum with 222 weather icons |
| `WeatherIconsPageConfigurator.java` | Auto-configuration via ServiceLoader |
| `module-info.java` | JPMS module descriptor |

---

## Security

- No external network calls at runtime
- No secrets or credentials required
- Pure CSS web font icon library

---

## Contributing

1. **Fork** the repository
2. **Create a feature branch** (`git checkout -b feature/my-feature`)
3. **Commit with clear messages** (`git commit -m "feat: add weather icon"`)
4. **Push to your fork** (`git push origin feature/my-feature`)
5. **Open a Pull Request**

---

## Project Status

| Aspect | Status |
|--------|--------|
| **Version** | 2.2 / 2.0.0-SNAPSHOT |
| **Icons** | 222 complete |
| **Java** | 25 LTS (required) |
| **Build** | Passing |
| **License** | Apache 2.0 |
| **Maintenance** | Active |

---

## Links

- **GitHub Repository**: https://github.com/JWebMP/JWebMP
- **Weather Icons**: http://erikflowers.github.io/weather-icons/
- **JWebMP Home**: https://jwebmp.com/

---

## License

Licensed under the [Apache License 2.0](LICENSE).

```
Copyright 2025 JWebMP Contributors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
```

---

## Acknowledgments

- **[Erik Flowers](https://github.com/erikflowers)** — Original Weather Icons icon font
- **[JWebMP](https://jwebmp.com/)** — Server-driven web framework
- **[Angular](https://angular.dev/)** — Modern web framework

---

## Support

- **GitHub Issues**: https://github.com/JWebMP/JWebMP/issues
- **Discussions**: https://github.com/JWebMP/JWebMP/discussions

---

**Made with JWebMP**

