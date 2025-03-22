package addsynth.core.gameplay.team_manager.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import addsynth.core.ADDSynthCore;
import addsynth.core.util.CommonUtil;
import addsynth.core.util.java.ArrayUtil;
import addsynth.core.util.java.list.Sorters;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public final class CriteriaData {

  private static final ArrayList<ResourceLocation> statistics = new ArrayList<ResourceLocation>();
  private static final ArrayList<Component> blocks = new ArrayList<Component>();
  private static final ArrayList<Component> items_with_durability = new ArrayList<Component>();
  private static final ArrayList<Component> items = new ArrayList<Component>();
  private static final ArrayList<Component> entities = new ArrayList<Component>();
  public static final Component[] standard_criteria = {
    Component.translatable("gui.addsynthcore.team_manager.criteria.dummy"),
    Component.translatable("gui.addsynthcore.team_manager.criteria.trigger"),
    Component.translatable("gui.addsynthcore.team_manager.criteria.death_count"),
    Component.translatable("gui.addsynthcore.team_manager.criteria.player_kills"),
    Component.translatable("gui.addsynthcore.team_manager.criteria.total_kills"),
    Component.translatable("gui.addsynthcore.team_manager.criteria.health"),
    Component.translatable("gui.addsynthcore.team_manager.criteria.xp"),
    Component.translatable("gui.addsynthcore.team_manager.criteria.xp_level"),
    Component.translatable("gui.addsynthcore.team_manager.criteria.air"),
    Component.translatable("gui.addsynthcore.team_manager.criteria.food"),
    Component.translatable("gui.addsynthcore.team_manager.criteria.armor")
  };

  // TODO: Add ability to use ID names or translatable names, not sure if it will be helpful or not.
  public static boolean translate_names;

  public static final void calculate(){
    try{
      calculateBlocks();
      calculateItems();
      calculateStatistics();
      calculateEntities();
    }
    catch(Exception e){
      ADDSynthCore.log.error("Encountered an error while calculating Criteria Data for the Team Manager.", e);
    }
  }
  
  private static final void calculateBlocks(){
    final ArrayList<ResourceLocation> all_blocks = new ArrayList<ResourceLocation>(CommonUtil.getAllBlockIDs());
    Collections.sort(all_blocks, Sorters.NameComparer);
    blocks.clear();
    blocks.ensureCapacity(all_blocks.size());
    for(ResourceLocation id : all_blocks){
      blocks.add(Component.literal(id.toString()));
    }
  }
  
  @SuppressWarnings("null")
  private static final void calculateItems(){
    final Collection<Item> items = CommonUtil.getAllItems();
    final int size = items.size();
    // create new lists
    final ArrayList<String> item_list = new ArrayList<String>(size);
    final ArrayList<String> item_with_durability_list = new ArrayList<String>();
    final IForgeRegistry<Item> registry = ForgeRegistries.ITEMS;
    // add items
    for(Item item : items){
      final String name = registry.getKey(item).toString();
      item_list.add(name);
      if(item.canBeDepleted()){
        item_with_durability_list.add(name);
      }
    }
    // sort alphabetically
    Collections.sort(item_list);
    Collections.sort(item_with_durability_list);
    // create components.
    CriteriaData.items.clear();
    CriteriaData.items.ensureCapacity(size);
    for(String name : item_list){
      CriteriaData.items.add(Component.literal(name));
    }
    CriteriaData.items_with_durability.clear();
    CriteriaData.items_with_durability.ensureCapacity(item_with_durability_list.size());
    for(String name : item_with_durability_list){
      CriteriaData.items_with_durability.add(Component.literal(name));
    }
  }
  
  private static final void calculateStatistics(){
    statistics.clear();
    statistics.addAll(BuiltInRegistries.CUSTOM_STAT.keySet());
    Collections.sort(statistics, Sorters.NameComparer);
  }
  
  private static final void calculateEntities(){
    final ArrayList<ResourceLocation> all_entities = new ArrayList<ResourceLocation>(CommonUtil.getAllEntityIDs());
    Collections.sort(all_entities, Sorters.NameComparer);
    entities.clear();
    entities.ensureCapacity(all_entities.size());
    for(ResourceLocation id : all_entities){
      entities.add(Component.literal(id.toString()));
    }
  }
  
  
  
  
  // Statistics have a client-translated Display Name, so they must be calculated each time,
  // in case the player changes the language in-game.
  public static final Component[] getStatistics(){
    final int length = statistics.size();
    final Component[] statistic_names = new Component[length];
    ResourceLocation id;
    String name;
    Optional<ResourceLocation> statistic;
    int i;
    for(i = 0; i < length; i++){
      id = statistics.get(i);
      name = id.toString();
      statistic = BuiltInRegistries.CUSTOM_STAT.getOptional(id);
      if(statistic.isPresent()){
        statistic_names[i] = Component.translatable("stat."+(name.replace(':', '.')));
      }
      else{
        statistic_names[i] = Component.literal("stat."+(name.replace(':', '.')));
      }
    }
    return statistic_names;
  }
  
  public static final String getStatisticID(int id){
    return ArrayUtil.isInsideBounds(id, statistics.size()) ? statistics.get(id).toString() : "null";
  }
  
  public static final int getStatisticIndex(String statistic_id){
    return statistics.indexOf(new ResourceLocation(statistic_id));
  }
  
  public static final Component[] getAllBlocks(){
    return blocks.toArray(new Component[blocks.size()]);
  }
  
  public static final Component[] getAllItems(){
    return items.toArray(new Component[items.size()]);
  }
  
  public static final Component[] getItemsWithDurability(){
    return items_with_durability.toArray(new Component[items_with_durability.size()]);
  }

  public static final Component[] chat_colors = {
    // the Minecraft colors are translated, however the teams use the TextFormatting colors.
    Component.literal(ChatFormatting.BLACK.getName()),
    Component.literal(ChatFormatting.DARK_BLUE.getName()),
    Component.literal(ChatFormatting.DARK_GREEN.getName()),
    Component.literal(ChatFormatting.DARK_AQUA.getName()),
    Component.literal(ChatFormatting.DARK_RED.getName()),
    Component.literal(ChatFormatting.DARK_PURPLE.getName()),
    Component.literal(ChatFormatting.GOLD.getName()),
    Component.literal(ChatFormatting.GRAY.getName()),
    Component.literal(ChatFormatting.DARK_GRAY.getName()),
    Component.literal(ChatFormatting.BLUE.getName()),
    Component.literal(ChatFormatting.GREEN.getName()),
    Component.literal(ChatFormatting.AQUA.getName()),
    Component.literal(ChatFormatting.RED.getName()),
    Component.literal(ChatFormatting.LIGHT_PURPLE.getName()),
    Component.literal(ChatFormatting.YELLOW.getName()),
    Component.literal(ChatFormatting.WHITE.getName()),
  };

  public static final Component[] getEntities(){
    return entities.toArray(new Component[entities.size()]);
  }

}
