package eu.ovmc.kitcleanerplugin;

import com.Zrips.CMI.CMI;
import com.Zrips.CMI.Containers.CMIUser;
import com.Zrips.CMI.Modules.Kits.Kit;
import com.Zrips.CMI.Modules.Kits.KitsManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class KitCleanCommand implements CommandExecutor {



    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof ConsoleCommandSender) {
//            SQLiteJDBC mSQLite = new SQLiteJDBC();
//            Connection con = mSQLite.connectToCMIDB();
//            mSQLite.removeKits(con); // does the same thing

            Map<UUID, CMIUser> allUsers  = CMI.getInstance().getPlayerManager().getAllUsers();
            KitsManager kitsManager = CMI.getInstance().getKitsManager();


            for(Map.Entry<UUID, CMIUser> userIter : allUsers.entrySet()){
                CMIUser user = userIter.getValue();

                //start
                kitsManager.clearCache(userIter.getKey());
                LinkedHashMap<String, Kit> kits = kitsManager.getKitMap();

                System.out.println("Resetting kits for for: "+user.getName());
                for(Kit kit:kits.values()){
                    user.resetKitUseTimes(kit);
                }

                kitsManager.clearCache(userIter.getKey());
                user.saveIfOffline();
            }

        }

        return false;
    }
}
