package net.milkbowl.vault2.helper.subject;
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
 * Represents the type of a subject, which can either be a player or a group.
 *
 * This enumeration helps differentiate between individual player subjects
 * and group subjects in the context of the application.
 *
 * @author creatorfromhell
 * @since 2.18
 */
public enum SubjectType {

  PLAYER,
  GROUP
}