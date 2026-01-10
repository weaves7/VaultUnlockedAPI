package net.milkbowl.vault2.helper.subject;
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

import org.bukkit.OfflinePlayer;

import java.util.UUID;

/**
 * Represents a subject with a unique identifier, a name, and a flag indicating
 * whether the subject is a player.
 *
 * This class provides methods to retrieve the subject's identifier and name,
 * with additional metadata annotations to indicate nullability.
 *
 * @author creatorfromhell
 * @since 2.18
 */
public class Subject {

  private final String identifier;
  private final String displayIdentifier;
  private final SubjectType type;

  /**
   * Constructs a new {@code Subject} instance with the specified identifier, display identifier, and type.
   * If this is a player, the identifier is the stringified UUID of the player, and the display identifier is the player's username.
   * If this is a group, the identifier is the group name or stringified UUID of the group if applicable,
   * and the display identifier is the same as the identifier or name if the identifier is UUID.
   *
   * @param identifier         the unique identifier for the subject
   * @param displayIdentifier  the display name associated with the subject
   * @param type               the type of the subject, indicating whether it is a player or group
   */
  private Subject(final String identifier, final String displayIdentifier, final SubjectType type) {
    this.identifier = identifier;
    this.displayIdentifier = displayIdentifier;
    this.type = type;
  }

  public String identifier() {
    return identifier;
  }

  public UUID asUUID() {
    return UUID.fromString(identifier);
  }

  public String displayIdentifier() {
    return displayIdentifier;
  }

  public SubjectType type() {
    return type;
  }

  /**
   * Creates a {@code Subject} instance representing a player using the given unique identifier and username.
   *
   * This method generates a {@code Subject} with the specified UUID as the unique identifier
   * and the provided username as the display identifier. The {@code SubjectType} for this
   * subject is set to {@code PLAYER}.
   *
   * @param uuid      the unique identifier (UUID) of the player
   * @param username  the username associated with the player
   * @return a {@code Subject} instance representing the specified player
   */
  public static Subject player(final UUID uuid, final String username) {
    return new Subject(uuid.toString(), username, SubjectType.PLAYER);
  }

  /**
   * Creates a {@code Subject} instance representing a group using the given group name.
   *
   * This method generates a {@code Subject} with the specified group name as both
   * the unique identifier and display identifier, and sets the subject type to {@code GROUP}.
   *
   * @param groupName the name of the group to be used as the identifier and display identifier
   * @return a {@code Subject} instance representing the specified group
   */
  public static Subject group(final String groupName) {
    return new Subject(groupName, groupName, SubjectType.GROUP);
  }

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