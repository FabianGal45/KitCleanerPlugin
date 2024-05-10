# KitCleanerPlugin
This Paper plugin resets the usage times of all kits by all players within [CMI's API](https://github.com/Zrips/CMI-API?tab=readme-ov-file).

I developed this program because no method is provided within CMI to remove all usage times by all players. At first, I tried to remove the data using SQL, to which I discovered that the plugin was caching said data. When a kit is claimed, the plugin promptly restores the cached data, making database manipulation ineffective. Therefore, I created this simple Java program that uses CMI's methods to achieve my initial goal.
