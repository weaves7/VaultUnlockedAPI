package net.milkbowl.vault2.permission;
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
import net.milkbowl.vault2.helper.TriState;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * PermissionsUnlocked
 *
 * @author creatorfromhell
 * @since 2.18
 */
public interface PermissionUnlocked {

  /**
   * Checks whether this permission provider is enabled.
   *
   * @return true if the permission provider is enabled; false otherwise.
   * @since 2.18
   */
  boolean isEnabled();

  /**
   * Retrieves the name of this permission provider.
   *
   * @return the name of the permission provider as a non-null string.
   * @since 2.18
   */
  @NotNull
  String getName();

  /**
   * Checks whether the permission provider supports group-based permissions.
   *
   * @return true if group-based permissions are supported; false otherwise.
   * @since 2.18
   */
  boolean hasGroupSupport();

  /**
   * Checks whether the permission provider supports SuperPerms.
   *
   * @return true if SuperPerms are supported; false otherwise.
   * @since 2.18
   */
  boolean hasSuperPermsSupport();

  /**
   * Retrieves the permission state for a given context, subject, and permission identifier.
   *
   * @param context the context in which the permission is being checked cannot be null
   * @param subject the subject for whom the permission is being checked cannot be null
   * @param permission the identifier of the permission to check cannot be null
   * @return a {@link TriState} value indicating the permission state, which can be TRUE, FALSE, or UNDEFINED
   * @since 2.18
   */
  @NotNull
  TriState has(@NotNull Context context, @NotNull Subject subject, @NotNull String permission);

  /**
   * Asynchronously retrieves the permission state for a given context, subject, and permission identifier.
   *
   * @param context the context in which the permission is being checked; cannot be null
   * @param subject the subject for whom the permission is being checked; cannot be null
   * @param permission the identifier of the permission to check; cannot be null
   * @return a {@link CompletableFuture} that completes with a {@link TriState} value indicating the permission state,
   *         which can be TRUE, FALSE, or UNDEFINED
   * @since 2.18
   */
  @NotNull
  CompletableFuture<TriState> hasAsync(@NotNull final Context context, @NotNull final Subject subject,
                                       @NotNull final String permission);

  /**
   * Sets the specified permission for a subject within a given context to a specified state.
   *
   * @param context the context in which the permission is being set; cannot be null
   * @param subject the subject for whom the permission is being set; cannot be null
   * @param permission the identifier of the permission to modify; cannot be null
   * @param value the {@link TriState} value indicating the desired state of the permission; cannot be null
   * @return true if the permission was successfully set, false otherwise
   * @since 2.18
   */
  boolean setPermission(@NotNull Context context, @NotNull Subject subject, @NotNull String permission,
                        @NotNull TriState value);

  /**
   * Asynchronously sets the specified permission to a given tri-state value for a subject within a context.
   *
   * @param context the context within which the permission should be set, not null
   * @param subject the subject for whom the permission is being set, not null
   * @param permission the specific permission to set, not null
   * @param value the tri-state value to set for the permission, not null
   * @return a CompletableFuture that completes with `true` if the permission was successfully set,
   * or `false` if the operation failed
   * @since 2.18
   */
  @NotNull
  CompletableFuture<Boolean> setPermissionAsync(@NotNull Context context, @NotNull Subject subject,
                                                @NotNull String permission, @NotNull TriState value);

  /**
   * Sets a transient permission for a specific subject within a given context to a specified value.
   * Transient permissions are temporary and do not persist beyond the current runtime.
   *
   * @param context the context in which the permission is being set; cannot be null
   * @param subject the subject for whom the transient permission is being set; cannot be null
   * @param permission the identifier of the permission to modify; cannot be null
   * @param value the {@link TriState} value indicating the desired state of the permission; cannot be null
   * @return true if the transient permission was successfully set, false otherwise
   * @since 2.18
   */
  boolean setTransientPermission(@NotNull Context context, @NotNull Subject subject, @NotNull String permission,
                                 @NotNull TriState value);

  /**
   * Asynchronously sets a transient permission for the specified subject in the given context.
   * A transient permission is not persisted and will only last for the duration of the program's runtime.
   *
   * @param context the context in which the permission is to be set, must not be null
   * @param subject the subject to which the permission is to be assigned, must not be null
   * @param permission the permission string to be set, must not be null
   * @param value the state of the permission (true, false, or undefined), must not be null
   *
   * @return a CompletableFuture that will complete with a boolean indicating whether the permission change was successful
   * @since 2.18
   */
  @NotNull
  CompletableFuture<Boolean> setTransientPermissionAsync(@NotNull Context context, @NotNull Subject subject,
                                                         @NotNull String permission, @NotNull TriState value);

  /**
   * Retrieves the array of group names associated with this permission provider.
   *
   * @return an array of group names as non-null strings. The array may be empty if no groups are defined.
   * @since 2.18
   */
  @NotNull
  String[] groups();

  /**
   * Retrieves the primary group associated with the specified subject in the given context.
   *
   * @param context the context in which the primary group is being queried; cannot be null
   * @param subject the subject whose primary group is being retrieved; cannot be null
   * @return the name of the primary group associated with the subject within the specified context,
   *         or null if no primary group is defined
   * @since 2.18
   */
  String primaryGroup(@NotNull Context context, @NotNull Subject subject);

  /**
   * Asynchronously retrieves the primary group associated with the specified subject in the given context.
   *
   * @param context the context in which the primary group is being queried; cannot be null
   * @param subject the subject whose primary group is being retrieved; cannot be null
   * @return a {@link CompletableFuture} that completes with the name of the primary group associated with the subject
   *         within the specified context, or completes with null if no primary group is defined
   * @since 2.18
   */
  @NotNull
  CompletableFuture<String> primaryGroupAsync(@NotNull Context context, @NotNull Subject subject);

  /**
   * Retrieves the groups associated with the provided subject in the specified context.
   *
   * @param context the context in which the subject's group memberships are being retrieved; cannot be null
   * @param subject the subject whose group memberships are being retrieved; cannot be null
   * @return an array of group names associated with the subject within the specified context; may be
   *         empty if no groups are associated
   * @since 2.18
   */
  @NotNull
  String[] getGroups(@NotNull Context context, @NotNull Subject subject);

  /**
   * Asynchronously retrieves the groups associated with the specified subject within the given context.
   *
   * @param context the context in which the subject's group memberships are being retrieved; cannot be null
   * @param subject the subject whose group memberships are being retrieved; cannot be null
   * @return a {@link CompletableFuture} that completes with an array of group names associated with the subject
   *         within the specified context; the array may be empty if no groups are associated
   * @since 2.18
   */
  @NotNull
  CompletableFuture<String[]> getGroupsAsync(@NotNull Context context, @NotNull Subject subject);

  /**
   * Determines whether the specified subject is in a group within the given context.
   *
   * @param context the context in which the group membership is being checked; cannot be null
   * @param subject the subject for whom the group membership is being checked; cannot be null
   * @return true if the subject is a member of a group within the specified context; false otherwise
   * @since 2.18
   */
  boolean inGroup(@NotNull Context context, @NotNull Subject subject);

  /**
   * Asynchronously checks if the specified subject is part of a group in the given context.
   *
   * @param context the context in which the group check is performed; must not be null.
   * @param subject the subject to check for group membership; must not be null.
   * @return a CompletableFuture that will be completed with true if the subject is in the group, false otherwise.
   * @since 2.18
   */
  @NotNull
  CompletableFuture<Boolean> inGroupAsync(@NotNull Context context, @NotNull Subject subject);

  /**
   * Assigns the specified subject to a given group within the provided context.
   *
   * @param context the context in which the group assignment is being performed; cannot be null
   * @param subject the subject to be assigned to the group; cannot be null
   * @param group the name of the group the subject should be assigned to; cannot be null
   * @return true if the group was successfully set for the subject, false otherwise
   * @since 2.18
   */
  boolean addGroup(@NotNull Context context, @NotNull Subject subject, @NotNull String group);

  /**
   * Adds a group to the specified subject within the provided context.
   *
   * @param context the operational context in which the group addition should occur, must not be null
   * @param subject the subject to whom the group will be added, must not be null
   * @param group the name of the group to be added, must not be null
   * @return a CompletableFuture that resolves to true if the group was successfully added, or false otherwise
   * @since 2.18
   */
  @NotNull
  CompletableFuture<Boolean> addGroupAsync(@NotNull Context context, @NotNull Subject subject,
                                           @NotNull String group);

  /**
   * Removes the specified subject from the given group within the provided context.
   *
   * @param context the context in which the operation is being performed; cannot be null
   * @param subject the subject to be removed from the group; cannot be null
   * @param group the name of the group the subject should be removed from; cannot be null
   * @return true if the subject was successfully removed from the group, false otherwise
   * @since 2.18
   */
  boolean removeGroup(@NotNull Context context, @NotNull Subject subject, @NotNull String group);

  /**
   * Removes the specified group from the given subject within the provided context.
   *
   * @param context the context in which the group is to be removed, must not be null
   * @param subject the subject from which the group is to be removed, must not be null
   * @param group the name of the group to remove, must not be null
   * @return a CompletableFuture that resolves to a Boolean indicating whether the group was successfully removed
   * @since 2.18
   */
  @NotNull
  CompletableFuture<Boolean> removeGroupAsync(@NotNull Context context, @NotNull Subject subject,
                                              @NotNull String group);

  /**
   * Checks whether the specified group has the given permission for a subject within the context.
   *
   * @param context the context in which the group permission is being checked; cannot be null
   * @param subject the subject for whom the group permission is being checked; cannot be null
   * @param group the name of the group whose permission is being checked; cannot be null
   * @param permission the specific permission identifier to be checked; cannot be null
   * @return a {@link TriState} value indicating the state of the permission for the group,
   *         which can be TRUE, FALSE, or UNDEFINED
   * @since 2.18
   */
  @NotNull
  TriState groupHas(@NotNull Context context, @NotNull Subject subject, @NotNull String group,
                    @NotNull String permission);

  /**
   * Checks if a specific group has a given permission for a subject within a provided context.
   *
   * @param context the context in which the check is performed; must not be null
   * @param subject the subject for which the group's permission is being checked; must not be null
   * @param group the name of the group being checked; must not be null
   * @param permission the permission being checked for the group; must not be null
   * @return a CompletableFuture that resolves to a TriState, indicating whether the group has the
   * specified permission (TRUE, FALSE, or UNDEFINED); never null
   * @since 2.18
   */
  @NotNull
  CompletableFuture<TriState> groupHasAsync(@NotNull Context context, @NotNull Subject subject,
                                            @NotNull String group, @NotNull String permission);

  /**
   * Sets the specified permission for a subject in a given group within a specified context to a desired state.
   *
   * @param context the context in which the group permission is being set; cannot be null
   * @param subject the subject for whom the group permission is being set; cannot be null
   * @param group the name of the group for which the permission is assigned; cannot be null
   * @param permission the identifier of the permission to modify; cannot be null
   * @param value the {@link TriState} value indicating the desired state of the permission; cannot be null
   * @return true if the permission was successfully set for the group, false otherwise
   * @since 2.18
   */
  boolean groupSetPermission(@NotNull Context context, @NotNull Subject subject, @NotNull String group,
                             @NotNull String permission, @NotNull TriState value);

  /**
   * Sets a specific permission for a group associated with a given subject in the provided context.
   * The permission's state can be set to true, false, or undefined using the TriState value.
   *
   * @param context the context in which the group and subject operate, must not be null
   * @param subject the subject for which the permission is being set, must not be null
   * @param group the name of the group for which the permission is being set, must not be null
   * @param permission the permission string to be set for the group, must not be null
   * @param value the TriState value representing the desired state of the permission (true, false, or undefined), must not be null
   * @return a CompletableFuture that completes with a Boolean indicating whether the operation was successful
   * @since 2.18
   */
  @NotNull
  CompletableFuture<Boolean> groupSetPermissionAsync(@NotNull Context context, @NotNull Subject subject,
                                                @NotNull String group, @NotNull String permission,
                                                @NotNull TriState value);

  /**
   * Sets a transient permission for a specific group within a given context and subject.
   * Transient permissions are temporary and do not persist beyond the current runtime.
   *
   * @param context the context in which the permission is being set; cannot be null
   * @param subject the subject for whom the group permission is being set; cannot be null
   * @param group the name of the group for which the transient permission is assigned; cannot be null
   * @param permission the identifier of the permission to modify; cannot be null
   * @param value the {@link TriState} value indicating the desired state of the permission; cannot be null
   * @return true if the transient permission was successfully set for the group, false otherwise
   * @since 2.18
   */
  boolean groupSetTransientPermission(@NotNull Context context, @NotNull Subject subject, @NotNull String group,
                                      @NotNull String permission, @NotNull TriState value);

  /**
   * Sets a transient permission for a specific group within the given subject and context.
   * The permission will only exist for the duration of the running session and is not persisted.
   *
   * @param context the context in which the permission should be applied, must not be null
   * @param subject the subject to which the permission is being applied, must not be null
   * @param group the name of the group the permission applies to, must not be null
   * @param permission the specific permission to be set, must not be null
   * @param value the value of the permission, represented by TriState, must not be null
   * @return a CompletableFuture that completes with a Boolean indicating if the operation was successful
   * @since 2.18
   */
  @NotNull
  CompletableFuture<Boolean> groupSetTransientPermissionAsync(@NotNull Context context, @NotNull Subject subject,
                                                         @NotNull String group, @NotNull String permission,
                                                         @NotNull TriState value);
}