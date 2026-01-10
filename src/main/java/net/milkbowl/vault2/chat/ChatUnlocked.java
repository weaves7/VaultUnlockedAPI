package net.milkbowl.vault2.chat;
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

import net.milkbowl.vault2.helper.Context;
import net.milkbowl.vault2.helper.Subject;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * ChatUnlocked
 *
 * @author creatorfromhell
 * @since 2.18
 */
public interface ChatUnlocked {

  /**
   * Checks whether this chat provider is enabled.
   *
   * @return true if the chat provider is enabled; false otherwise.
   * @since 2.18
   */
  boolean isEnabled();

  /**
   * Retrieves the name of this chat provider.
   *
   * @return the name of the chat provider as a non-null string.
   * @since 2.18
   */
  @NotNull
  String getName();

  /**
   * Checks whether the chat provider supports group-based prefixes, suffices and info nodes.
   *
   * @return true if group-based prefixes, suffices and info nodes are supported; false otherwise.
   * @since 2.18
   */
  boolean hasGroupSupport();

  /**
   * Retrieves the prefix for the specified subject within the given context.
   *
   * @param context the context in which the prefix is being retrieved; must not be null
   * @param subject the subject whose prefix is to be retrieved; must not be null
   * @return an optional containing the prefix if it exists, or an empty optional if no prefix is set
   * @since 2.18
   */
  Optional<String> getPrefix(@NotNull Context context, @NotNull Subject subject);

  /**
   * Retrieves the suffix for the specified subject within the given context.
   *
   * @param context the context in which the suffix is being retrieved; must not be null
   * @param subject the subject whose suffix is to be retrieved; must not be null
   * @return an optional containing the suffix if it exists, or an empty optional if no suffix is set
   * @since 2.18
   */
  Optional<String> getSuffix(@NotNull Context context, @NotNull Subject subject);

  /**
   * Sets the prefix for the specified subject within the given context.
   *
   * @param context the context in which the prefix is being set; must not be null
   * @param subject the subject for which the prefix is being updated; must not be null
   * @param prefix  the new prefix to be assigned; must not be null
   * @return true if the prefix was successfully set, false otherwise
   * @since 2.18
   */
  boolean setPrefix(@NotNull Context context, @NotNull Subject subject, @NotNull String prefix);

  /**
   * Sets the suffix for the specified subject within the given context.
   *
   * @param context the context in which the suffix is being set; must not be null
   * @param subject the subject for which the suffix is being updated; must not be null
   * @param suffix  the new suffix to be assigned; must not be null
   * @return true if the suffix was successfully set, false otherwise
   * @since 2.18
   */
  boolean setSuffix(@NotNull Context context, @NotNull Subject subject, @NotNull String suffix);

  /**
   * Retrieves the prefix for a specified group within a given context.
   *
   * @param context the context in which the group-based prefix is being retrieved; must not be null
   * @param group   the group from which the prefix is being retrieved; must not be null
   * @return an optional containing the prefix if it exists, or an empty optional if no prefix is set for the group
   */
  Optional<String> getGroupPrefix(@NotNull Context context, @NotNull String group);

  /**
   * Retrieves the suffix for a specified group within a given context.
   *
   * @param context the context in which the group-based suffix is being retrieved; must not be null
   * @param group   the group from which the suffix is being retrieved; must not be null
   * @return an optional containing the suffix if it exists, or an empty optional if no suffix is set for the group
   * @since 2.18
   */
  Optional<String> getGroupSuffix(@NotNull Context context, @NotNull String group);

  /**
   * Sets the prefix for a specific group within a given context.
   *
   * @param context the context in which the group-based prefix is being set; must not be null
   * @param group   the group to which the prefix applies; must not be null
   * @param prefix  the new prefix to be assigned to the group; must not be null
   * @return true if the prefix was successfully set for the group, false otherwise
   * @since 2.18
   */
  boolean setGroupPrefix(@NotNull Context context,  @NotNull String group, @NotNull String prefix);

  /**
   * Sets the suffix for a specific group within a given context.
   *
   * @param context the context in which the group-based suffix is being set; must not be null
   * @param group   the group to which the suffix applies; must not be null
   * @param suffix  the new suffix to be assigned to the group; must not be null
   * @return true if the suffix was successfully set for the group, false otherwise
   * @since 2.18
   */
  boolean setGroupSuffix(@NotNull Context context, @NotNull String group, @NotNull String suffix);
}