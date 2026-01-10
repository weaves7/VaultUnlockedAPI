package net.milkbowl.vault2.helper;
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

import java.util.Optional;

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

  public static final Context GLOBAL = new Context(null);

  private String world;

  /**
   * Constructs a new Context object, optionally associated with a specific world.
   *
   * @param world the name of the world to associate with this context, or null for a global context
   */
  public Context(@Nullable final String world) {
    this.world = world;
  }

  public Optional<String> world() {
    return Optional.ofNullable(world);
  }
}