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

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
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

  private UUID identifier;
  private String name;
  private boolean player;

  public Subject(final UUID identifier, final String name, final boolean player) {

    this.identifier = identifier;
    this.name = name;
    this.player = player;
  }

  @NotNull
  public UUID identifier() {
    return identifier;
  }

  @Nullable
  public Optional<String> name() {
    return Optional.ofNullable(name);
  }

  public boolean isPlayer() {
    return player;
  }
}