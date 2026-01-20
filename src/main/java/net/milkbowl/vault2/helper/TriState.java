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

/**
 * Represents a tri-state value that can be TRUE, FALSE, or UNDEFINED.
 *
 * This enum provides a way to manage and interpret values where a third,
 * undefined state is necessary beyond binary truth values. The method
 * asBool() allows for interpreting the TRUE state as a boolean true while
 * treating all other states (FALSE and UNDEFINED) as boolean false.
 *
 * @author creatorfromhell
 * @since 2.18
 */
public enum TriState {

  TRUE,
  FALSE,
  UNDEFINED;

  public boolean asBool() {
    return this == TRUE;
  }
}