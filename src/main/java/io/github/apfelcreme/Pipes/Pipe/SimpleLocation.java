package io.github.apfelcreme.Pipes.Pipe;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

/**
 * Copyright (C) 2016 Lord36 aka Apfelcreme
 * <p>
 * This program is free software;
 * you can redistribute it and/or modify it under the terms of the GNU General
 * Public License as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, see <http://www.gnu.org/licenses/>.
 *
 * @author Lord36 aka Apfelcreme
 */
public class SimpleLocation {

    private final String worldName;
    private final int x;
    private final int y;
    private final int z;

    public SimpleLocation(String worldName, int x, int y, int z) {
        this.worldName = worldName;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public SimpleLocation(Location location) {
        this.worldName = location.getWorld().getName();
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
    }

    /**
     * returns the world name
     *
     * @return the world name
     */
    public String getWorldName() {
        return worldName;
    }

    /**
     * returns the x coordinate
     *
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }


    /**
     * returns the y coordinate
     *
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }


    /**
     * returns the z coordinate
     *
     * @return the z coordinate
     */
    public int getZ() {
        return z;
    }

    /**
     * returns the location that faces the block location to the given side
     *
     * @param face a direction
     * @return the location that faces the block location to the given side
     */
    public SimpleLocation getRelative(BlockFace face) {
        switch (face) {
            case NORTH:
                return new SimpleLocation(worldName, x, y, z - 1);
            case EAST:
                return new SimpleLocation(worldName, x + 1, y, z);
            case SOUTH:
                return new SimpleLocation(worldName, x, y, z + 1);
            case WEST:
                return new SimpleLocation(worldName, x - 1, y, z);
            case UP:
                return new SimpleLocation(worldName, x, y + 1, z);
            case DOWN:
                return new SimpleLocation(worldName, x, y - 1, z);
        }
        return null;
    }

    /**
     * returns a bukkit location
     *
     * @return a bukkit location
     */
    public Location getLocation() {
        return new Location(Bukkit.getServer().getWorld(worldName), x, y, z);
    }

    /**
     * returns a bukkit block
     * @return a bukkit block
     */
    public Block getBlock() {
        World world = Bukkit.getServer().getWorld(worldName);
        if (world != null) {
            return world.getBlockAt(x, y, z);
        }
        return null;
    }

    /**
     * checks if this objects equals another object
     *
     * @param o another SimpleLocation
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleLocation that = (SimpleLocation) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        if (z != that.z) return false;
        return worldName.equals(that.worldName);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "SimpleLocation{" +
                "worldName='" + worldName + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
