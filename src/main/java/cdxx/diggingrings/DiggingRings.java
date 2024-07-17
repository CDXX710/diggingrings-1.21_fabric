package cdxx.diggingrings;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiggingRings implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("DiggingRing");

    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of("diggingrings", id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Hasty!");
        ItemRings.load();
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.add(ItemRings.HASTE1RING));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.add(ItemRings.HASTE2RING));

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (PlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (player.getEquippedStack(EquipmentSlot.OFFHAND).getItem() == ItemRings.HASTE1RING) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 10, 0, true, false));
                } else if (player.getEquippedStack(EquipmentSlot.OFFHAND).getItem() == ItemRings.HASTE2RING) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 10, 1, true, false));
                }
            }
        });
    }
}
