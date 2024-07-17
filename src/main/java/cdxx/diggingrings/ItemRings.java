package cdxx.diggingrings;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ItemRings {

    public static Item HASTE1RING;
    public static Item HASTE2RING;

    public static void load() {
        HASTE1RING = DiggingRings.register(new CustomItem(new Item.Settings(), "item.diggingrings.hasterings.tooltip", "item.diggingrings.haste1ring.tooltip"), "haste1ring");
        HASTE2RING = DiggingRings.register(new CustomItem(new Item.Settings(), "item.diggingrings.hasterings.tooltip", "item.diggingrings.haste2ring.tooltip"), "haste2ring");
    }

    public static class CustomItem extends Item {
        private final String tooltipText1;
        private final String tooltipText2;

        public CustomItem(Settings settings, String tooltipText1, String tooltipText2) {
            super(settings);
            this.tooltipText1 = tooltipText1;
            this.tooltipText2 = tooltipText2;
        }

        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable(this.tooltipText1).formatted(Formatting.BLUE));
            tooltip.add(Text.translatable(this.tooltipText2).formatted(Formatting.GOLD));
        }
    }
}