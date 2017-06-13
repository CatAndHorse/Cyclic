package com.lothrazar.cyclicmagic.net;
import java.util.List;
import com.lothrazar.cyclicmagic.ModCyclic;
import com.lothrazar.cyclicmagic.util.UtilNBT;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketSyncBlocksAirClient implements IMessage, IMessageHandler<PacketSyncBlocksAirClient, IMessage> {
  NBTTagCompound tags = new NBTTagCompound();
  public PacketSyncBlocksAirClient() {}
  public PacketSyncBlocksAirClient(List<BlockPos> actuallyDestroyed) {
    tags = UtilNBT.writeBlockPos(actuallyDestroyed);//new NBTTagCompound();
  }
  @Override
  public void fromBytes(ByteBuf buf) {
    tags = ByteBufUtils.readTag(buf);
  }
  @Override
  public void toBytes(ByteBuf buf) {
    ByteBufUtils.writeTag(buf, this.tags);
  }
  @Override
  public IMessage onMessage(PacketSyncBlocksAirClient message, MessageContext ctx) {
    if (ctx.side == Side.CLIENT) {
      //update it through client proxy
      PacketSyncBlocksAirClient.checkThreadAndEnqueue(message, ctx);
    }
    return null;
  }
  /**
   * 1.8 +: Ensures that the message is being handled on the main thread
   * https://github.com/coolAlias/Tutorial-Demo/blob/master/src/main/java/
   * tutorial/network/AbstractMessage.java#L118-L131
   * http://www.minecraftforge.net/forum/index.php?topic=31853.0
   */
  private static final void checkThreadAndEnqueue(final PacketSyncBlocksAirClient message, final MessageContext ctx) {
    IThreadListener thread = ModCyclic.proxy.getThreadFromContext(ctx);
    // pretty much copied straight from vanilla code, see {@link PacketThreadUtil#checkThreadAndEnqueue}
    thread.addScheduledTask(new Runnable() {
      public void run() {
        List<BlockPos> pos = UtilNBT.readBlockPos(message.tags);
        ModCyclic.logger.info("net size " + pos.size());
        World w = ModCyclic.proxy.getClientWorld();
        int fixes = 0;
        for (BlockPos p : pos) {
          //fff... might not work.  i fond a ghost block wit this check in place
          if (w.isAirBlock(p) == false) {
            if (!w.setBlockToAir(p)) {
              ModCyclic.logger.info(" !!! fix FAILED?   " + w.getBlockState(p).getBlock());
            }
          }
        }
        //      
      }
    });
  }
}
