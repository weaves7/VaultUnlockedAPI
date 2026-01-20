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

/**
 * Represents a key structure used to store and organize information.
 * This class supports generic typing to accommodate different data types.
 *
 * @param <T> the type of the value associated with this key
 * @author creatorfromhell
 * @since 2.18
 */
public class InfoKey<T> {

  private final String node;

  public InfoKey(final String node) {
    this.node = node;
  }

  public String node() {
    return node;
  }

  public static InfoKey<String> stringKey(final String node) {
    return new InfoKey<>(node);
  }

  public static InfoKey<Boolean> boolKey(final String node) {
    return new InfoKey<>(node);
  }

  public static InfoKey<Integer> intKey(final String node) {
    return new InfoKey<>(node);
  }

  public static InfoKey<Double> doubleKey(final String node) {
    return new InfoKey<>(node);
  }
}