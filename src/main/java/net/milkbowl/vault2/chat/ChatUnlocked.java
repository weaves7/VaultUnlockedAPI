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

import net.milkbowl.vault2.helper.context.Context;
import net.milkbowl.vault2.helper.subject.Subject;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a chat provider that allows customization and management of prefixes,
 * suffixes, and related information for both individual subjects and groups within
 * a specified context. This interface provides methods to retrieve and modify these
 * properties, as well as to check for feature support for group-based metadata.
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
   * Checks whether the chat provider supports group-based prefixes, suffixes, and info nodes.
   *
   * @return true if group-based prefixes, suffixes and info nodes are supported; false otherwise.
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
   * Asynchronously retrieves the prefix associated with the given subject in the specified context.
   * The computation is executed asynchronously and returns a {@code CompletableFuture} containing
   * an {@code Optional} with the prefix, or an empty {@code Optional} if no prefix is set.
   *
   * @param context the context in which the prefix is being retrieved; must not be null
   * @param subject the subject whose prefix is to be retrieved; must not be null
   * @return a {@code CompletableFuture} containing an {@code Optional} with the prefix if it exists,
   *         or an empty {@code Optional} if no prefix is set
   * @since 2.18
   */
  CompletableFuture<Optional<String>> getPrefixAsync(@NotNull Context context, @NotNull Subject subject);

  /**
   * Retrieves the prefix for the specified subject within the provided context, or null if no prefix exists.
   *
   * @param context the context in which the prefix is being retrieved; must not be null
   * @param subject the subject whose prefix is to be retrieved; must not be null
   * @return the prefix as a string if it exists, or null if no prefix is set
   * @since 2.18
   */
  default String getPrefixOrNull(@NotNull final Context context, @NotNull final Subject subject) {
    return getPrefix(context, subject).orElse(null);
  }


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
   * Asynchronously retrieves the suffix associated with the provided subject
   * within the given context.
   *
   * @param context the context in which to look up the suffix; must not be null
   * @param subject the subject for which the suffix is to be retrieved; must not be null
   * @return a CompletableFuture that resolves to an Optional containing the suffix,
   *         or an empty Optional if no suffix is found
   * @since 2.18
   */
  CompletableFuture<Optional<String>> getSuffixAsync(@NotNull Context context, @NotNull Subject subject);

  /**
   * Retrieves the suffix for the specified subject in the provided context, or returns null if not available.
   *
   * @param context the context in which the suffix is being retrieved, must not be null
   * @param subject the subject for which the suffix is being retrieved, must not be null
   * @return the suffix as a string if available, or null if no suffix is present
   * @since 2.18
   */
  default String getSuffixOrNull(@NotNull final Context context, @NotNull final Subject subject) {
    return getSuffix(context, subject).orElse(null);
  }

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
   * Asynchronously sets a prefix for a given subject within a specified context.
   *
   * @param context the context in which the prefix is being set, must not be null
   * @param subject the subject for which the prefix is being set, must not be null
   * @param prefix the prefix value to be set, must not be null
   * @return a CompletableFuture that resolves to a Boolean indicating whether
   *         the operation was successful
   * @since 2.18
   */
  CompletableFuture<Boolean> setPrefixAsync(@NotNull Context context, @NotNull Subject subject, @NotNull String prefix);

  /**
   * Copies the prefix from one subject to another within a given context.
   *
   * @param context the context in which the operation is performed, must not be null
   * @param from the subject from which the prefix will be copied, must not be null
   * @param to the subject to which the prefix will be applied, must not be null
   * @return true if the prefix was successfully copied, false otherwise
   * @since 2.18
   */
  boolean copyPrefix(@NotNull Context context, @NotNull Subject from, @NotNull Subject to);

  /**
   * Asynchronously copies the prefix from one subject to another within the given context.
   *
   * @param context the context in which the operation is performed; must not be null
   * @param from the subject from which the prefix will be copied; must not be null
   * @param to the subject to which the prefix will be copied; must not be null
   * @return a CompletableFuture that completes with {@code true} if the prefix was successfully copied, or {@code false} otherwise
   * @since 2.18
   */
  CompletableFuture<Boolean> copyPrefixAsync(@NotNull Context context, @NotNull Subject from, @NotNull Subject to);

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
   * Asynchronously sets a suffix for the given subject within the specified context.
   *
   * @param context the context in which the suffix should be applied, must not be null
   * @param subject the subject to which the suffix will be assigned, must not be null
   * @param suffix the suffix to assign to the subject, must not be null
   * @return a CompletableFuture that resolves to a Boolean indicating whether the operation was successful
   * @since 2.18
   */
  CompletableFuture<Boolean> setSuffixAsync(@NotNull Context context, @NotNull Subject subject, @NotNull String suffix);

  /**
   * Copies the suffix from one subject to another within the given context.
   *
   * @param context the context in which the operation is performed, must not be null
   * @param from the subject from which the suffix will be copied, must not be null
   * @param to the subject to which the suffix will be added, must not be null
   * @return true if the suffix was successfully copied, false otherwise
   * @since 2.18
   */
  boolean copySuffix(@NotNull Context context, @NotNull Subject from, @NotNull Subject to);

  /**
   * Asynchronously copies the suffix from one subject to another in the provided context.
   *
   * @param context the context in which the suffix copy operation is performed, must not be null
   * @param from the source subject from which the suffix is copied, must not be null
   * @param to the target subject to which the suffix is copied, must not be null
   * @return a CompletableFuture that completes with true if the suffix was successfully copied,
   *         or false if the operation failed
   * @since 2.18
   */
  CompletableFuture<Boolean> copySuffixAsync(@NotNull Context context, @NotNull Subject from, @NotNull Subject to);

  /**
   * Retrieves the value associated with the specified key for the given subject within the provided context.
   *
   * @param <T>     the type of the value to be retrieved
   * @param context the context in which the value is being retrieved; must not be null
   * @param subject the subject for which the value is being retrieved; must not be null
   * @param key     the key identifying the value to be retrieved; must not be null
   * @return an {@code Optional} containing the value associated with the provided key if it exists; otherwise, an empty {@code Optional}
   * @since 2.18
   */
  <T> Optional<T> get(final Context context, final Subject subject, final InfoKey<T> key);

  /**
   * Retrieves an asynchronous result wrapped in a {@link CompletableFuture}.
   * The result contains an {@link Optional} object that may hold the value corresponding
   * to the specified {@link InfoKey}.
   *
   * @param <T> The type of the value associated with the given {@link InfoKey}.
   * @param context The context in which the asynchronous operation is executed.
   * @param subject The subject associated with the requested operation.
   * @param key The key that identifies the specific data to be retrieved.
   * @return A {@link CompletableFuture} that completes with an {@link Optional} containing
   *         the result, or an empty {@link Optional} if the value is not present.
   * @since 2.18
   */
  <T> CompletableFuture<Optional<T>> getAsync(final Context context, final Subject subject, final InfoKey<T> key);

  /**
   * Retrieves the value associated with the specified key for the given subject within the provided context.
   * If no value is found, the provided default value is returned.
   *
   * @param <T>         the type of the value to be retrieved
   * @param context     the context in which the value is being retrieved; must not be null
   * @param subject     the subject for which the value is being retrieved; must not be null
   * @param key         the key identifying the value to be retrieved; must not be null
   * @param defaultValue the default value to return if no value is found; must not be null
   * @return the value associated with the provided key if it exists; otherwise, the specified default value
   * @since 2.18
   */
  default <T> T getOrDefault(final Context context, final Subject subject, final InfoKey<T> key, final T defaultValue) {
    final Optional<T> value = get(context, subject, key);
    return value.orElse(defaultValue);
  }

  /**
   * Sets the value associated with a specific key for a given subject in the specified context.
   *
   * @param <T>     the type of the value to be set
   * @param context the context in which the operation is performed; must not be null
   * @param subject the subject for which the value is being set; must not be null
   * @param key     the key identifying the value to be set; must not be null
   * @param value   the new value to associate with the given key; must not be null
   * @return true if the value was successfully set, false otherwise
   * @since 2.18
   */
  <T> boolean set(final Context context, final Subject subject, final InfoKey<T> key, final T value);

  /**
   * Asynchronously sets a value in the specified context for the given subject and key.
   *
   * @param context the context in which the value should be set
   * @param subject the subject for which the value is being set
   * @param key the key associated with the value to be set
   * @param value the value to be set
   * @param <T> the type of the value
   * @return a CompletableFuture that resolves to a Boolean indicating whether the operation was successful
   * @since 2.18
   */
  <T> CompletableFuture<Boolean> setAsync(final Context context, final Subject subject, final InfoKey<T> key, final T value);
}