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

package com.parsa3323.aas.options;

import com.parsa3323.aas.options.manager.SettingsOption;
import com.parsa3323.aas.utils.VersionSupportUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GravityOption extends SettingsOption {
    @Override
    public String getName() {
        return "GravityOption";
    }

    @Override
    public ItemStack getItemStack(ArmorStand armorStand) {
        ItemStack itemStack = VersionSupportUtil.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWU3YTQ3MzNjMDgzMGM4YjQyNWI2MjEzNzc4MGJkYmVmNTdiMTNhODg3YWFhZjExNzNjNmNlMGExZDc4NDFmMSJ9fX0=");
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Gravity");
        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Enable and disable");
        lore.add(ChatColor.GRAY + "gravity for this armor stand ");
        lore.add("");
        lore.add((armorStand.hasGravity()) ? ChatColor.GREEN + "✔ Has gravity" : ChatColor.RED + "✘ Doesn't have gravity");

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    @Override
    public void click(InventoryClickEvent e, ArmorStand armorStand) {
        armorStand.setGravity(!armorStand.hasGravity());

    }

    @Override
    public boolean updateInventory() {
        return true;
    }
}
