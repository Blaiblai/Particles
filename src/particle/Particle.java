package particle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

public class Particle extends JavaPlugin implements Listener {
	
	ArrayList<UUID> happy = new ArrayList<UUID>();
	ArrayList<UUID> unhappy = new ArrayList<UUID>();
	ArrayList<UUID> love = new ArrayList<UUID>();
	ArrayList<UUID> cloud = new ArrayList<UUID>();
	ArrayList<UUID> dust = new ArrayList<UUID>();
	
	public void onEnable() {
		PluginManager reg = Bukkit.getServer().getPluginManager();
		reg.registerEvents(this, this);
		
		ConsoleCommandSender ccs = Bukkit.getServer().getConsoleSender();
		ccs.sendMessage("§3-------------------------------------------");
		ccs.sendMessage("§r");
		ccs.sendMessage("              §bParticles Enabled!           ");
		ccs.sendMessage("§r");
		ccs.sendMessage("§3-------------------------------------------");
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		if (e.getInventory().getName() != "§aParticle Menu") {
			return;
		}
		
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§aHappy Villager")) {
			e.setCancelled(true);
			happy.add(e.getWhoClicked().getUniqueId());
			unhappy.remove(e.getWhoClicked().getUniqueId());
			love.remove(e.getWhoClicked().getUniqueId());
			cloud.remove(e.getWhoClicked().getUniqueId());
			dust.remove(e.getWhoClicked().getUniqueId());
			e.getWhoClicked().closeInventory();
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§cUnhappy Villager")) {
			e.setCancelled(true);
			happy.remove(e.getWhoClicked().getUniqueId());
			unhappy.add(e.getWhoClicked().getUniqueId());
			love.remove(e.getWhoClicked().getUniqueId());
			cloud.remove(e.getWhoClicked().getUniqueId());
			dust.remove(e.getWhoClicked().getUniqueId());
			e.getWhoClicked().closeInventory();
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§4Love <3")) {
			e.setCancelled(true);
			happy.remove(e.getWhoClicked().getUniqueId());
			unhappy.remove(e.getWhoClicked().getUniqueId());
			love.add(e.getWhoClicked().getUniqueId());
			cloud.remove(e.getWhoClicked().getUniqueId());
			dust.remove(e.getWhoClicked().getUniqueId());
			e.getWhoClicked().closeInventory();
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§7Cloudy")) {
			e.setCancelled(true);
			happy.remove(e.getWhoClicked().getUniqueId());
			unhappy.remove(e.getWhoClicked().getUniqueId());
			love.remove(e.getWhoClicked().getUniqueId());
			cloud.add(e.getWhoClicked().getUniqueId());
			dust.remove(e.getWhoClicked().getUniqueId());
			e.getWhoClicked().closeInventory();
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§4R§aa§3i§bn§2b§eo§dw")) {
			e.setCancelled(true);
			happy.remove(e.getWhoClicked().getUniqueId());
			unhappy.remove(e.getWhoClicked().getUniqueId());
			love.remove(e.getWhoClicked().getUniqueId());
			cloud.remove(e.getWhoClicked().getUniqueId());
			dust.add(e.getWhoClicked().getUniqueId());
			e.getWhoClicked().closeInventory();
		}
	}
	@EventHandler
	public void onclick(InventoryClickEvent e) {
		if (e.isRightClick()) {
			
		}
	}
	
	public void createMenu(Player player) {
		Inventory inv = Bukkit.getServer().createInventory(null, InventoryType.HOPPER, "§aParticle Menu");
		
		//1ST ITEMSTACK
		ItemStack is = new ItemStack(Material.EMERALD);
		ItemMeta im = is.getItemMeta();
		
		im.addEnchant(Enchantment.DURABILITY, 1, false);
		im.setDisplayName("§aHappy Villager");
		im.setLore(Arrays.asList("§7Happy Villager Particles."));
		
		is.setItemMeta(im);
		
		inv.setItem(0, is);
		
		player.openInventory(inv);
		
		//2ND ITEMSTACK
		ItemStack is1 = new ItemStack(Material.REDSTONE);
		ItemMeta im1 = is1.getItemMeta();
		
		im1.addEnchant(Enchantment.DURABILITY, 1, false);
		im1.setDisplayName("§cUnhappy Villager");
		im1.setLore(Arrays.asList("§7Unhappy Villager Particles."));
		
		is1.setItemMeta(im1);
		
		inv.setItem(1, is1);
		
		player.openInventory(inv);
		
		
		//3TH ITEMSTACK
		ItemStack is2 = new ItemStack(Material.RED_ROSE);
		ItemMeta im2 = is2.getItemMeta();
		
		im2.addEnchant(Enchantment.DURABILITY, 1, false);
		im2.setDisplayName("§4Love <3");
		im2.setLore(Arrays.asList("§7Love Particles."));
		
		is2.setItemMeta(im2);
		
		inv.setItem(2, is2);
		
		player.openInventory(inv);
		
		//4TH ITEMSTACK
		ItemStack is3 = new ItemStack(Material.WEB);
		ItemMeta im3 = is.getItemMeta();
		
		im3.addEnchant(Enchantment.DURABILITY, 1, false);
		im3.setDisplayName("§7Cloudy");
		im3.setLore(Arrays.asList("§7Cloud Particles."));
		
		is3.setItemMeta(im3);
		
		inv.setItem(3, is3);
		
		player.openInventory(inv);
		
		//5TH ITEMSTACK
		ItemStack is4 = new ItemStack(Material.RED_MUSHROOM);
		ItemMeta im4 = is.getItemMeta();
		
		im4.addEnchant(Enchantment.DURABILITY, 1, false);
		im4.setDisplayName("§4R§aa§3i§bn§2b§eo§dw");
		im4.setLore(Arrays.asList("§7Rainbow Particles."));
		
		is4.setItemMeta(im4);
		
		inv.setItem(4, is4);
		
		player.openInventory(inv);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if (player.hasPermission("particle.menu")) {
		if (cmd.getName().equalsIgnoreCase("particle")) {
			createMenu(player);
			ActionBarAPI.sendActionBar(player, "§cYou have successfully opened the menu");
		}
		}
		if (!player.hasPermission("particle.menu")) {
			
		}
		
		if (cmd.getName().equalsIgnoreCase("particleoff")) {
				happy.remove(player.getUniqueId());
				unhappy.remove(player.getUniqueId());
				love.remove(player.getUniqueId());
				cloud.remove(player.getUniqueId());
				dust.remove(player.getUniqueId());
				ActionBarAPI.sendActionBar(player, "&4All your particles are removed.");
				return true;
			}
		return true;
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onplayermove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (happy.contains(e.getPlayer().getUniqueId())) {
			e.getPlayer().playEffect(p.getLocation(), Effect.HAPPY_VILLAGER, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.HAPPY_VILLAGER, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.HAPPY_VILLAGER, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.HAPPY_VILLAGER, 500);
		}
		if (unhappy.contains(e.getPlayer().getUniqueId())) {
			e.getPlayer().playEffect(p.getLocation(), Effect.VILLAGER_THUNDERCLOUD, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.VILLAGER_THUNDERCLOUD, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.VILLAGER_THUNDERCLOUD, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.VILLAGER_THUNDERCLOUD, 500);
		}
		if (love.contains(e.getPlayer().getUniqueId())) {
			e.getPlayer().playEffect(p.getLocation(), Effect.HEART, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.HEART, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.HEART, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.HEART, 500);
		}
		if (cloud.contains(e.getPlayer().getUniqueId())) {
			e.getPlayer().playEffect(p.getLocation(), Effect.CLOUD, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.CLOUD, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.CLOUD, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.CLOUD, 500);
		}
		if (dust.contains(e.getPlayer().getUniqueId())) {
			e.getPlayer().playEffect(p.getLocation(), Effect.COLOURED_DUST, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.COLOURED_DUST, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.COLOURED_DUST, 500);
			e.getPlayer().playEffect(p.getLocation(), Effect.COLOURED_DUST, 500);
		}
	}
}
