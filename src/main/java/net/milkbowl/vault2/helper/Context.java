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

/**
 * Represents a context within which certain operations or data are scoped.
 * A context can optionally be tied to a specific world.
 *
 * This class provides functionality to retrieve the name of the world associated
 * with this context, or operate within a global, world-less context if no specific
 * world is supplied.
 * @author creatorfromhell
 * @since 2.18
 */
public class Context {

  public static final Context GLOBAL = new Context(null);

  private String world;

  public Context(@Nullable final String world) {
    this.world = world;
  }

  @Nullable
  public String world() {
    return world;
  }
}