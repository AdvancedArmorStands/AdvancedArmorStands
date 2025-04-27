/*
 *
 * Copyright
 * 2025 AdvancedArmorStands, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.Q
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.parsa3323.aas.Options;

import com.parsa3323.aas.Options.Manager.SettingsOption;
import com.parsa3323.aas.Utils.PlayerUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CustomNameOption extends SettingsOption {

    public static final Map<UUID, ArmorStand> players = new HashMap<>();

    @Override
    public String getName() {
        return "CustomNameOption";
    }

    @Override
    public ItemStack getItemStack(ArmorStand armorStand) {
        ItemStack itemStack = PlayerUtils.getSkullFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWRlOGQwZjNlNDIxY2NlODU1NmViOGUzZTU4MzI1OWZmNjg3MzRiYTBmNGNhYjYzOWMyMzkwN2NkMmJlNGVmYyJ9fX0=");
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Custom name");
        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Set a custom name for");
        lore.add(ChatColor.GRAY + "this armor stand ");
        lore.add("");
        lore.add(ChatColor.GREEN + "Current name: " + armorStand.getCustomName());

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    @Override
    public void click(InventoryClickEvent e, ArmorStand armorStand) {
        Player p = (Player) e.getWhoClicked();

        if (!players.containsKey(p.getUniqueId())) {
            players.put(p.getUniqueId(), armorStand);
            p.sendMessage(ChatColor.GREEN + "Type the name you want to set in the chat, To exit type 'exit'");
            p.closeInventory();
        } else {
            p.sendMessage(ChatColor.RED + "You are already in a name set session");
        }

    }

    @Override
    public boolean updateInventory() {
        return false;
    }


}
