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
 * Provides predefined keys used for defining or interacting with various contexts.
 *
 * This class serves as a centralized repository for context key constants. These keys are
 * utilized within the context management system to identify specific metadata, such as the
 * associated world for a given context.
 *
 * For example, the {@code WORLD} key is used to associate a context with a specific world.
 *
 * This class is designed for use in cases where constants are needed to standardize the
 * management and interaction of context metadata.
 * @author creatorfromhell
 * @since 2.18
 */
public class ContextKeys {

  public static final String WORLD = "world";
}