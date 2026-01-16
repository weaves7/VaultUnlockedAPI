package net.milkbowl.vault2.helper.context;
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

import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Represents an operational context that can optionally be associated with a specific world.
 * The context determines the scope in which certain operations or checks, such as permissions, are applied.
 *
 * A global context is represented by the {@code GLOBAL} constant, which is not tied to any specific world.
 *
 * This class provides methods for retrieving the name of the world associated with the context,
 * if any, and is used to manage scoped operations.
 * @author creatorfromhell
 * @since 2.18
 */
public class Context {

  private final Map<String, String> contextValues = new ConcurrentHashMap<>();

  public static final Context GLOBAL = new Context();

  private LookupMode lookupMode = LookupMode.GLOBAL_FALLBACK;

  public Context() {
  }

  /**
   * Constructs a new Context object and associates it with the specified world.
   * The world is stored as part of the context's metadata under the {@code WORLD} key.
   *
   * @param world the name of the world to associate with this context
   */
  public Context(final String world) {
    contextValues.put(ContextKeys.WORLD, world);
  }

  /**
   * Constructs a new {@code Context} object with the specified world and lookup mode.
   * The provided world is stored as part of the context's metadata under the {@code ContextKeys.WORLD} key.
   * Additionally, the lookup mode determines how values are resolved within this context.
   *
   * @param world      the name of the world to associate with this context
   * @param lookupMode the mode of lookup operation to determine how values are resolved
   */
  public Context(final String world, final LookupMode lookupMode) {
    contextValues.put(ContextKeys.WORLD, world);
    this.lookupMode = lookupMode;
  }

  /**
   * Constructs a new Context object with the specified context values.
   * The provided context values map allows for associating additional metadata with the context.
   * If the input map is null, the context will be initialized with no values.
   *
   * @param contextValues a map of key-value pairs representing the context's metadata,
   *                      or null to create an empty context
   */
  public Context(@Nullable final Map<String, String> contextValues) {
    if(contextValues != null) {
      this.contextValues.putAll(contextValues);
    }
  }

  /**
   * Constructs a new Context object with the specified context values and lookup mode.
   * The provided context values map allows for associating additional metadata with the context.
   * If the input map is null, the context will be initialized with no values.
   *
   * @param contextValues a map of key-value pairs representing the context's metadata,
   *                      or null to create an empty context
   * @param lookupMode    the mode of lookup operation to determine how values are resolved
   */
  public Context(@Nullable final Map<String, String> contextValues, final LookupMode lookupMode) {
    if(contextValues != null) {
      this.contextValues.putAll(contextValues);
    }
    this.lookupMode = lookupMode;
  }

  public LookupMode lookupMode() {

    return lookupMode;
  }

  public void lookupMode(final LookupMode lookupMode) {

    this.lookupMode = lookupMode;
  }

  public Optional<String> world() {
    return Optional.ofNullable(contextValues.get(ContextKeys.WORLD));
  }

  @Nullable
  public String worldOrNull() {
    return contextValues.get(ContextKeys.WORLD);
  }

  public Optional<String> value(final String key) {
    return Optional.ofNullable(contextValues.get(key));
  }

  @Nullable
  public String valueOrNull(final String key) {
    return contextValues.get(key);
  }

  public Map<String, String> asMap() {
    return contextValues;
  }

  /**
   * Creates a new {@code Context} object associated with the specified world.
   * The provided {@code world} is stored as part of the context's metadata.
   *
   * @param world the name of the world to associate with the context
   * @return a new {@code Context} instance associated with the specified world
   */
  public static Context fromWorld(final String world) {
    return new Context(world, LookupMode.GLOBAL_FALLBACK);
  }

  /**
   * Creates a new {@code Context} object associated with a specific world and lookup mode.
   * The provided {@code world} is stored within the context's metadata using a predefined key,
   * and the specified {@code lookupMode} determines how values are resolved within the context.
   *
   * @param world      the name of the world to associate with the context
   * @param lookupMode the mode of lookup operation to determine how values are resolved
   * @return a new {@code Context} instance with the specified world and lookup mode
   */
  public static Context fromWorld(final String world, final LookupMode lookupMode) {
    return new Context(world, lookupMode);
  }
}