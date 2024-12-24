package com.example.ordnancemod.util;

import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrdnanceChunkLoadingCallback implements ForgeChunkManager.LoadingCallback {
    @Override
    public void ticketsLoaded(List<ForgeChunkManager.Ticket> tickets, World world) {
        for (ForgeChunkManager.Ticket ticket : tickets) {
            Set<ChunkCoordIntPair> chunks = ticket.getChunkList();
            List<ChunkCoordIntPair> chunkList = new ArrayList<ChunkCoordIntPair>(chunks);
            for (ChunkCoordIntPair chunk: chunkList) {
                ForgeChunkManager.forceChunk(ticket,chunk);
            }
        }
    }
}
