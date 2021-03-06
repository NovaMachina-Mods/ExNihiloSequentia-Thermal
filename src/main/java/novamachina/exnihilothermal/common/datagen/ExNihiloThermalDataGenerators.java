package novamachina.exnihilothermal.common.datagen;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import novamachina.exnihilothermal.common.utility.ExNihiloThermalConstants;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExNihiloThermalDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if(event.includeServer()) {
            generator.addProvider(new ExNihiloThermalRecipeGenerator(generator));
            generator
                    .addProvider(new ExNihiloThermalTagGenerator(generator, new BlockTagsProvider(generator, ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL, event
                            .getExistingFileHelper()), event.getExistingFileHelper()));
        }
        if (event.includeClient()) {
            // Items
            generator.addProvider(new ExNihiloThermalItemGenerator(generator, ExNihiloThermalConstants.ModIds.EX_NIHILO_THERMAL, event.getExistingFileHelper()));
        }
    }
}
