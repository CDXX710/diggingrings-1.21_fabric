package cdxx.diggingring;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class items_ring {

    public static final Item HASTE1RING;
    public static final Item HASTE2RING;

    static {
        HASTE1RING = registerItem("haste1ring", new Item(new Item.Properties()));
        HASTE2RING = registerItem("haste2ring", new Item(new Item.Properties()));
    }

    public static Item registerItem(String string, Item item) {
        return registerItem(ResourceLocation.withDefaultNamespace(string), item);
    }

    public static Item registerItem(ResourceLocation resourceLocation, Item item) {
        return registerItem(ResourceKey.create(BuiltInRegistries.ITEM.key(), resourceLocation), item);
    }

    public static Item registerItem(ResourceKey<Item> resourceKey, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem) item).registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, resourceKey, item);
    }

    public static void load() {
    }
}

