# KitCleanerPlugin
This is a Paper plugin that resets the usage times of all kits by all players within CMI using its API. 

The program was developed as when trying to remove the data using SQL I found out the plugin was caching the data somewhere else.
When claiming a kit, the plugin will imediately fill the cached data back meaning that manipulating the database was not a solution. 
Thus, I have created this simple program.
