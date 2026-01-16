package net.milkbowl.vault2.minecraft;
/*
    This file is part of Vault.

    Vault is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Vault is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Vault.  If not, see <http://www.gnu.org/licenses/>.
 */

import net.milkbowl.vault2.helper.subject.Subject;
import org.bukkit.OfflinePlayer;

import static net.milkbowl.vault2.helper.subject.Subject.player;

/**
 * A utility class designed to assist with common operations and functionalities
 * in the Bukkit or Spigot API environment. This class contains static methods
 * and utilities that simplify plugin development tasks.
 *
 * This helper class is intended for use in Minecraft server plugins and
 * provides abstractions or shortcuts for typical operations involving the
 * Bukkit API.
 *
 * @author creatorfromhell
 * @since 2.18
 */
public class BukkitHelper {

  /**
   * Creates a {@code Subject} instance representing a player using the provided {@link OfflinePlayer}.
   *
   * This method generates a {@code Subject} by extracting the player's unique identifier (UUID)
   * and name from the given {@link OfflinePlayer} instance.
   *
   * @param player the {@link OfflinePlayer} instance containing the player's details
   * @return a {@code Subject} instance representing the specified player
   */
  public static Subject fromPlayer(final OfflinePlayer player) {
    return player(player.getUniqueId(), player.getName());
  }
}