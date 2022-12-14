package tech.saturns.mcon.commands;


import io.github.rybot666.refutils.RUClass;
import io.github.rybot666.refutils.RUInstance;
import io.github.rybot666.refutils.RefUtilsException;
import net.minecraft.client.MinecraftClient;
import net.minecraft.nbt.NbtCompound;

public class GetNbtCmd extends Command{

    public GetNbtCmd() {
        super("viewNbt");
    }
    
    @Override
    public String call(String args[]) throws RefUtilsException{
        RUClass livingEntity = RUClass.of(instance.getPlayer().getRuClass().getClazz().getSuperclass().getSuperclass().getSuperclass()); //get player as LivingEntity.class
        RUInstance playerAsLivingEntity = livingEntity.instanceFrom(instance.getPlayer().getPlayerCreationInstance()); //instance it


        Object mainHandStack = playerAsLivingEntity.invoke("method_6047"); //.getMainhandStack() method
        RUClass itemStack = RUClass.of(mainHandStack.getClass()); //get ItemStack
        RUInstance mainHandItemStack = itemStack.instanceFrom(mainHandStack); //instance it into item stack
        

        Object thing = mainHandItemStack.invoke("method_7969"); //.getNbt() method
        if(thing != null){
            return "NBT: " + thing.toString();
        }
        return "NBT: null";


    }

}
