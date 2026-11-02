package com.jwebmp.plugins.weathericons;

import com.jwebmp.core.base.angular.client.annotations.angularconfig.NgStyleSheet;
import com.jwebmp.core.base.angular.client.annotations.typescript.TsDependency;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;

/**
 * Page configurator for Weather Icons — registers weather-icons CSS via npm.
 */
@PluginInformation(pluginName = "Weather Icons",
		pluginUniqueName = "weather-icons",
		pluginDescription = "Weather Icons is the only icon font with 222 weather themed icons for meteorological applications.",
		pluginVersion = "2.0.12",
		pluginDependancyUniqueIDs = "",
		pluginCategories = "icons",
		pluginSubtitle = "Weather Icons is the only icon font and CSS with 222 weather themed icons",
		pluginGitUrl = "https://github.com/JWebMP/JWebMP",
		pluginSourceUrl = "https://github.com/erikflowers/weather-icons",
		pluginWikiUrl = "https://github.com/JWebMP/JWebMP/wiki",
		pluginOriginalHomepage = "http://erikflowers.github.io/weather-icons/",
		pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins/weather-icons",
		pluginIconUrl = "",
		pluginIconImageUrl = "",
		pluginLastUpdatedDate = "2026/05/09",
		pluginGroupId = "com.jwebmp.plugins",
		pluginArtifactId = "weather-icons",
		pluginModuleName = "com.jwebmp.plugins.weathericons",
		pluginStatus = PluginStatus.Released
)
@TsDependency(value = "weathericons", version = "^2.1.0")
@NgStyleSheet("node_modules/weathericons/css/weather-icons.min.css")
@NgStyleSheet("node_modules/weathericons/css/weather-icons-wind.min.css")
public class WeatherIconsPageConfigurator
		implements IPageConfigurator<WeatherIconsPageConfigurator>
{
	@Override
	public IPage<?> configure(IPage<?> page)
	{
		return page;
	}

	@Override
	public boolean enabled()
	{
		return true;
	}
}
