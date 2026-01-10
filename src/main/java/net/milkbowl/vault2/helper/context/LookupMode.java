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

/**
 * Defines the modes used for resolving or retrieving values within a given context.
 *
 * The lookup mode determines how values are queried or resolved:
 * - {@code EXACT}: The lookup is restricted to the specific context provided, without considering any fallback options.
 * - {@code GLOBAL_FALLBACK}: If the lookup in the specific context fails, a fallback resolution is attempted on a global context.
 *
 * @author creatorfromhell
 * @since 2.18
 */
public enum LookupMode {

  EXACT,
  GLOBAL_FALLBACK
}